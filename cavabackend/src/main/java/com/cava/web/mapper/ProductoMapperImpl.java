package com.cava.web.mapper;

import com.cava.web.dto.ProductCartDTO;
import com.cava.web.dto.ProductGridDTO;
import com.cava.web.dto.ProductoTableDTO;
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
		producto.setPresentacion(productoDTO.getPresentacion());
		producto.setPorcentajeAlcohol(productoDTO.getPorcentajeAlcohol());
		producto.setContenido(productoDTO.getContenido());
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
		productoDTO.setContenido(producto.getContenido());
		productoDTO.setPresentacion(producto.getPresentacion());
		productoDTO.setPorcentajeAlcohol(producto.getPorcentajeAlcohol());
		return productoDTO;
	}

	@Override
	public ProductGridDTO toProductoGridDTO(Producto producto) {
		if(producto == null)
			return null;
		ProductGridDTO productGridDTO = new ProductGridDTO();
		productGridDTO.setId(producto.getId());
		productGridDTO.setNombre(producto.getNombre());
		productGridDTO.setDescripcion(producto.getDescripcion());
		productGridDTO.setPrecio(producto.getPrecio());
		productGridDTO.setFoto(producto.getFoto());
		productGridDTO.setVendedor(producto.getVendedor().getNombre());
		return productGridDTO;
	}

	@Override
	public ProductoTableDTO toProductoTableDTO(Producto producto) {
		if(producto == null)
			return null;
		ProductoTableDTO productoTableDTO = new ProductoTableDTO();
		productoTableDTO.setId(producto.getId());
		productoTableDTO.setNombre(producto.getNombre());
		productoTableDTO.setPrecio(producto.getPrecio());
		productoTableDTO.setCantidad(producto.getCantidad());
		productoTableDTO.setCategoria(producto.getCategoria().getNombre());
		productoTableDTO.setFechaVencimiento(producto.getFechaVencimiento());
		return productoTableDTO;
	}

	@Override
	public ProductCartDTO toProductCartDTO(Producto producto, Integer cantidad) {
		if(producto == null)
			return null;
		ProductCartDTO productCartDTO = new ProductCartDTO();
		productCartDTO.setId(producto.getId());
		productCartDTO.setNombre(producto.getNombre());
		productCartDTO.setPrecio(producto.getPrecio());
		productCartDTO.setFoto(producto.getFoto());
		productCartDTO.setVendedor(producto.getVendedor().getNombre());
		productCartDTO.setCantidad(cantidad);
		return productCartDTO;
	}
}
