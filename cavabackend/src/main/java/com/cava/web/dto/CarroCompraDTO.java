package com.cava.web.dto;

import java.util.Date;
import java.util.List;

public class CarroCompraDTO {
	private Long id;
	private Double total;
	private List<CarroCompraItemDTO> carroCompraItem;
	private Date created;
	
	public CarroCompraDTO() {}

	public CarroCompraDTO(Long id, Double total, List<CarroCompraItemDTO> carroCompraItem, Date created) {
		super();
		this.id = id;
		this.total = total;
		this.carroCompraItem = carroCompraItem;
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

	public List<CarroCompraItemDTO> getCarroCompraItem() {
		return carroCompraItem;
	}

	public void setCarroCompraItem(List<CarroCompraItemDTO> carroCompraItem) {
		this.carroCompraItem = carroCompraItem;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}