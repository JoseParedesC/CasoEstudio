package com.cava.web.dto;

import java.util.Date;

public class MenusDTO {

	private Long id;
	private String nombre;
	private String path;
	private String tipoRol;
	private Date create;
	private String icons;
	
	
	public MenusDTO() {}	
	
	public MenusDTO(Long id, String nombre, String path, String tipoRol, Date create, String icons) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.path = path;
		this.tipoRol = tipoRol;
		this.create = create;
		this.icons = icons;
	}

	public String getIcons() {
		return icons;
	}
	public void setIcons(String icons) {
		this.icons = icons;
	}
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
