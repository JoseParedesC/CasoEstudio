package com.cava.web.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CategoriaDTO {
	private Long id;
	private String nombre;
	@Temporal( TemporalType.DATE )
	private Date created;
	
	public CategoriaDTO(Long id, String nombre, Date created) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.created = created;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}