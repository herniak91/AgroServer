package com.hwilliams.agroServer.service.util;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

	private static Maquina createMaquinaBasica(String tipo, String marca, String modelo) {
		Maquina maq = new Maquina();
		maq.setTipo(tipo);
		maq.setMarca(marca);
		maq.setModelo(modelo);
		return maq;
	}

	public static Maquina createMaquinaFromJson(JSONObject json) {
		String tipo = (String) json.get("tipo");
		String marca = (String) json.get("marca");
		String modelo = (String) json.get("modelo");
		Maquina maq = createMaquinaBasica(tipo, marca, modelo);
		maq.setId(Integer.parseInt(String.valueOf(json.get("id"))));
		JSONObject atributos = new JSONObject();
		atributos.put("mapeo", json.get("mapeo"));
		atributos.put("capacidad", json.get("capacidad"));
		atributos.put("tipoTrabajo", json.get("tipoTrabajo"));
		maq.setAtributos(atributos.toJSONString());
//		byte[] imagen = Base64.decodeBase64((String) json.get("imagen"));
//		maq.setImagen(imagen);
		return maq;
	}

}
