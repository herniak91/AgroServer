package com.hwilliams.agroServer.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hwilliams.agroServer.controller.util.GenericJsonResponse;
import com.hwilliams.agroServer.db.model.Maquina;
import com.hwilliams.agroServer.db.model.ParqueMaquina;
import com.hwilliams.agroServer.service.CotizacionesService;
import com.hwilliams.agroServer.service.ParqueMaquinaService;
import com.hwilliams.agroServer.service.PerfilService;

/**
 * Controller para la pantalla Home de la aplicacion
 * 
 * @author Hernan
 */

@RestController
@RequestMapping(value = "/Home")
public class HomeController {

	@Autowired
	private CotizacionesService cotizacService;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private ParqueMaquinaService parqueService;

	private static String BUSQUEDA_PARAMETROS;

	@RequestMapping(value = "")
	public String home() {
		return "Home location. No action available";
	}

	@RequestMapping(value = "initialInfo")
	@ResponseBody
	public GenericJsonResponse getInfo(@RequestParam(value = "username", required = false) String username) {
		Map<String, Object> info = new HashMap<>();
		username = "hernan.federico.williams";
		info.put("admin", username == null ? null : getUserBasicInfo(username));
		Map<String, Object> cotizaciones = cotizacService.buscarCotizaciones();
		info.put("cotizaciones", cotizaciones.get("granos"));
		info.put("dolar", cotizaciones.get("dolar"));
		info.put("mercados", cotizacService.MERCADOS_INTERES);
		
		return GenericJsonResponse.createResponse(info);
	}

	private JSONArray getUserBasicInfo(String username) {
		JSONArray listParques = new JSONArray();
		Map<ParqueMaquina, List<Maquina>> map = parqueService.buscarParquesMaquina(username);
		for (Entry<ParqueMaquina, List<Maquina>> mapEntry : map.entrySet()) {
			for (Maquina maquina : mapEntry.getValue()) {
				maquina.setImagen(null);
			}
			JSONObject parque = new JSONObject();
			parque.put("parque", mapEntry.getKey());
			parque.put("maquinas", mapEntry.getValue());
			listParques.add(parque);
		}
		return listParques;
	}

	private String getParametrosBusqueda() {
		if (BUSQUEDA_PARAMETROS == null) {
			byte[] encoded;
			try {
				encoded = Files.readAllBytes(Paths.get(""));
				return new String(encoded);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return BUSQUEDA_PARAMETROS;
	}

}
