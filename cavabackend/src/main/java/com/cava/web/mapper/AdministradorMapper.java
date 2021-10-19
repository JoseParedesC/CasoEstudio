package com.cava.web.mapper;

import com.cava.web.domain.Administrador;
import com.cava.web.domain.Usuario;
import com.cava.web.dto.UsuarioDTO;

public interface AdministradorMapper {
	Administrador toAdministrador(UsuarioDTO usuarioDTO, Usuario usuario);
}