package com.hwilliams.agroServer.service.util;

public enum TipoMaquina {
	TRACTOR("Tractor", 1),
	COSECHADORA("Cosechadora", 1),
	CARRO_TOLVA("Carro Tolva", 1),
	PULVERIZADOR("Pulverizador", 1),
	EMBOLSADORA("Embolsadora", 1),
	EXTRACTOR("Extractor", 1),
	PICADORA("Picadora", 1),
	ROTO_ENFARDADORA("Roto Enfardadora", 1),
	SEMBRADORA("Sembradora", 2), 
	LABOREO("Laboreo", 3);

	private String nombre;
	private Integer clase;
	
	private TipoMaquina(String nombre, Integer clase){
		this.nombre = nombre;
		this.clase = clase;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

	public Integer getClase() {
		return clase;
	}
	
}
