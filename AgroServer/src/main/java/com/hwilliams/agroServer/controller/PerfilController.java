package com.hwilliams.agroServer.controller;

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
	public GenericJsonResponse login(@RequestParam("id") Integer id, @RequestParam("password") String password){
		System.out.println("ID: " + id + " y Password: " + password);
		Usuario user = service.loginUsuario(id, password);
		return GenericJsonResponse.createErrorResponse(user);
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
	
	@RequestMapping(value = "borrar")
	public void borrarPerfil() {

	}
	
	private <T> T createObject(String json, Class T){
		return (T) new Gson().fromJson(json, T);
	}
	
}
