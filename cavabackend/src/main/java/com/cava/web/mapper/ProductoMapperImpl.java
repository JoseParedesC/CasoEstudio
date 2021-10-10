package com.cava.web.mapper;

import org.springframework.stereotype.Component;

import com.cava.web.domain.Producto;
import com.cava.web.dto.ProductoDTO;

@Component
public class ProductoMapperImpl implements ProductoMapper{

	@Override
	public Producto toProducto(ProductoDTO productoDTO) {
		if(productoDTO == null) {
			return null;
		}
		Producto producto = new Producto();
		producto.setId(productoDTO.getId());
		producto.setNombre(productoDTO.getNombre());
		producto.setCantidad(productoDTO.getCantidad());
		producto.setCategoria(productoDTO.getCategoria()); //Cambiar a DTO
		producto.setVendedor(productoDTO.getVendedor());
		producto.setFoto(productoDTO.getFoto());
		producto.setCodigo(productoDTO.getCodigo());
		producto.setDescripcion(productoDTO.getDescripcion());
		producto.setFechaVencimiento(productoDTO.getFechaVencimiento());
		producto.setPrecio(productoDTO.getPrecio());
		return producto;
	}

	@Override
	public ProductoDTO toProductoDTO(Producto producto) {
		if(producto == null) {
			return null;
		}
		ProductoDTO productoDTO = new ProductoDTO();
		productoDTO.setId(producto.getId());
		productoDTO.setNombre(producto.getNombre());
		productoDTO.setCodigo(producto.getCodigo());
		productoDTO.setCantidad(producto.getCantidad());
		productoDTO.setCategoria(producto.getCategoria());
		productoDTO.setFechaVencimiento(producto.getFechaVencimiento());
		productoDTO.setDescripcion(producto.getDescripcion());
		productoDTO.setFoto(producto.getFoto());
		productoDTO.setVendedor(producto.getVendedor());
		productoDTO.setPrecio(producto.getPrecio());
		return productoDTO;
	}

}
