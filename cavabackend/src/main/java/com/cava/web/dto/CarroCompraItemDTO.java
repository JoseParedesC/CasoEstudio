package com.cava.web.dto;

public class CarroCompraItemDTO {
	private ProductoDTO producto;
	private CarroCompraDTO carroCompra;
	
	public CarroCompraItemDTO() {}
	
	public CarroCompraItemDTO(ProductoDTO producto, CarroCompraDTO carroCompra) {
		super();
		this.producto = producto;
		this.carroCompra = carroCompra;
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
}