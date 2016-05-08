package com.hwilliams.agroServer.model;

public class Cotizacion {

	private String entidad;
	private String valor;
	private String variacion;
	
	public Cotizacion(String entidad, String valor) {
		super();
		this.entidad = entidad;
		this.valor = valor;
	}
	
	public String getEntidad() {
		return entidad;
	}

	public String getValor() {
		return valor;
	}

	public String getVariacion() {
		return variacion;
	}

	public void setVariacion(String variacion) {
		this.variacion = variacion;
	}
	
}
