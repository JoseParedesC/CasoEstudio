package com.cava.web.mapper;

import org.mapstruct.Mapper;

import com.cava.web.domain.CarroCompraItem;
import com.cava.web.dto.CarroCompraItemDTO;

@Mapper
public interface CarroCompraItemMapper {
	CarroCompraItem toCarroCompraItem(CarroCompraItemDTO carroCompraItemDTO);
	CarroCompraItemDTO toCarroCompraItemDTO(CarroCompraItem carroCompraItem);
}