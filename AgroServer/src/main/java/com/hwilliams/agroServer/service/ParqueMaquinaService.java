package com.hwilliams.agroServer.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwilliams.agroServer.db.client.MaquinaMapper;
import com.hwilliams.agroServer.db.client.ParqueMaquinaMapper;
import com.hwilliams.agroServer.db.model.Maquina;
import com.hwilliams.agroServer.db.model.ParqueMaquina;
import com.hwilliams.agroServer.db.model.ParqueMaquinaExample;
import com.hwilliams.agroServer.service.util.EstadoParqueMaquina;

@Service
public class ParqueMaquinaService {

	@Autowired
	private ParqueMaquinaMapper serviceDao;
	
	@Autowired
	private MaquinaMapper maquinaDao;
	
	@Transactional
	public ParqueMaquina crearParqueMaquina(Integer usuarioId, String rubro, List<Maquina> maquinas){
		ParqueMaquina parque = new ParqueMaquina();
		parque.setUsuarioId(usuarioId);
		parque.setRubro(rubro);
		parque.setEstado(EstadoParqueMaquina.LIBRE.toString());
		List<Integer> maquinasIds = new ArrayList<>();
		for (Maquina maquina : maquinas) {
			if(maquina.getId() == null)
				maquinaDao.insert(maquina);
			maquinasIds.add(maquina.getId());
		}
		JSONArray jsonArr = new JSONArray();
		jsonArr.addAll(maquinasIds);
		parque.setMaquinasJson(jsonArr.toJSONString());
		serviceDao.insert(parque);
		return parque;
	}
	
	
	public void solicitarParqueMaquina(Integer parqueMaquinaId){
		ParqueMaquina parque = buscarParqueMaquina(parqueMaquinaId);
		if(!EstadoParqueMaquina.LIBRE.toString().equalsIgnoreCase(parque.getEstado()))
			throw new RuntimeException("No se puede solicitar parque [" + parque.getId() + "]. Estado actual: " + parque.getEstado());

		parque.setEstado(EstadoParqueMaquina.PEND.toString());
		serviceDao.updateByPrimaryKey(parque);
	}
	
	@Transactional
	public void confirmarParqueMaquina(Integer user, Integer ParqueMaquinaId){
		ParqueMaquina ParqueMaquina = buscarParqueMaquina(ParqueMaquinaId);
		if(!( user == ParqueMaquina.getUsuarioId() ))
			throw new RuntimeException("Usuario [" + user + "] no tiene permisos sobre ParqueMaquina [" + ParqueMaquinaId + "]");
		
		if(EstadoParqueMaquina.PEND.toString().equalsIgnoreCase(ParqueMaquina.getEstado())){
			ParqueMaquina.setEstado(EstadoParqueMaquina.OCUP.toString());
			serviceDao.updateByPrimaryKey(ParqueMaquina);
		}else{
			throw new RuntimeException("Error confirmando ParqueMaquina [" + ParqueMaquina.getId() + "] con estado [" + ParqueMaquina.getEstado() + "]");
		}
	}
	
	@Transactional
	public void denegarParqueMaquina(Integer user, Integer ParqueMaquinaId){
		ParqueMaquina ParqueMaquina = buscarParqueMaquina(ParqueMaquinaId);
		if(user == ParqueMaquina.getUsuarioId()){
			ParqueMaquina.setEstado(EstadoParqueMaquina.LIBRE.toString());
			serviceDao.updateByPrimaryKey(ParqueMaquina);
		}else{
			serviceDao.deleteByPrimaryKey(ParqueMaquinaId);
		}
	}
	
	public List<ParqueMaquina> buscarParquesMaquina(ParqueMaquinaExample example){
		return serviceDao.selectByExample(example);
	}
	
	private ParqueMaquina buscarParqueMaquina(Integer id){
		ParqueMaquina ParqueMaquina = serviceDao.selectByPrimaryKey(id);
		if(ParqueMaquina == null)
			throw new RuntimeException("ParqueMaquina no encontrada");
		return ParqueMaquina;
	}
	
}
