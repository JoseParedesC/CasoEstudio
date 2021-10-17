package com.cava.web.mapper;

import org.mapstruct.Mapper;

import com.cava.web.domain.CarroCompra;
import com.cava.web.dto.CarroCompraDTO;

@Mapper
public interface CarroCompraMapper {
	CarroCompra toCarroCompra(CarroCompraDTO carroCompraDTO);
	CarroCompraDTO toCarroCompraDTO(CarroCompra carroCompra);
}