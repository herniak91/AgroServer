package com.hwilliams.agroServer.controller;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
	private static JSONObject maquinasInstance;

	@RequestMapping(value = "")
	public String home() {
		return "Home location. No action available";
	}

	@RequestMapping(value = "initialInfo")
	@ResponseBody
	public GenericJsonResponse getInfo(@RequestParam(value = "username", required = false) String username) {
		Map<String, Object> info = new HashMap<>();
		info.put("admin", username == null ? null : perfilService.getUserBasicInfo(username));
		Map<String, Object> cotizaciones = cotizacService.buscarCotizaciones();
		info.put("cotizaciones", cotizaciones.get("granos"));
		info.put("dolar", cotizaciones.get("dolar"));
		info.put("mercados", cotizacService.MERCADOS_INTERES);
		info.put("maquinariaParams", getMaquinasJSON());
		
		return GenericJsonResponse.createResponse(info);
	}

	private JSONObject getMaquinasJSON() {
		if (maquinasInstance != null)
			return maquinasInstance;
		try {
			maquinasInstance = (JSONObject) new JSONParser().parse( new FileReader("C:/Users/Hernan/Dropbox/App-Resources/maquinas.json"));
			return maquinasInstance;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return new JSONObject();
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
