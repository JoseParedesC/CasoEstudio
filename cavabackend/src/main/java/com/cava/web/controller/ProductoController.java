package com.cava.web.controller;

import java.util.List;

import com.cava.web.dto.ProductGridDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cava.web.dto.ProductoDTO;
import com.cava.web.dto.TableDTO;
import com.cava.web.service.ProductoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@PostMapping
	public ResponseEntity<?> saveProduct(@RequestBody ProductoDTO producto){
		return new ResponseEntity<>(productoService.saveProduct(producto) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductoDTO>> getAll(){
		return new ResponseEntity<List<ProductoDTO>>(productoService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> getById(@PathVariable Long id){
		return productoService.findById(id)
				.map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/vendedor/{id}")
	public ResponseEntity<TableDTO> getAllByVendedor(@PathVariable Long id){
		return new ResponseEntity<TableDTO>(productoService.findAllByIdVendedor(id), HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<ProductGridDTO>> searchProducts(@RequestParam(required = false) String nombre, @RequestParam (required = false)Long categoria){
		return new ResponseEntity<>(productoService.searchProducts(nombre, categoria), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		return new ResponseEntity<>(productoService.deleteById(id) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
}