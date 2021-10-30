package com.cava.web.repository;

import com.cava.web.domain.Vendedor;
import com.cava.web.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByVendedor(Vendedor vendedor);
}