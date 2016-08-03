package com.hwilliams.agroServer.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwilliams.agroServer.controller.util.GenericJsonResponse;
import com.hwilliams.agroServer.db.model.Maquina;
import com.hwilliams.agroServer.service.ParqueMaquinaService;

@Controller
@RequestMapping(value = "/Parque")
public class ParqueMaquinaController {

	@Autowired
	private ParqueMaquinaService service;
	
	@RequestMapping(value = "crear")
	@ResponseBody
	public GenericJsonResponse crearParqueMaquina(@RequestParam("jsonString") String jsonString) {
		JSONObject jsonParque = createJSONObject(jsonString);
		String username = (String) jsonParque.get("username");
		String rubro = (String) jsonParque.get("rubro");
		JSONArray maquinasArray = (JSONArray) jsonParque.get("maquinas");
		List<Maquina> maquinas = new ArrayList<>();
		for (Object object : maquinasArray) {
			JSONObject json = (JSONObject) object;
		}
		
		service.crearParqueMaquina(username, rubro, maquinas);
		return GenericJsonResponse.createResponse(null);
	}
	
	@RequestMapping(value="confirmar")
	public void confirmarPrestacion(@RequestParam("userId") String userId, @RequestParam("prestacionId") String prestacionId){
		service.confirmarParqueMaquina(Integer.parseInt(userId), Integer.parseInt(prestacionId));
	}
	
	@RequestMapping(value="cancelar")
	public void denegarPrestacion(@RequestParam("userId") String userId, @RequestParam("prestacionId") String prestacionId){
		service.denegarParqueMaquina(Integer.parseInt(userId), Integer.parseInt(prestacionId));
	}
	
	private JSONObject createJSONObject(String str){
		try {
			return (JSONObject) new JSONParser().parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
