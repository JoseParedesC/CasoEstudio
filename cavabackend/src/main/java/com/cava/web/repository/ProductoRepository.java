package com.cava.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
