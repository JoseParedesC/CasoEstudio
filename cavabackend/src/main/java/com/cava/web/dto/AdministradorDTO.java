package com.cava.web.dto;

import java.util.Date;

public class AdministradorDTO{

	private Long id;
	private String correo;
	private Date create;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Date getCreate() {
		return create;
	}
	
	public void setCreate(Date create) {
		this.create = create;
	}
	
	
}
