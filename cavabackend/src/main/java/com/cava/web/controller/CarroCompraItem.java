package com.cava.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cava.web.dto.CarroCompraItemDTO;
import com.cava.web.service.CarroCompraItemService;


@RestController
@CrossOrigin("*")
@RequestMapping("/carrocompra")
public class CarroCompraItem {
	
	
	@Autowired
	private CarroCompraItemService carroCompraItemService;
	
	@PostMapping()
	public ResponseEntity<?> saveCarroCompraItem(@RequestBody CarroCompraItemDTO carroCompraItem) {
		return ResponseEntity.status(400).body(null);
	}
}
