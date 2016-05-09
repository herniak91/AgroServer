package com.hwilliams.agroServer.model;

public class CotizacionGrano extends Cotizacion{

	private String variacion;
	
	public CotizacionGrano(String valor, String variacion) {
		super(valor);
		this.variacion = variacion;
	}

	public String getVariacion() {
		return variacion;
	}
	
}
