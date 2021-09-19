package com.cava.web.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cava.web.dto.VendedorDTO;

public interface VendedorService extends JpaRepository<VendedorDTO, Long>{

}
