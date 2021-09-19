package com.cava.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cava.web.dto.CarroCompraDTO;
import com.cava.web.repository.CarroCompraRepository;

@Service("singleton")
public class CarroCompraService {
	
	@Autowired
	private CarroCompraRepository carro_compra;
	
	public void saveCarroCompra(CarroCompraDTO carro_compra) {};

}
