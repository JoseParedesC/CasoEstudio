package com.cava.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cava.web.dto.AdministradorDTO;
import com.cava.web.repository.AdministradorRepository;

@Service("singleton")
public class AdministradorService {

	@Autowired
	private AdministradorRepository administrador;
	
	public void saveAdministrador(AdministradorDTO administrador) {};
	
}
