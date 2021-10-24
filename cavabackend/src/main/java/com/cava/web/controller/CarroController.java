package com.cava.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cava.web.dto.CarroCompraDTO;
import com.cava.web.dto.CarroCompraItemDTO;
import com.cava.web.service.CarroService;

@RestController
@CrossOrigin("*")
@RequestMapping("/carrocompra")
public class CarroController {
	@Autowired
	private CarroService carroService;
	
	@PostMapping
	public ResponseEntity<?> setItem(@RequestBody CarroCompraItemDTO item){
		return new ResponseEntity<>(carroService.saveItem(item) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findCarroById(@PathVariable Long id){
		CarroCompraDTO carroCompra = carroService.getProductsById(id);
		//if(Objects.isNull(carroCompra)) return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(carroCompra, HttpStatus.OK);
	}

	@DeleteMapping("/{id}/carro/{idCarroCompra}")
	public ResponseEntity<?> deleteById(@PathVariable Long id, @PathVariable Long idCarroCompra){
		return new ResponseEntity(carroService.deleteProductById(id, idCarroCompra) ?
				HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
}