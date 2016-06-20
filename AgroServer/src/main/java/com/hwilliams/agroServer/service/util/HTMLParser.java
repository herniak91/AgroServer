package com.hwilliams.agroServer.service.util;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLParser {

	private static Map<String, String> ubicaciones;
	
	public static synchronized Document getURLContent(String url) throws IOException{
		return Jsoup.connect(url).get();
	}
	
	public void getClimaByLocation(String ubicacion) throws IOException{
		Jsoup.connect("https://weather.com/es-ES/weather/today/l/" + ubicaciones.get(ubicacion.toUpperCase())).get();
	}
}
