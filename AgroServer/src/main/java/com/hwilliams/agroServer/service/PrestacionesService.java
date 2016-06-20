package com.hwilliams.agroServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwilliams.agroServer.db.client.PrestacionMapper;
import com.hwilliams.agroServer.db.model.Prestacion;
import com.hwilliams.agroServer.service.util.EstadoPrestacion;

@Service
public class PrestacionesService {

	@Autowired
	private PrestacionMapper dao;
	
	@Transactional
	public void solicitarPrestacion(Prestacion prestacion){
		dao.insert(prestacion);
	}
	
	@Transactional
	public void confirmarPrestacion(Integer user, Integer prestacionId){
		Prestacion prestacion = buscarPrestacion(prestacionId);
		if(!( user == prestacion.getPropietarioId() ))
			throw new RuntimeException("Usuario [" + user + "] no tiene permisos sobre prestacion [" + prestacionId + "]");
		
		if(EstadoPrestacion.PEND.toString().equalsIgnoreCase(prestacion.getEstado())){
			prestacion.setEstado(EstadoPrestacion.OK.toString());
			dao.updateByPrimaryKey(prestacion);
		}else{
			throw new RuntimeException("Error confirmando prestacion [" + prestacion.getId() + "] con estado [" + prestacion.getEstado() + "]");
		}
	}
	
	@Transactional
	public void denegarPrestacion(Integer user, Integer prestacionId){
		Prestacion prestacion = buscarPrestacion(prestacionId);
		if(!( user == prestacion.getPropietarioId()) || !( user == prestacion.getClienteId()))
			throw new RuntimeException("Usuario [" + user + "] no tiene permisos sobre prestacion [" + prestacionId + "]");
		
		if(user == prestacion.getPropietarioId()){
			prestacion.setEstado(EstadoPrestacion.ERR.toString());
			dao.updateByPrimaryKey(prestacion);
		}else{
			dao.deleteByPrimaryKey(prestacionId);
		}
	}
	
	private Prestacion buscarPrestacion(Integer id){
		Prestacion prestacion = dao.selectByPrimaryKey(id);
		if(prestacion == null)
			throw new RuntimeException("Prestacion no encontrada");
		return prestacion;
	}
	
}
