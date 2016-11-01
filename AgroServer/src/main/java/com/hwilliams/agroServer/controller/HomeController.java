package com.hwilliams.agroServer.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hwilliams.agroServer.controller.util.GenericJsonResponse;
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
	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private CotizacionesService cotizacService;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private ParqueMaquinaService parqueService;

	private static JSONObject maquinasInstance;

	@RequestMapping(value = "")
	public String home() {
		return "Home location. No action available";
	}

	@RequestMapping(value = "initialInfo")
	@ResponseBody
	public GenericJsonResponse getInfo(@RequestParam(value = "username", required = false) String username) {
		logger.info("Obteniendo informacion inicial para usuario [" + username + "]");
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
		String filePath = "C:/Users/Hernan/Dropbox/App-Resources/maquinas.json";
		logger.debug("Obteniendo arquitectura de parques de maquina del archivo [" + filePath + "]");
		if (maquinasInstance != null){
			logger.debug("Archivo en memoria. No hace falta carga");			
			return maquinasInstance;
		}
		try {
			logger.debug("Leyendo archivo");
			maquinasInstance = (JSONObject) new JSONParser().parse( new FileReader(filePath));
			return maquinasInstance;
		} catch (IOException | ParseException e) {
			logger.error(e);
		}
		return new JSONObject();
	}

}
