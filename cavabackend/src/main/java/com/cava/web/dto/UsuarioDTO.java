package com.cava.web.dto;

public class UsuarioDTO {
    private Long id;
    private String nombre;
    private Long carro;
    private String rol;

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

    public Long getCarro() {
        return carro;
    }

    public void setCarro(Long carro) {
        this.carro = carro;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}