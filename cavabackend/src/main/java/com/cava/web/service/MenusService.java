package com.cava.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cava.web.dto.MenusDTO;
import com.cava.web.repository.MenusRepository;

@Service
public class MenusService {
	
	@Autowired
	private MenusRepository menusRepository;
	
	public List<MenusDTO> listMenusRoles(String rol) {
		List<MenusDTO> list = new ArrayList<MenusDTO>();
		try {
			for(MenusDTO menu : menusRepository.findByTipoRol(rol)) {
				list.add(new MenusDTO(menu.getId(), menu.getNombre(), menu.getPath(), menu.getTipoRol(), menu.getCreate(), menu.getIcons()));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	
}

