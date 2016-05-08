package com.hwilliams.agroServer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hwilliams.agroServer.model.Usuario;
import com.hwilliams.agroServer.service.UsuarioService;

@RestController
public class Consultas {
	Logger logger = LoggerFactory.getLogger(Consultas.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/test")
	public String test(){
		return "Controllers are up and running.";
	}
	
	@RequestMapping(value="/getGralInformation")
	public Map<String, Object> getGralInformation(){
		logger.debug("Pedido de informacion general");
		Map<String, Object> datos= new HashMap<>();
		datos.put("clima", "hace frio");
		datos.put("dolar", new Double(14.57));
		return datos;
	}
	
	@RequestMapping(value="/getUser")
	public Usuario getuser(@RequestParam(name="name",required=true)String name, @RequestParam(name="lastname",required=true)String lastname){
		logger.debug("Se busco informacion del  usuario de nombre: [" + name + "] y apellido: [" + lastname + "]");
		return usuarioService.getUserById("COTO", "youMammaIsSoFat...");
	}
	
	@RequestMapping(value="/getClima")
	public String getClimaHtml(){
		try {
			return Jsoup.connect("").get().select(".css_class").html();
		} catch (IOException e) {
			e.printStackTrace();
			return "Unable to get or parse html";
		}
	}
	
}
