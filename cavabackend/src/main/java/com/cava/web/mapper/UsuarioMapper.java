package com.cava.web.mapper;

import org.mapstruct.Mapper;

import com.cava.web.domain.Usuario;
import com.cava.web.dto.UsuarioDTO;

@Mapper
public interface UsuarioMapper {
	UsuarioDTO toUsuaarioDTO(Usuario usuario);
	Usuario toUsuario(UsuarioDTO usuarioDTO);
}