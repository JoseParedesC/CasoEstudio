package com.cava.web.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cava.web.domain.CategoriaProducto;
import com.cava.web.domain.Producto;
import com.cava.web.domain.Vendedor;

public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>{
	List<Producto> findAllByVendedor(Vendedor vendedor);
	List<Producto> findByNombreContainingIgnoreCase(String nombre);
	List<Producto> findByCategoria(CategoriaProducto categoria);
}