package com.cava.web.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name = "vendedores")
public class Vendedor{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String direccion;
	private String nombre;
	private String apellido;
	@Column( name = "tipo_documento" )
	private String tipoDocumento;
	@Column( name = "nro_documento" )
	private String nroDocumento;
	private String telefono;
	private String foto;
	@OneToMany( mappedBy = "vendedor", fetch = FetchType.LAZY )
	@JsonBackReference
	private List<Producto> productos;
	private Date created;
	@OneToOne
	private Usuario usuario;
	
	public Vendedor() {}

	public Vendedor(Long id, String direccion, String nombre, String apellido, String tipoDocumento,
			String nroDocumento, String telefono, String foto, List<Producto> productos, Date created,
			Usuario usuario) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.telefono = telefono;
		this.foto = foto;
		this.productos = productos;
		this.created = created;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}