package com.hwilliams.agroServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwilliams.agroServer.db.model.Prestacion;
import com.hwilliams.agroServer.service.PrestacionesService;
import com.hwilliams.agroServer.service.util.BeanFactory;

@Controller
@RequestMapping(value = "/Prestacion")
public class PrestacionController {

	@Autowired
	private PrestacionesService service;
	
	@RequestMapping(value = "solicitar")
	public void solicitarPrestacion(@RequestParam("propietarioId") String propietarioId, @RequestParam("maquina_id") String maquinaId,
			@RequestParam("clienteId") String clienteId, @RequestParam("fechaDesde") String fechaDesde,
			@RequestParam("fechaHasta") String fechaHasta) {
		
		Prestacion prestacion = BeanFactory.createPrestacion(propietarioId, clienteId, maquinaId, fechaDesde, fechaHasta);
		service.solicitarPrestacion(prestacion);
	}
	
	@RequestMapping(value="confirmar")
	public void confirmarPrestacion(@RequestParam("userId") String userId, @RequestParam("prestacionId") String prestacionId){
		service.confirmarPrestacion(Integer.parseInt(userId), Integer.parseInt(prestacionId));
	}
	
	@RequestMapping(value="cancelar")
	public void denegarPrestacion(@RequestParam("userId") String userId, @RequestParam("prestacionId") String prestacionId){
		service.denegarPrestacion(Integer.parseInt(userId), Integer.parseInt(prestacionId));
	}
}
