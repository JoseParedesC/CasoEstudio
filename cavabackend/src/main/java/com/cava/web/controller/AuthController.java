package com.cava.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cava.web.dto.UsuarioDTO;
import com.cava.web.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO usuario){
		Map<String, Object> map = authService.saveUser(usuario);
		if(Boolean.parseBoolean(map.get("valid").toString())) {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(map.get("message"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UsuarioDTO usuario){
		Map<String, Object> map = authService.identifyUser(usuario);
		return new ResponseEntity<>(map.get("message"), Boolean.parseBoolean(map.get("valid").toString()) ? 
				HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
}