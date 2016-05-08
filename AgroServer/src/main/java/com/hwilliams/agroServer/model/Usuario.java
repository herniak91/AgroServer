package com.hwilliams.agroServer.model;

public class Usuario {
	private String nombre;
	private String apellido;
	
	public Usuario(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
}
