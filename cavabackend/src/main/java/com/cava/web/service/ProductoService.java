package com.cava.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cava.web.dto.ProductGridDTO;
import com.cava.web.dto.ProductoTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.cava.web.domain.CategoriaProducto;
import com.cava.web.domain.Producto;
import com.cava.web.domain.Vendedor;
import com.cava.web.dto.ProductoDTO;
import com.cava.web.dto.TableDTO;
import com.cava.web.mapper.ProductoMapperImpl;
import com.cava.web.repository.ProductoRepository;

@Service
public class ProductoService {
	//Mapper
	@Autowired
	private ProductoMapperImpl productoMapper;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public boolean saveProduct(ProductoDTO producto){
		try {
			Producto productoDb = productoMapper.toProducto(producto);
			productoDb.setCreated(new Date());
			productoRepository.save(productoDb);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Optional<ProductoDTO> findById(Long id){
		Optional<ProductoDTO> optional = Optional.empty();
		try {
			if(productoRepository.existsById(id)) {
				Producto producto = productoRepository.findById(id).orElse(null);
				optional = Optional.of(productoMapper.toProductoDTO(producto));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return optional;
	}
	
	public List<ProductoDTO> findAll(){
		List<ProductoDTO> productos = new ArrayList<ProductoDTO>();
		try {
			Iterable<Producto> productsDb = productoRepository.findAll();
			for(Producto producto : productsDb) {
				productos.add(productoMapper.toProductoDTO(producto));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return productos;
	}

	public List<ProductGridDTO> getTopProducts(){
		List<ProductGridDTO> productos = new ArrayList<>();
		try{
			for (Producto producto : productoRepository.findTop4()){
				productos.add(productoMapper.toProductoGridDTO(producto));
			}
		}catch(Exception e){
			productos = null;
			e.printStackTrace();
		}
		return productos;
	}
	
	public TableDTO findAllByIdVendedor(Long id){
		TableDTO table = new TableDTO();
		try {
			Vendedor vendedor = new Vendedor();
			vendedor.setId(id);
			List<ProductoTableDTO> productos = new ArrayList<>();
			for (Producto producto : productoRepository.findAllByVendedor(vendedor)){
				productos.add(productoMapper.toProductoTableDTO(producto));
			}
			Page<?> page = new PageImpl<>(productos);
			table = new TableDTO(page.getTotalPages(), page.getTotalElements(), page.getContent());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return table;
	}
	
	public List<ProductGridDTO> searchProducts(String nombre, Long idCategoria){
		List<ProductGridDTO> productos = new ArrayList<ProductGridDTO>();
		try {
			if(nombre != null) {
				for(Producto producto : productoRepository.findByNombreContainingIgnoreCase(nombre)) {
					productos.add(productoMapper.toProductoGridDTO(producto));
				}
			}else if(idCategoria != null){
				CategoriaProducto categoria = new CategoriaProducto();
				categoria.setId(idCategoria);
				for(Producto producto : productoRepository.findByCategoria(categoria)) {
					productos.add(productoMapper.toProductoGridDTO(producto));
				}
			}else {
				for(Producto producto : productoRepository.findAll()) {
					productos.add(productoMapper.toProductoGridDTO(producto));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return productos;
	}
	
	public boolean deleteById(Long id){
		try {
			productoRepository.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}