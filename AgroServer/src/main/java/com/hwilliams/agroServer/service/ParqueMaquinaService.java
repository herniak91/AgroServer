package com.hwilliams.agroServer.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwilliams.agroServer.db.client.MaquinaMapper;
import com.hwilliams.agroServer.db.client.ParqueMaquinaMapper;
import com.hwilliams.agroServer.db.model.Maquina;
import com.hwilliams.agroServer.db.model.MaquinaExample;
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
			if(maquina.getId() != null)
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
	
	public List<ParqueMaquina> buscarParquesMaquina(List<String> rubros, final Double lat, final Double lon){
		ParqueMaquinaExample example = new ParqueMaquinaExample();
		example.createCriteria().andRubroIn(rubros).andEstadoEqualTo(EstadoParqueMaquina.LIBRE.toString());
		List<ParqueMaquina> results = serviceDao.selectByExample(example);
		if(results == null)
			return new ArrayList<ParqueMaquina>();
		
		if(lat != null && lon != null){
			Collections.sort(results, new Comparator<ParqueMaquina>() {
				@Override
				public int compare(ParqueMaquina o1, ParqueMaquina o2) {
					double distO1 = distance(lat, o1.getLat(), lon, o1.getLon(), "K");
					double distO2 = distance(lat, o2.getLat(), lon, o2.getLon(), "K");
					if(distO1 > distO2)
						return 1;
					if(distO1 < distO2)
						return -1;
					return 0;
				}
			});
		}
		
		for (ParqueMaquina parque : results) {
			try {
				JSONArray arrayIds = (JSONArray) new JSONParser().parse(parque.getMaquinasJson());
				MaquinaExample exampleMaquina = new MaquinaExample();
				exampleMaquina.createCriteria().andIdIn(arrayIds);
				List<Maquina> resultMaquinas = maquinaDao.selectByExample(exampleMaquina);
				if (resultMaquinas.size() != arrayIds.size())
					throw new RuntimeException("Diferencia de maquinas encontradas para parque [" + parque.getId() + "]. Esperadas: " + arrayIds.size() + ". Encontradas " + resultMaquinas.size());
				
				for (Maquina maquina : resultMaquinas) {
					maquina.setImagen(null);
				}
				parque.setMaquinas(resultMaquinas);
			} catch (Exception e) {
				results.remove(parque);
			}
		}
		
		return results;
	}
	
	private double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}
		return (dist);
	}
	
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	private ParqueMaquina buscarParqueMaquina(Integer id){
		ParqueMaquina ParqueMaquina = serviceDao.selectByPrimaryKey(id);
		if(ParqueMaquina == null)
			throw new RuntimeException("ParqueMaquina no encontrada");
		return ParqueMaquina;
	}
	
}
