package com.cava.web.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "carro_compra" )
public class CarroCompra {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private Double total;
	@OneToOne( mappedBy = "carroCompra" )
	private Cliente cliente;
	@OneToMany( mappedBy = "carroCompra", fetch = FetchType.LAZY )
	private List<CarroCompraItem> carroCompraItem;
	private Date created;
	
	public CarroCompra() {}
	
	public CarroCompra(Long id, Double total, Cliente cliente, List<CarroCompraItem> carroCompraItem, Date created) {
		super();
		this.id = id;
		this.total = total;
		this.cliente = cliente;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<CarroCompraItem> getCarroCompraItem() {
		return carroCompraItem;
	}

	public void setCarroCompraItem(List<CarroCompraItem> carroCompraItem) {
		this.carroCompraItem = carroCompraItem;
	}
}