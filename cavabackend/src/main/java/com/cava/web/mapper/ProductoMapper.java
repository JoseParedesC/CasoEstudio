package com.cava.web.mapper;

import com.cava.web.dto.ProductCartDTO;
import com.cava.web.dto.ProductGridDTO;
import com.cava.web.dto.ProductoTableDTO;
import org.mapstruct.Mapper;

import com.cava.web.domain.Producto;
import com.cava.web.dto.ProductoDTO;

@Mapper( componentModel = "spring" )
public interface ProductoMapper {
	Producto toProducto(ProductoDTO productoDTO);
	ProductoDTO toProductoDTO(Producto producto);
	ProductGridDTO toProductoGridDTO(Producto producto);
	ProductoTableDTO toProductoTableDTO(Producto producto);
	ProductCartDTO toProductCartDTO(Producto producto, Integer cantidad);
}