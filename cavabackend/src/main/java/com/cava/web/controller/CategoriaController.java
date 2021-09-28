package com.cava.web.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.cava.web.dto.CategoriaDTO;
import com.cava.web.service.CategoriaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity<?> saveCategoria(@RequestBody CategoriaDTO categoriaDto){
		return new ResponseEntity<>(categoriaService.save(categoriaDto) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> getById(@PathVariable Long id){
		return categoriaService.findById(id)
			.map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK))
			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> getAll(){
		return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		return new ResponseEntity<>(categoriaService.deleteById(id) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
}
