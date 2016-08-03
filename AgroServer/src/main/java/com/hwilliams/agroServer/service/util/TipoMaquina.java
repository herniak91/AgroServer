package com.hwilliams.agroServer.service.util;

public enum TipoMaquina {
	TRACTOR("tractor", 1),
	COSECHADORA("cosechadora", 1),
	CARRO_TOLVA("carro tolva", 1),
	PULVERIZADOR("pulverizador", 1),
	EMBOLSADORA("embolsadora", 1),
	EXTRACTORA("extractora", 1),
	PICADORA("picadora", 1),
	ROTO_ENFARDADORA("rotoenfardadora", 1),
	SEMBRADORA("sembradora", 2), 
	LABOREO("laboreo", 3);

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
