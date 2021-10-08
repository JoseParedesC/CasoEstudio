package com.cava.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.domain.Menu;
import com.cava.web.dto.MenusDTO;

public interface MenusRepository extends JpaRepository<Menu, Long>{

	
	List<MenusDTO> findByTipoRol(String tipoRol);
	
	
	
}
