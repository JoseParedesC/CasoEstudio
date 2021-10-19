package com.cava.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.domain.Administrador;
import com.cava.web.domain.Usuario;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
	Administrador findByUsuario(Usuario usuario);
}