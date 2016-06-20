package com.hwilliams.agroServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwilliams.agroServer.service.PerfilService;
import com.hwilliams.agroServer.service.util.BeanFactory;

@Controller
@RequestMapping(value = "/Perfil")
public class PerfilController {

	@Autowired
	private PerfilService service;
	
	@RequestMapping(value = "crear")
	public void crearPerfil(@RequestParam(name = "nombre", required = true) String nombre,
			@RequestParam(name = "apellido", required = true) String apellido, @RequestParam(name = "tel1", required = true) String tel1,
			@RequestParam(name = "tel2", required = false) String tel2, @RequestParam(name = "email", required = false) String email) {
		service.crearPerfil(BeanFactory.createUsuario(nombre, apellido, tel1, tel2, email));
	}

	@RequestMapping(value = "actualizar")
	public void actualizarPerfil(@RequestParam(name = "userId", required = true) String userId,@RequestParam(name = "nombre", required = false) String nombre,
			@RequestParam(name = "apellido", required = false) String apellido, @RequestParam(name = "tel1", required = false) String tel1,
			@RequestParam(name = "tel2", required = false) String tel2, @RequestParam(name = "email", required = false) String email){
		
		service.actualizarPerfil(Integer.parseInt(userId), BeanFactory.createUsuario(nombre, apellido, tel1, tel2, email));
	}

	@RequestMapping(value = "borrar")
	public void borrarPerfil(@RequestParam("userId") String userId) {

	}
}
