package com.cava.web.dto;

import java.util.Date;
import java.util.List;

public class CarroCompraDTO {
	private Long id;
	private Double total;
	private List<ProductCartDTO> productos;
	private Date created;
	
	public CarroCompraDTO() {}

	public CarroCompraDTO(Long id, Double total, List<ProductCartDTO> productos, Date created) {
		this.id = id;
		this.total = total;
		this.productos = productos;
		this.created = created;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<ProductCartDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductCartDTO> productos) {
		this.productos = productos;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}