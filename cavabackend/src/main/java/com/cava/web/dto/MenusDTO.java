package com.cava.web.dto;

import java.util.Date;

public class MenusDTO {

	private Long id;
	private String nombre;
	private String path;
	private String tipoRol;
	private Date create;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTipoRol() {
		return tipoRol;
	}
	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
}
