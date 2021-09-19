package com.cava.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cava.web.dto.CarroCompraItemDTO;

@Service("singleton")
public class CarroCompraItemService {

	@Autowired
	private CarroCompraService carro_compra;
	
	public void saveCarroCompraItem(CarroCompraItemDTO carrocompla_item) {};
}
