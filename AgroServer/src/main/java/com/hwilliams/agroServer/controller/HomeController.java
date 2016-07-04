package com.hwilliams.agroServer.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hwilliams.agroServer.db.client.UsuarioMapper;
import com.hwilliams.agroServer.db.model.UsuarioExample;
import com.hwilliams.agroServer.service.ClimaService;
import com.hwilliams.agroServer.service.CotizacionesService;

/**
 * Controller para la pantalla Home de la aplicacion
 * 
 * @author Hernan
 */

@RestController
@RequestMapping(value = "/Home")
public class HomeController {

	@Autowired
	private ClimaService climaService;

	@Autowired
	private CotizacionesService cotizacService;

	private static String BUSQUEDA_PARAMETROS;

	@RequestMapping(value = "")
	public String home() {
		return "Home location. No action available";
	}

	@RequestMapping(value = "getInfo")
	@ResponseBody
	public Map<String, Object> getInfo() {
		Map<String, Object> info = new HashMap<>();
		// return climaService.getClimaTodayByLocation("-34.8902249",
		// "-60.060373");
		info.put("cotizaciones", cotizacService.buscarCotizaciones());
		return info;
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
