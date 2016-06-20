package com.hwilliams.agroServer.service;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.hwilliams.agroServer.db.model.Clima;
import com.hwilliams.agroServer.service.util.HTMLParser;

@Service
public class ClimaService {
	
	private static final String URL_CLIMA = "https://weather.com/es-ES/weather/";
//	private static final String URL_CLIMA_LOCAL = URL_CLIMA + "today/l/";
	private static final String URL_CLIMA_LOCAL = "http://www.accuweather.com/es/ar/alberti/7444/hourly-weather-forecast/7444";
	
	public Clima getClimaTodayByLocation(String lat, String lon){
		Document doc;
		Clima clima = new Clima();
		try {
			doc = HTMLParser.getURLContent(URL_CLIMA_LOCAL);
			Elements tabla = doc.select("#detail-hourly");
			if(tabla.size() > 1 || tabla.size() == 0)
				throw new RuntimeException("Se encontro mas de una tabla. Corregir selector");
			String temp = tabla.select(".temp .first-col").get(0).text();
			
		} catch (IOException e) {
			throw new RuntimeException("Error consiguiendo informacion de clima. Excepcion original: " + e.getMessage());
		}
		return clima;
	}
	
	public Clima getClimaByLocation(Float latitud, Float longitud){
		
		
		return new Clima();
	}
	
	
	private Clima createClimaFromDocument(Document doc){
		return null;
	}
	
}
