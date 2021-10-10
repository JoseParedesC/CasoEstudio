package com.cava.web.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name = "categoria_producto")
public class CategoriaProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String nombre;
	@OneToMany( mappedBy = "categoria" )
	@JsonBackReference
	private List<Producto> producto;
	@Temporal( TemporalType.DATE )
	private Date created;
	
	public CategoriaProducto() {}
	
	public CategoriaProducto(Long id, String nombre, Date created) {
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