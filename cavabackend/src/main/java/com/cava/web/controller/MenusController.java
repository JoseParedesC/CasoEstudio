package com.cava.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cava.web.dto.MenusDTO;
import com.cava.web.service.MenusService;

@RestController
@CrossOrigin("*")
@RequestMapping("/vendedor")
public class MenusController {

	@Autowired
	private MenusService menusService;
	
	@PostMapping()
	public ResponseEntity<?> saveAdministrador(@RequestBody MenusDTO menusService) {
		return ResponseEntity.status(400).body(null);
	}
}
