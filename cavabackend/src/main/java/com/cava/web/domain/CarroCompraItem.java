package com.cava.web.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name = "carro_compra_items" )
public class CarroCompraItem {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	@ManyToOne
	@JoinColumn( name = "id_carro_compra", foreignKey = @ForeignKey( name = "FK_ID_CARRO_COMPRA" ) )
	@JsonBackReference
	private CarroCompra carroCompra;
	@ManyToOne
	@JoinColumn( name = "id_producto", foreignKey = @ForeignKey( name = "FK_ID_PRODUCTO" ) )
	private Producto producto;
	private Integer cantidad;
	private Date created;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CarroCompra getCarroCompra() {
		return carroCompra;
	}
	public void setCarroCompra(CarroCompra carroCompra) {
		this.carroCompra = carroCompra;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}