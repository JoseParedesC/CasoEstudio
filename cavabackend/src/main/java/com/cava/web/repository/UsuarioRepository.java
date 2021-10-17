package com.cava.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByUsername(String username);
	boolean existsByUsernameOrIdentificador(String username, String identificador);
}