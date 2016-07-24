package com.hwilliams.agroServer.service.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;

import com.hwilliams.agroServer.db.model.Maquina;
import com.hwilliams.agroServer.db.model.ParqueMaquina;
import com.hwilliams.agroServer.db.model.Usuario;
import com.hwilliams.agroServer.service.exception.MaquinaException;

public class BeanFactory {

	@SuppressWarnings("unchecked")
	public static synchronized ParqueMaquina createParqueMaquina(Integer userId, String rubro, List<Maquina> maquinas) {
		if (userId == null)
			throw new RuntimeException("UserId is null");

		ParqueMaquina bean = new ParqueMaquina();
		bean.setUsuarioId(userId);
		bean.setRubro(rubro);
		JSONArray array = new JSONArray();
		for (Maquina maquina : maquinas) {
			array.add(maquina.getId());
		}
		bean.setMaquinasJson(array.toJSONString());
		bean.setEstado(EstadoParqueMaquina.LIBRE.toString());
		return bean;
	}

	public static synchronized Usuario createUsuario(String nombre, String apellido, String tel1, String email) {
		Usuario bean = new Usuario();
		bean.setNombre(nombre);
		bean.setApellido(apellido);
		bean.setTelefono(tel1);
		bean.setEmail(email);
		return bean;
	}

	public static synchronized Maquina createMaquina(String tipo, String marca, String modelo) {
		return createMaquina(tipo, marca, modelo, null);
	}

	public static synchronized Maquina createMaquina(String tipo, String marca, String modelo, String atributosJson) {
		TipoMaquina tipoMaquina = getTipoMaquina(tipo);
		switch (tipoMaquina.getClase()) {
		case 2:
			return createSembradora(tipo, marca, modelo, atributosJson);
		case 3:
			return createLaboreo(tipo, marca, modelo, atributosJson);
		default:
			return createMaquinaBasica(tipo, marca, modelo);
		}
	}

	private static TipoMaquina getTipoMaquina(String tipo) {
		for (TipoMaquina tipoMaquinaPosible : TipoMaquina.values()) {
			if (tipoMaquinaPosible.toString().equalsIgnoreCase(tipo))
				return tipoMaquinaPosible;
		}
		throw new MaquinaException("Tipo maquina [" + tipo + "] no soportado");
	}

	private static Maquina createLaboreo(String tipo, String marca, String modelo, String atributosJson) {
		Maquina maq = createMaquinaBasica(tipo, marca, modelo);
		
		return maq;
	}
	
	private static Maquina createSembradora(String tipo, String marca, String modelo, String atributosJson) {
		Maquina maq = createMaquinaBasica(tipo, marca, modelo);
		
		return maq;
	}
	
	private static Maquina createMaquinaBasica(String tipo, String marca, String modelo) {
		Maquina maq = new Maquina();
		maq.setTipo(tipo);
		maq.setMarca(marca);
		maq.setModelo(modelo);
		return maq;
	}

}
