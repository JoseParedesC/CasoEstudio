package com.cava.web.repository;

import com.cava.web.domain.CarroCompra;
import com.cava.web.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.domain.CarroCompraItem;

import java.util.Optional;

public interface CarroCompraItemRepository extends JpaRepository<CarroCompraItem, Long>{
    Optional<CarroCompraItem> findByProductoAndCarroCompra(Producto producto, CarroCompra carroCompra);
}
