package com.cava.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cava.web.dto.CategoriaDTO;
import com.cava.web.repository.CategoriaRepository;

@Service("singleton")
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public void saveCategoria(CategoriaDTO categoria) {}

}
