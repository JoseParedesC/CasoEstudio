package com.cava.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.dto.MenusDTO;

public interface MenusRepository extends JpaRepository<MenusDTO, Long>{

}
