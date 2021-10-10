package com.cava.web.utilities;

public enum Constantes {
	CLIENTE("Cliente"),
	VENDEDOR("Vendedor"),
	ADMIN("Administrador"),
	HABILITADO("Habilitado"),
	DESHABILITADO("Deshabilitado");

	private String value;
	
	Constantes(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}