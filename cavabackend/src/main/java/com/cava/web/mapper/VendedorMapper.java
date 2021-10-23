package com.cava.web.mapper;

import org.mapstruct.Mapper;

import com.cava.web.domain.Usuario;
import com.cava.web.domain.Vendedor;
import com.cava.web.dto.AuthDTO;

@Mapper
public interface VendedorMapper {
	Vendedor toVendedor(AuthDTO authDTO, Usuario usuario);
}