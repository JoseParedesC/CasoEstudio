package com.cava.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cava.web.dto.MenusDTO;
import com.cava.web.repository.MenusRepository;


@Service("singleton")
public class MenusService {
	
	@Autowired
	private MenusRepository menus;
	
	public void saveCarroCompra(MenusDTO menus) {};

}
