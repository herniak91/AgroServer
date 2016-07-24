package com.hwilliams.agroServer.service;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.hwilliams.agroServer.bean.Cotizacion;

@Service
public class CotizacionesService {

	public static final List<String> MERCADOS_INTERES = Arrays.asList("CHICAGO", "MATBA", "ROFEX");
	private static final List<String> GRANOS_INTERES = Arrays.asList("SOJA", "MAIZ", "TRIGO");

	public Map<String, Object> buscarCotizaciones() {
		Map<String, Object> map = new HashMap<>();
		try {
			Document doc = Jsoup.connect("http://www.elrural.com/").timeout(10*1000).get();
			map.put("granos", buscarCotizacionesGranos(doc));
			map.put("dolar", buscarCotizacionDolar(doc));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	private List<Cotizacion> buscarCotizacionesGranos(Document doc) {
		List<Cotizacion> cotizaciones = new ArrayList<>();
		Elements full_table = doc.select(".mercados");
		Elements data_rows = full_table.select(".columns-content");
		Map<String, Integer> pos_columnas_mercados = getColumnsOrder(MERCADOS_INTERES, full_table.select(".columns-header"));
		cotizaciones = crearCotizaciones(data_rows, pos_columnas_mercados);
		return cotizaciones;
	}

	private JSONObject buscarCotizacionDolar(Document doc) {
		JSONObject obj = new JSONObject();
		Elements mainContainer = doc.select(".finanzas .first");
		Elements compra = mainContainer.select(".colA .data");
		obj.put("compra", compra.select(".value").get(0).text());
		Elements venta = mainContainer.select(".colB .data");
		obj.put("venta", venta.select(".value").get(0).text());
		return obj;
	}

	private List<Cotizacion> crearCotizaciones(Elements data_rows, Map<String, Integer> pos_columnas_mercados) {
		List<Cotizacion> cotizaciones = new ArrayList<>();
		for (Element fila_cotizaciones : data_rows) {
			List<Cotizacion> cotizaciones_fila = new ArrayList<>();
			String nombre_grano = fila_cotizaciones.select(".first").get(0).text();
			if (isGranoDeInteres(GRANOS_INTERES, nombre_grano)) {
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
		if (contendor_cotizacion.select(".down").size() > 0)
			cot.setIndicador("-");
		if (contendor_cotizacion.select(".up").size() > 0)
			cot.setIndicador("+");
		cot.setVariacion(contendor_cotizacion.select(".variation").get(0).text());
	}

	private boolean isGranoDeInteres(List<String> granosInteres, String nombre_grano) {
		String str1 = Normalizer.normalize(nombre_grano, Normalizer.Form.NFD);
		String str2 = str1.replaceAll("[^\\p{ASCII}]", "");
		return granosInteres.contains(str2);
	}

	private Map<String, Integer> getColumnsOrder(List<String> mercadosInteres, Elements select) {
		Map<String, Integer> ubicaciones = new HashMap<>();
		Elements mercados = select.select("li");
		mercados.remove(0);
		for (int i = 0; i < mercados.size(); i++) {
			if (mercadosInteres.contains(mercados.get(i).text().toUpperCase()))
				ubicaciones.put(mercados.get(i).text().toUpperCase(), i);
		}
		return ubicaciones;
	}

}
