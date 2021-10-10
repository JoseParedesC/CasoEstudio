package com.cava.web.mapper;

import org.mapstruct.Mapper;

import com.cava.web.domain.Producto;
import com.cava.web.dto.ProductoDTO;

@Mapper( componentModel = "spring" )
public interface ProductoMapper {
	Producto toProducto(ProductoDTO productoDTO);
	ProductoDTO toProductoDTO(Producto producto);
}