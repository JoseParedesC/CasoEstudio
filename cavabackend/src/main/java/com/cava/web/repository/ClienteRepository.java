package com.cava.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
