package com.hwilliams.agroServer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.hwilliams.agroServer.model.Cotizacion;
import com.hwilliams.agroServer.model.CotizacionGrano;

@Service
public class HTMLParser {

	private static final List<String> MERCADOS_INTERES = Arrays.asList("MATBA", "ROFEX");
	private static final List<String> GRANOS_INTERES = Arrays.asList("SOJA", "MAIZ", "TRIGO", "CEBADA");
	
	public Cotizacion getCotizacionDolar() throws IOException{
		return new Cotizacion(Jsoup.connect("http://www.matba.com.ar/").get().select(".ValorDolar").text());
	}
	
	/**
	 * Por cada grano en GRANOS_INTERES, devuelve una lista con sus cotizaciones en MERCADOS_INTERES,<br/>
	 * respetando el orden de esa lista
	 * @return
	 * @throws IOException
	 */
	public Map<String, List<CotizacionGrano>> getValoresMercado() throws IOException{
		Elements full_table = Jsoup.connect("http://www.elrural.com/").get().select(".mercados");
		// Columnas de mercados de interes
		List<Integer> pos_columnas_interes = getColumnsOrder(MERCADOS_INTERES, full_table.select(".columns-header"));
		
		// Las cotizaciones de los granos de interes
		Map<String, List<CotizacionGrano>> cotizaciones_grano = new HashMap<>();
		for (String mercado : GRANOS_INTERES) {
			cotizaciones_grano.put(mercado, new ArrayList<CotizacionGrano>());
		}
		Elements fila_data = full_table.select(".columns-content");
		for (Element fila : fila_data) {
			String grano = getGranoFromFila(fila);
			if(cotizaciones_grano.get(grano.toUpperCase()) != null)
				agregarCotizaciones(cotizaciones_grano.get(grano.toUpperCase()), fila.select(".data"), pos_columnas_interes);	
		}
		
		return cotizaciones_grano;
	}
	
	/**
	 * Teniendo las cotizaciones y las columnas de interes, agrega a la lista de Cotizaciones las que correspondan
	 * @param list
	 * @param cotizaciones
	 * @param pos_columnas_interes 
	 */
	private void agregarCotizaciones(List<CotizacionGrano> list, Elements cotizaciones, List<Integer> pos_columnas_interes) {
		for (Integer pos : pos_columnas_interes) {
			Element cotizacion = cotizaciones.get(pos);
			CotizacionGrano cot = new CotizacionGrano(cotizacion.select(".value").text(), cotizacion.select(".variation").text());
			list.add(cot);
		}
	}

	private String getGranoFromFila(Element fila) {
		return fila.select(".first").text();
	}

	private List<Integer> getColumnsOrder(List<String> mercadosInteres, Elements select) {
		List<Integer> ubicaciones = new ArrayList<>();
		Elements mercados = select.select("li");
		for (int i = 0; i < mercados.size(); i++) {
			if(mercadosInteres.contains(mercados.get(i).text().toUpperCase()))
				ubicaciones.add(i);
		}
		return ubicaciones;
	}

}
