package com.cava.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cava.web.dto.CategoriaDTO;
import com.cava.web.service.CategoriaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoriasproductos")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping()
	public ResponseEntity<?> saveCategoria(@RequestBody CategoriaDTO categoria) {
		return ResponseEntity.status(400).body(null);
	}

}
