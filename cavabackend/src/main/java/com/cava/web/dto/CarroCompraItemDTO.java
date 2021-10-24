package com.cava.web.dto;

public class CarroCompraItemDTO {
	private ProductoDTO producto;
	private CarroCompraDTO carroCompra;
	private Integer cantidad;
	
	public CarroCompraItemDTO() {}
	
	public CarroCompraItemDTO(ProductoDTO producto, CarroCompraDTO carroCompra, Integer cantidad) {
		super();
		this.producto = producto;
		this.carroCompra = carroCompra;
		this.cantidad = cantidad;
	}

	public ProductoDTO getProducto() {
		return producto;
	}
	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}
	public CarroCompraDTO getCarroCompra() {
		return carroCompra;
	}
	public void setCarroCompra(CarroCompraDTO carroCompra) {
		this.carroCompra = carroCompra;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}