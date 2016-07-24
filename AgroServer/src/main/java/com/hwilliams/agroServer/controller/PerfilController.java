package com.hwilliams.agroServer.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hwilliams.agroServer.controller.util.GenericJsonResponse;
import com.hwilliams.agroServer.db.model.Usuario;
import com.hwilliams.agroServer.service.PerfilService;

@Controller
@RequestMapping(value = "/Perfil")
public class PerfilController {
	
	@Autowired
	private PerfilService service;
	
	@RequestMapping(value = "crear", method = RequestMethod.POST)
	@ResponseBody
	public GenericJsonResponse crearPerfil(@RequestParam("jsonString") String jsonString) {
		Usuario user = createObject(jsonString, Usuario.class);
		service.crearPerfil(user);
		return GenericJsonResponse.createErrorResponse(user);
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public GenericJsonResponse login(@RequestParam("jsonString") String jsonString){
		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(jsonString);
			String username = (String) json.get("username");
			String password = (String) json.get("password");
			System.out.println("Username: " + username + " y Password: " + password);
			Usuario user = service.loginUsuario(username, password);
			return GenericJsonResponse.createResponse(user);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return GenericJsonResponse.createErrorResponse(null);
	}

	@RequestMapping(value = "actualizar")
	@ResponseBody
	public GenericJsonResponse actualizarPerfil(@RequestBody String jsonUser){
		Usuario user = createObject(jsonUser, Usuario.class);
		service.actualizarPerfil(user, user);
		return GenericJsonResponse.createErrorResponse(user);
	}
	
	@RequestMapping(value = "verificarUsername")
	@ResponseBody
	public Integer verificarUsername(@RequestParam("username") String username){
		if (service.verificarUsername(username))
			return 0;
		return 1;
	}
	
	@RequestMapping(value = "actualizarPass123")
	@ResponseBody
	public boolean actualizarPass123(@RequestParam("username") String username, @RequestParam("password") String password){
		service.actualizarContrasenia(username, password);
		return true;
	}
	
	@RequestMapping(value = "borrar")
	public void borrarPerfil() {

	}
	
	private <T> T createObject(String json, Class T){
		return (T) new Gson().fromJson(json, T);
	}
	
}
