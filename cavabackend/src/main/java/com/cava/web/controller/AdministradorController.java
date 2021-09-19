package com.cava.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cava.web.dto.AdministradorDTO;
import com.cava.web.service.AdministradorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;
	
	@PostMapping()
	public ResponseEntity<?> saveAdministrador(@RequestBody AdministradorDTO administrador) {
		return ResponseEntity.status(400).body(null);
	}
}
