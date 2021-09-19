package com.cava.web.dto;

import java.util.Date;

import com.cava.web.domain.CategoriaProducto;
import com.cava.web.domain.Vendedor;

public class ProductoDTO {
	private Long id;
	private String nombre;
	private Integer cantidad;
	private Double precio;
	private CategoriaProducto categoria;
	private Vendedor vendedor;
	private Date created;
	
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
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
/*Diony el chico bonito*/
	
	public CategoriaProducto getCategoria() {
		return categoria;
	}
	
	public void setCategoria(CategoriaProducto categoria) {
		this.categoria = categoria;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}