package com.hwilliams.agroServer.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwilliams.agroServer.service.ParqueMaquinaService;

@Controller
@RequestMapping(value = "/Prestacion")
public class ParqueMaquinaController {

	@Autowired
	private ParqueMaquinaService service;
	
	@RequestMapping(value = "crear")
	public void solicitarPrestacion(@RequestBody JSONObject jsonParque) {
	
		
		
//		ParqueMaquina prestacion = BeanFactory.createParqueMaquina(propietarioId, clienteId, maquinaId, fechaDesde, fechaHasta);
//		service.crearParqueMaquina(usuarioId, rubro, maquinas);
	}
	
	@RequestMapping(value="confirmar")
	public void confirmarPrestacion(@RequestParam("userId") String userId, @RequestParam("prestacionId") String prestacionId){
		service.confirmarParqueMaquina(Integer.parseInt(userId), Integer.parseInt(prestacionId));
	}
	
	@RequestMapping(value="cancelar")
	public void denegarPrestacion(@RequestParam("userId") String userId, @RequestParam("prestacionId") String prestacionId){
		service.denegarParqueMaquina(Integer.parseInt(userId), Integer.parseInt(prestacionId));
	}
}
