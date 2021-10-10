package com.cava.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.domain.Producto;
import com.cava.web.domain.Vendedor;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	List<Producto> findAllByVendedor(Vendedor vendedor);
}