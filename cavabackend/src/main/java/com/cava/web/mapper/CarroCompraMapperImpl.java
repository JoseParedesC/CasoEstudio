package com.cava.web.mapper;

import java.util.ArrayList;
import java.util.List;

import com.cava.web.dto.ProductCartDTO;
import com.cava.web.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cava.web.domain.CarroCompra;
import com.cava.web.domain.CarroCompraItem;
import com.cava.web.dto.CarroCompraDTO;
import com.cava.web.dto.CarroCompraItemDTO;

@Component
public class CarroCompraMapperImpl implements CarroCompraMapper {
	//Mappers
	@Autowired
	private ProductoMapperImpl productoMapper;
	
	@Override
	public CarroCompraDTO toCarroCompraDTO(CarroCompra carroCompra) {
		List<ProductCartDTO> productoDTOS = new ArrayList<ProductCartDTO>();
		if(carroCompra == null)
			return null;
		CarroCompraDTO carroCompraDTO = new CarroCompraDTO();
		carroCompraDTO.setId(carroCompra.getId());
		for(CarroCompraItem item : carroCompra.getCarroCompraItem()) {
			productoDTOS.add(productoMapper.toProductCartDTO(item.getProducto()));
		}
		carroCompraDTO.setProductos(productoDTOS);
		carroCompraDTO.setTotal(carroCompra.getTotal());
		carroCompraDTO.setCreated(carroCompra.getCreated());
		return carroCompraDTO;
	}

	@Override
	public CarroCompra toCarroCompra(CarroCompraDTO carroCompraDTO) {
		if(carroCompraDTO == null)
			return null;
		CarroCompra carroCompra = new CarroCompra();
		carroCompra.setId(carroCompraDTO.getId());
		carroCompra.setTotal(carroCompraDTO.getTotal());
		carroCompra.setCreated(carroCompraDTO.getCreated());
		return carroCompra;
	}
}