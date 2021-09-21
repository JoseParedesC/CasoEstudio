package com.cava.web.dto;

import com.cava.web.domain.CarroCompra;

public class ClienteDTO{
	private Long id;
	private String correo;
	private CarroCompra carroCompra;
	
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
	public CarroCompra getCarroCompra() {
		return carroCompra;
	}
	public void setCarroCompra(CarroCompra carroCompra) {
		this.carroCompra = carroCompra;
	}
}
