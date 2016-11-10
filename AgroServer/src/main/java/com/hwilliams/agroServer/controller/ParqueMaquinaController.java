package com.hwilliams.agroServer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwilliams.agroServer.controller.util.GenericJsonResponse;
import com.hwilliams.agroServer.db.model.Maquina;
import com.hwilliams.agroServer.db.model.ParqueMaquina;
import com.hwilliams.agroServer.service.ParqueMaquinaService;
import com.hwilliams.agroServer.service.util.BeanFactory;

@Controller
@RequestMapping(value = "/Parque")
public class ParqueMaquinaController {
	private static final Logger logger = Logger.getLogger(ParqueMaquinaController.class);

	@Autowired
	private ParqueMaquinaService service;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "crear")
	@ResponseBody
	public GenericJsonResponse crearParqueMaquina(@RequestParam("jsonString") String jsonString) {
		logger.info("Iniciando creacion de Parque de Maquinas");
		JSONObject jsonParque = createJSONObject(jsonString);
		String username = (String) jsonParque.get("username");
		String rubro = (String) jsonParque.get("rubro");
		Double lat = (Double) jsonParque.get("lat");
		Double lon = (Double) jsonParque.get("lon");
		JSONArray maquinasArray = (JSONArray) jsonParque.get("maquinas");
		List<Maquina> maquinas = new ArrayList<>();
		for (Object object : maquinasArray) {
			JSONObject json = (JSONObject) object;
			maquinas.add(BeanFactory.createMaquinaFromJson(json));
		}
		ParqueMaquina parqueCreado = service.crearParqueMaquina(username, rubro, maquinas, lat, lon);
		JSONArray listParques = new JSONArray();
		JSONObject parque = new JSONObject();
		parque.put("parque", parqueCreado);
		parque.put("maquinas", maquinas);
		listParques.add(parque);
		return GenericJsonResponse.createResponse(listParques);
	}
	
	@RequestMapping(value = "editar")
	@ResponseBody
	public GenericJsonResponse editarParqueMaquina(@RequestParam("jsonString") String jsonString) {
		logger.info("Iniciando edicion de Parque de Maquinas");
		JSONObject jsonParque = createJSONObject(jsonString);
		JSONObject parqueAModificar = (JSONObject) jsonParque.get("parque");
		JSONArray maquinasArray = (JSONArray) jsonParque.get("maquinas");
		List<Maquina> maquinas = new ArrayList<>();
		for (Object object : maquinasArray) {
			JSONObject json = (JSONObject) object;
			maquinas.add(BeanFactory.createMaquinaFromJson(json));
		}
		
//		ParqueMaquina parqueCreado = service.editarParqueMaquina(parque, maquinas);
		JSONArray listParques = new JSONArray();
//		JSONObject parqueModificado = new JSONObject();
//		parqueModificado.put("parque", parqueCreado);
//		parqueModificado.put("maquinas", maquinas);
//		listParques.add(parqueModificado);
		return GenericJsonResponse.createResponse(listParques);
	}
	
	@RequestMapping(value="confirmar")
	public void confirmarPrestacion(@RequestParam("userId") String userId, @RequestParam("prestacionId") String prestacionId){
		logger.info("Confirmacion de prestacion de Parque de Maquina con ID [" + prestacionId + "] al usuario [" + prestacionId + "]");
		service.confirmarParqueMaquina(Integer.parseInt(userId), Integer.parseInt(prestacionId));
	}
	
	@RequestMapping(value="cancelar")
	public void denegarPrestacion(@RequestParam("userId") String userId, @RequestParam("prestacionId") String prestacionId){
		logger.info("Cancelacion de prestacion de Parque de Maquina con ID [" + prestacionId + "] al usuario [" + prestacionId + "]");
		service.denegarParqueMaquina(Integer.parseInt(userId), Integer.parseInt(prestacionId));
	}
	
	@RequestMapping(value = "buscar")
	@ResponseBody
	public GenericJsonResponse buscarParqueMaquina(@RequestParam("jsonString") String jsonString) {
		logger.info("Iniciando busqueda de Parque de Maquina");
		JSONObject json = createJSONObject(jsonString);
		Double lat = (Double) json.get("lat");
		Double lon = (Double) json.get("lon");
		JSONArray rubros = (JSONArray) json.get("rubros");
		List<ParqueMaquina> results = service.buscarParquesMaquina(rubros, lat, lon);
		return GenericJsonResponse.createResponse(results);
	}
	
	@RequestMapping(value="buscarEnDetalle")
	@ResponseBody
	public Map<String, Object> buscarEnDetalle(@RequestParam("prestacionId") String prestacionId){
		logger.info("Iniciando busqueda en detalle de Parque de Maquina con ID [" + prestacionId + "]");
		return service.buscarPrestacionEnDetalle(Integer.parseInt(prestacionId));
	}
	
	@RequestMapping(value="borrar")
	@ResponseBody
	public Integer borrarPrestacion(@RequestParam("prestacionId") String prestacionId){
		logger.info("Borrado de prestacion de Parque de Maquina con ID [" + prestacionId + "]");
		try {
			service.borrarPrestacion(Integer.parseInt(prestacionId));
			return 0;
		} catch (Exception e) {
			logger.error(e);
			return 1;
		}
	}
	
	
	
	private JSONObject createJSONObject(String str){
		try {
			logger.debug("Creando JSONObject a partir de [" + str + "]");
			return (JSONObject) new JSONParser().parse(str);
		} catch (ParseException e) {
			logger.error(e);
			throw new RuntimeException();
		}
	}
}
