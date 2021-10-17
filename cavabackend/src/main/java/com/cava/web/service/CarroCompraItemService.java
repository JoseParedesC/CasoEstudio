package com.cava.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cava.web.domain.CarroCompra;
import com.cava.web.dto.CarroCompraDTO;
import com.cava.web.dto.CarroCompraItemDTO;
import com.cava.web.mapper.CarroCompraItemMapperImpl;
import com.cava.web.mapper.CarroCompraMapperImpl;
import com.cava.web.repository.CarroCompraItemRepository;
import com.cava.web.repository.CarroCompraRepository;

@Service
public class CarroCompraItemService {
	//Repositorys
	@Autowired
	private CarroCompraItemRepository carroCompraItemRepository;
	@Autowired
	private CarroCompraRepository carroCompraRepository;
	
	//Mappers
	@Autowired
	private CarroCompraItemMapperImpl carroCompraItemMapper;
	@Autowired
	private CarroCompraMapperImpl carroCompraMapper;
	
	public boolean saveItem(CarroCompraItemDTO carroCompraItemDTO) {
		try {
			carroCompraItemRepository.save(carroCompraItemMapper.toCarroCompraItem(carroCompraItemDTO));
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public CarroCompra getProductsById(Long id){
		//CarroCompraDTO carroCompraDTO = new CarroCompraDTO();
		CarroCompra carroCompra = new CarroCompra();
		try {
			carroCompra = carroCompraRepository.findById(id).orElse(null);
			//carroCompraDTO = carroCompraMapper.toCarroCompraDTO(carroCompra);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return carroCompra;
	}
}