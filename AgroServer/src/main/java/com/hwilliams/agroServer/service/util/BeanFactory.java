package com.hwilliams.agroServer.service.util;

import java.text.SimpleDateFormat;

import com.hwilliams.agroServer.db.model.Prestacion;
import com.hwilliams.agroServer.db.model.Usuario;

public class BeanFactory {
	
	public static synchronized Prestacion createPrestacion(String propId, String clientId, String maqId, String fechaDesde, String fechaHasta){
		Prestacion bean = new Prestacion();
		try {
			bean.setPropietarioId(Integer.parseInt(propId));
			bean.setClienteId(Integer.parseInt(clientId));
			bean.setMaquinaId(Integer.parseInt(maqId));
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			bean.setFechaDesde(formatter.parse(fechaDesde));
			bean.setFechaHasta(formatter.parse(fechaHasta));
		} catch (Exception e) {
			throw new RuntimeException("Error creando prestacion: " + e.getMessage());
		}
		return bean;
	} 

	public static synchronized Usuario createUsuario(String nombre, String apellido, String tel1, String email){
		Usuario bean = new Usuario();
		bean.setNombre(nombre);
		bean.setApellido(apellido);
		bean.setTelefono1(tel1);
		bean.setEmail(email);
		return bean;
	}
	
	public static synchronized Usuario createUsuario(String nombre, String apellido, String tel1, String tel2, String email){
		Usuario bean = createUsuario(nombre, apellido, tel1, email);
		bean.setTelefono2(tel2);
		return bean;
	}
}
