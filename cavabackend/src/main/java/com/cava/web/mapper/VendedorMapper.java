package com.cava.web.mapper;

import org.mapstruct.Mapper;

import com.cava.web.domain.Usuario;
import com.cava.web.domain.Vendedor;
import com.cava.web.dto.UsuarioDTO;

@Mapper
public interface VendedorMapper {
	Vendedor toVendedor(UsuarioDTO usuarioDTO, Usuario usuario);
}