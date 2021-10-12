package com.cava.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.domain.Menu;


public interface MenusRepository extends JpaRepository<Menu, Long>{

	
	List<Menu> findByTipoRol(String tipoRol);
	
	
	
}
