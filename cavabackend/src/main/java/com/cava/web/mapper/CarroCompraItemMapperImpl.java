package com.cava.web.mapper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cava.web.domain.CarroCompraItem;
import com.cava.web.dto.CarroCompraItemDTO;

@Component
public class CarroCompraItemMapperImpl implements CarroCompraItemMapper {

	//Mappers
	@Autowired
	private ProductoMapperImpl productoMapper;
	@Autowired
	private CarroCompraMapperImpl carroCompraMapper;
	
	@Override
	public CarroCompraItem toCarroCompraItem(CarroCompraItemDTO carroCompraItemDTO) {
		if(carroCompraItemDTO == null)
			return null;
		CarroCompraItem carroCompraItem = new CarroCompraItem();
		carroCompraItem.setId(0L);
		carroCompraItem.setProducto(productoMapper.toProducto(carroCompraItemDTO.getProducto()));
		carroCompraItem.setCarroCompra(carroCompraMapper.toCarroCompra(carroCompraItemDTO.getCarroCompra()));
		carroCompraItem.setCantidad(carroCompraItemDTO.getCantidad());
		carroCompraItem.setCreated(new Date());
		return carroCompraItem;
	}

	@Override
	public CarroCompraItemDTO toCarroCompraItemDTO(CarroCompraItem carroCompraItem) {
		if(carroCompraItem == null)
			return null;
		CarroCompraItemDTO carroCompraItemDTO = new CarroCompraItemDTO();
		carroCompraItemDTO.setCarroCompra(carroCompraMapper.toCarroCompraDTO(carroCompraItem.getCarroCompra()));
		carroCompraItemDTO.setProducto(productoMapper.toProductoDTO(carroCompraItem.getProducto()));
		return carroCompraItemDTO;
	}
}