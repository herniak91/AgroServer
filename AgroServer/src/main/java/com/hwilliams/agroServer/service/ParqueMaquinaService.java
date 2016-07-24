package com.hwilliams.agroServer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonObject;
import com.hwilliams.agroServer.db.client.MaquinaMapper;
import com.hwilliams.agroServer.db.client.ParqueMaquinaMapper;
import com.hwilliams.agroServer.db.model.Maquina;
import com.hwilliams.agroServer.db.model.ParqueMaquina;
import com.hwilliams.agroServer.db.model.ParqueMaquinaExample;
import com.hwilliams.agroServer.db.model.Usuario;
import com.hwilliams.agroServer.service.util.BeanFactory;
import com.hwilliams.agroServer.service.util.EstadoParqueMaquina;

@Service
public class ParqueMaquinaService {

	@Autowired
	private ParqueMaquinaMapper serviceDao;
	
	@Autowired 
	private PerfilService perfilService;
	
	@Autowired
	private MaquinaMapper maquinaDao;
	
	@Transactional
	public ParqueMaquina crearParqueMaquina(String username, String rubro, List<Maquina> maquinas){
		Usuario user = perfilService.buscarUsuario(username);
		for (Maquina maquina : maquinas) {
			maquinaDao.insert(maquina);
		}
		ParqueMaquina parque = BeanFactory.createParqueMaquina(user.getId(), rubro, maquinas);
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
	
	public Map<ParqueMaquina, List<Maquina>> buscarParquesMaquina(String username){
		Map<ParqueMaquina, List<Maquina>> map = new HashMap<>();
		Usuario user = perfilService.buscarUsuario(username);
		ParqueMaquinaExample example = new ParqueMaquinaExample();
		example.createCriteria().andUsuarioIdEqualTo(user.getId());
		List<ParqueMaquina> results = serviceDao.selectByExample(example);
		for (ParqueMaquina parque : results) {
			List<Maquina> maquinas = new ArrayList<>();
			try {
				JSONArray arrayIds = (JSONArray) new JSONParser().parse(parque.getMaquinasJson());
				for (Object id : arrayIds) {
					maquinas.add(maquinaDao.selectByPrimaryKey(Math.toIntExact((long) id)));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			map.put(parque, maquinas);
		}
		
		return map;
	}
	
	private ParqueMaquina buscarParqueMaquina(Integer id){
		ParqueMaquina ParqueMaquina = serviceDao.selectByPrimaryKey(id);
		if(ParqueMaquina == null)
			throw new RuntimeException("ParqueMaquina no encontrada");
		return ParqueMaquina;
	}
	
}
