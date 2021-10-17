package com.cava.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.domain.Usuario;
import com.cava.web.domain.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
	Vendedor findByUsuario(Usuario usuario);
}