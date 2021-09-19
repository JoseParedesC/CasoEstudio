package com.cava.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.dto.AdministradorDTO;

public interface AdministradorRepository extends JpaRepository<AdministradorDTO, Long> {

}
