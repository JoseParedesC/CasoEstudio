package com.cava.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cava.web.dto.MenusDTO;
import com.cava.web.service.MenusService;


@RestController
@CrossOrigin("*")
@RequestMapping("/menus")
public class MenusController {
	@Autowired
	private MenusService menusService;
	
	/*@PostMapping
	public ResponseEntity<?> saveCategoria(@RequestBody MenusDTO categoriaDto){
		return new ResponseEntity<>(menusService.save(categoriaDto) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}*/
	
	@GetMapping("/{rol}")
	public ResponseEntity<List<MenusDTO>> getByRol(@PathVariable String rol){
		return new ResponseEntity<>(menusService.findByRol(rol), HttpStatus.OK);
	}
}