package com.hwilliams.agroServer.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hwilliams.agroServer.db.model.Usuario;
import com.hwilliams.agroServer.service.PerfilService;

@Controller
@RequestMapping(value = "/Perfil")
public class PerfilController {
	
	@Autowired
	private PerfilService service;
	
	@RequestMapping(value = "crear", method = RequestMethod.POST)
	@ResponseBody
	public Usuario crearPerfil(@RequestBody String jsonUser) {
		Usuario user = createObject(jsonUser, Usuario.class);
		service.crearPerfil(user);
		return user;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Usuario login(@RequestParam("id") Integer id, @RequestParam("password") String password){
		Usuario user = service.loginUsuario(id, password);
		return user;
	}

	@RequestMapping(value = "actualizar")
	@ResponseBody
	public Usuario actualizarPerfil(@RequestBody String jsonUser){
		Usuario user = createObject(jsonUser, Usuario.class);
		service.actualizarPerfil(user, user);
		return user;
	}
	
	@RequestMapping(value = "borrar")
	public void borrarPerfil() {

	}
	
	private <T> T createObject(String json, Class T){
		return (T) new Gson().fromJson(json, T);
	}
	
}
