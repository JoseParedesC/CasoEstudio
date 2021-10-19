package com.cava.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.domain.Cliente;
import com.cava.web.domain.Usuario;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findByUsuario(Usuario usuario);
}