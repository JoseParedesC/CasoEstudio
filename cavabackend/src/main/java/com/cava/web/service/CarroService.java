package com.cava.web.service;

import com.cava.web.domain.CarroCompraItem;
import com.cava.web.domain.Producto;
import com.cava.web.dto.CarroCompraDTO;
import com.cava.web.mapper.ProductoMapperImpl;
import com.cava.web.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cava.web.domain.CarroCompra;
import com.cava.web.dto.CarroCompraItemDTO;
import com.cava.web.mapper.CarroCompraItemMapperImpl;
import com.cava.web.mapper.CarroCompraMapperImpl;
import com.cava.web.repository.CarroCompraItemRepository;
import com.cava.web.repository.CarroCompraRepository;

import java.util.Optional;

@Service
public class CarroCompraItemService {
	//Repositorys
	@Autowired
	private CarroCompraItemRepository carroCompraItemRepository;
	@Autowired
	private CarroCompraRepository carroCompraRepository;
	@Autowired
	private ProductoRepository productoRepository;
	
	//Mappers
	@Autowired
	private CarroCompraItemMapperImpl carroCompraItemMapper;
	@Autowired
	private CarroCompraMapperImpl carroCompraMapper;
	@Autowired
	private ProductoMapperImpl productoMapper;

	public boolean saveItem(CarroCompraItemDTO carroCompraItemDTO) {
		try {
			CarroCompraItem carroCompraItem = new CarroCompraItem();
			CarroCompra carroCompra = new CarroCompra();
			Optional<CarroCompraItem> optional = carroCompraItemRepository.
					findByProductoAndCarroCompra(
							productoMapper.toProducto(carroCompraItemDTO.getProducto()),
							carroCompraMapper.toCarroCompra(carroCompraItemDTO.getCarroCompra()));
			carroCompra = carroCompraRepository.findById(carroCompraItemDTO.getCarroCompra().getId()).get();
			if(optional.isPresent()){
				carroCompraItem = optional.get();
				carroCompraItem.setCantidad(carroCompraItem.getCantidad() + carroCompraItemDTO.getCantidad());
				carroCompra.setTotal(carroCompra.getTotal() + optional.get().getProducto().getPrecio());
			}else{
				carroCompraItem = carroCompraItemMapper.toCarroCompraItem(carroCompraItemDTO);
				Optional<Producto> producto = productoRepository.findById(carroCompraItem.getProducto().getId());
				carroCompra.setTotal(carroCompra.getTotal() + producto.get().getPrecio() * carroCompraItemDTO.getCantidad());
			}
			carroCompraItemRepository.save(carroCompraItem);
			carroCompraRepository.save(carroCompra);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public CarroCompraDTO getProductsById(Long id){
		CarroCompraDTO carroCompraDTO = new CarroCompraDTO();
		CarroCompra carroCompra = new CarroCompra();
		try {
			carroCompra = carroCompraRepository.findById(id).orElse(null);
			carroCompraDTO = carroCompraMapper.toCarroCompraDTO(carroCompra);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return carroCompraDTO;
	}

	public boolean deleteProductById(Long id, Long idCarroCompra){
		try{
			CarroCompra carroCompra = new CarroCompra();
			carroCompra.setId(idCarroCompra);
			Producto producto = new Producto();
			producto.setId(id);
			CarroCompraItem carroCompraItem = carroCompraItemRepository
						.findByProductoAndCarroCompra(producto, carroCompra).get();
			carroCompra.setTotal(carroCompra.getTotal() -
					carroCompraItem.getCantidad() * carroCompraItem.getProducto().getPrecio());
			carroCompraItemRepository.deleteById(carroCompraItem.getId());
			carroCompraRepository.save(carroCompra);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}