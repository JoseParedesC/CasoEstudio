package com.cava.web.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cava.web.domain.CarroCompra;
import com.cava.web.dto.CarroCompraDTO;
import com.cava.web.dto.CarroCompraItemDTO;
import com.cava.web.service.CarroCompraItemService;

@RestController
@CrossOrigin("*")
@RequestMapping("/carrocompra")
public class CarroController {
	@Autowired
	private CarroCompraItemService carroCompraItemService;
	
	@PostMapping
	public ResponseEntity<?> setItem(@RequestBody CarroCompraItemDTO item){
		return new ResponseEntity<>(carroCompraItemService.saveItem(item) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findCarroById(@PathVariable Long id){
		CarroCompraDTO carroCompra = carroCompraItemService.getProductsById(id);
		//if(Objects.isNull(carroCompra)) return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(carroCompra, HttpStatus.OK);
	}

	@DeleteMapping("/{id}/carro/{idCarroCompra}")
	public ResponseEntity<?> deleteById(@PathVariable Long id, @PathVariable Long idCarroCompra){
		return new ResponseEntity(carroCompraItemService.deleteProductById(id, idCarroCompra) ?
				HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
}