package com.cava.web.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "usuarios" )
public class Usuario {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String username;
	private String password;
	private String identificador;
	private String rol;
	private String estado;
	
	public Usuario() {}

	public Usuario(Long id, String username, String password, String identificador, String rol, String estado) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.identificador = identificador;
		this.rol = rol;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}