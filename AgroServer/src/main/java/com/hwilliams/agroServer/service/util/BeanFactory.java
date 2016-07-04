package com.hwilliams.agroServer.service.util;

import com.hwilliams.agroServer.db.model.Maquina;
import com.hwilliams.agroServer.db.model.ParqueMaquina;
import com.hwilliams.agroServer.db.model.Usuario;

public class BeanFactory {
	
	public static synchronized ParqueMaquina createParqueMaquina(String propId, String clientId, String maqId, String fechaDesde, String fechaHasta){
		ParqueMaquina bean = new ParqueMaquina();
		try {
			bean.setUsuarioId(Integer.parseInt(propId));
//			bean.setMaquinaId(Integer.parseInt(maqId));
//			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//			bean.setFechaDesde(formatter.parse(fechaDesde));
//			bean.setFechaHasta(formatter.parse(fechaHasta));
		} catch (Exception e) {
			throw new RuntimeException("Error creando ParqueMaquina: " + e.getMessage());
		}
		return bean;
	} 

	public static synchronized Usuario createUsuario(String nombre, String apellido, String tel1, String email){
		Usuario bean = new Usuario();
		bean.setNombre(nombre);
		bean.setApellido(apellido);
		bean.setTelefono(tel1);
		bean.setEmail(email);
		return bean;
	}
	
	public static synchronized Maquina createMaquina(String tipo, String marca, String modelo){
		Maquina maq = new Maquina();
		maq.setTipo(tipo);
		maq.setMarca(marca);
		maq.setModelo(modelo);
		return maq;
	}

}
