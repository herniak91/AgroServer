package com.hwilliams.agroServer.service.util;

public enum EstadoParqueMaquina {
	
	LIBRE("Libre"),
	OCUP("Ocupado"),
	PEND("Pendiente");
	
	private String nombre;
	
	private EstadoParqueMaquina(String n){
		this.nombre = n;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

}
