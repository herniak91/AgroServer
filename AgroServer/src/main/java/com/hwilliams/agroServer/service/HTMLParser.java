package com.hwilliams.agroServer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.hwilliams.agroServer.model.Cotizacion;

@Service
public class HTMLParser {

	private static final List<String> MERCADOS_INTERES = Arrays.asList("MATBA", "ROFEX");
	private static final List<String> GRANOS_INTERES = Arrays.asList("SOJA", "MAIZ", "TRIGO", "CEBADA");
	
	public void getValoresMercado() throws IOException{
//		List<String, List<Cotizacion>> cotizaciones = new ArrayList<>();
//		for (String mercado : MERCADOS_INTERES) {
//			cotizaciones.add(mercado, new ArrayList<Cotizacion>());
//		}
//		
//		Elements full_table = Jsoup.connect("http://www.elrural.com/").get().select(".mercados");
//		List<Integer> pos_columnas_interes = getColumnsOrder(MERCADOS_INTERES, full_table.select(".columns-header"));
//		
//		Elements fila_data = full_table.select(".columns-content");
//		for (Element fila : fila_data) {
//			String grano = fila.select(".first").text();
//			// Si la fila es de un grano de interes
//			if(GRANOS_INTERES.contains(grano.toUpperCase())){
//				for (Integer pos_mercado : pos_columnas_interes) {
//					Element valor_interes = fila.child(pos_mercado);
//					Cotizacion cot = new Cotizacion(grano, valor_interes.select(".value").text());
//					cot.setVariacion(valor_interes.select(".variation").text());
//				}
//			}
//			
//		}
		
		
		
		Elements full_table = Jsoup.connect("http://www.elrural.com/").get().select(".mercados");
		
		Elements fila_data = full_table.select(".columns-content");
		for (Element fila : fila_data) {
			
		}
		
		
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
