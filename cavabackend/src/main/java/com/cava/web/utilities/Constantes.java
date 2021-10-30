package com.cava.web.utilities;

public enum Constantes {
	CLIENTE("Cliente"),
	VENDEDOR("Vendedor"),
	ADMIN("Administrador"),
	HABILITADO("Habilitado"),
	PROCESO("En proceso"),
	DESHABILITADO("Deshabilitado"),
	ALMACEN("En almacen"),
	ENVIADO("Enviada"),
	DESPACHO("En despacho"),
	ENTREGADO("Entragado");

	private String value;
	
	Constantes(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}