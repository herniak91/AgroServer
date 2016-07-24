package com.hwilliams.agroServer.service.util;

public enum Rubro {
	SIEMBRA("Siembra"),
	COSECHA("Cosecha"),
	PULVERIZACION("Pulverizacion"),
	EXTRACCION_GRANOS("Embolsado"),
	PICADO_FORRRAJE("Picado de forraje"),
	HENIFICACION("Henificacion"),
	LABOREO_SUELO("Laboreo de suelo");
	
	private String nombre;
	
	private Rubro(String n){
		this.nombre = n;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
}
