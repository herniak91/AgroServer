package com.hwilliams.agroServer.service;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.hwilliams.agroServer.bean.Cotizacion;
import com.hwilliams.agroServer.service.util.HTMLParser;

@Service
public class CotizacionesService {

	private static final List<String> MERCADOS_INTERES = Arrays.asList("MATBA", "ROFEX");
	private static final List<String> GRANOS_INTERES = Arrays.asList("SOJA", "MAIZ", "TRIGO", "CEBADA");

	public List<Cotizacion> buscarCotizaciones(){
		List<Cotizacion> cotizaciones = new ArrayList<>();
		try {
			Document doc = HTMLParser.getURLContent("http://www.elrural.com/");
			Elements full_table = doc.select(".mercados");
			Elements data_rows = full_table.select(".columns-content");
			Map<String, Integer> pos_columnas_mercados = getColumnsOrder(MERCADOS_INTERES, full_table.select(".columns-header"));
			cotizaciones = crearCotizaciones(data_rows, pos_columnas_mercados);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cotizaciones;
	}
	
	
	private List<Cotizacion> crearCotizaciones(Elements data_rows, Map<String, Integer> pos_columnas_mercados) {
		List<Cotizacion> cotizaciones = new ArrayList<>();
		for (Element fila_cotizaciones : data_rows) {
			List<Cotizacion> cotizaciones_fila = new ArrayList<>();
			String nombre_grano = fila_cotizaciones.select(".first").get(0).text();
			if(isGranoDeInteres(GRANOS_INTERES,nombre_grano)){
				for (Element contendor_cotizacion : fila_cotizaciones.select(".data")) {
					Cotizacion cot = new Cotizacion();
					cot.setNombre(nombre_grano);
					cot.setValor(contendor_cotizacion.select(".value").get(0).text());
					setearVariacion(cot, contendor_cotizacion);
					cotizaciones_fila.add(cot);
				}
				for (Entry<String, Integer> col_pos : pos_columnas_mercados.entrySet()) {
					Cotizacion cotizacion_buscada = cotizaciones_fila.get(col_pos.getValue());
					cotizacion_buscada.setMercado(col_pos.getKey());
					cotizaciones.add(cotizacion_buscada);
				}
			}
		}
		
		return cotizaciones;
	}
	
	private void setearVariacion(Cotizacion cot, Element contendor_cotizacion) {
		String variacion = contendor_cotizacion.select(".variation").get(0).text();
		if(contendor_cotizacion.select(".down").size() > 0)
			variacion = "-" + variacion;
		if(contendor_cotizacion.select(".up").size() > 0)
			variacion = "-" + variacion;
		cot.setVariacion(variacion);
	}


	private boolean isGranoDeInteres(List<String> granosInteres, String nombre_grano) {
		String str1 = Normalizer.normalize(nombre_grano, Normalizer.Form.NFD);
		String str2 = str1.replaceAll("[^\\p{ASCII}]", "");
		return granosInteres.contains(str2);
	}


	private Map<String, Integer> getColumnsOrder(List<String> mercadosInteres, Elements select) {
		Map<String, Integer> ubicaciones = new HashMap<>();
		Elements mercados = select.select("li");
		for (int i = 0; i < mercados.size(); i++) {
			if (mercadosInteres.contains(mercados.get(i).text().toUpperCase()))
				ubicaciones.put(mercados.get(i).text().toUpperCase(), i);
		}
		return ubicaciones;
	}

}
