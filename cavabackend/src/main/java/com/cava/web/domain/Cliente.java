package com.cava.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name = "clientes" )
public class Cliente{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String nombre;
	private String apellido;
	@Column( name = "tipo_documento" )
	private String tipoDocumento;
	@Column( name = "nrodocumento" )
	private String nroDocumento;
	private String telefono;
	@OneToOne
	@JoinColumn( name = "id_carro_compra", foreignKey = @ForeignKey( name = "FK_ID_CARRO_COMPRA" ))
	@JsonBackReference
	private CarroCompra carroCompra;
	@OneToOne
	private Usuario usuario;
	
	public Cliente() {}

	public Cliente(Long id, String nombre, String apellido, String tipoDocumento, String nroDocumento, String telefono,
			CarroCompra carroCompra, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.telefono = telefono;
		this.carroCompra = carroCompra;
		this.usuario = usuario;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public CarroCompra getCarroCompra() {
		return carroCompra;
	}

	public void setCarroCompra(CarroCompra carroCompra) {
		this.carroCompra = carroCompra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}