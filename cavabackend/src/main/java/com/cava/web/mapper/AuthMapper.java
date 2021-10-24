package com.cava.web.mapper;

import org.mapstruct.Mapper;

import com.cava.web.domain.Usuario;
import com.cava.web.dto.AuthDTO;

@Mapper
public interface AuthMapper {
	AuthDTO toUsuarioDTO(Usuario usuario);
	Usuario toUsuario(AuthDTO authDTO);
}