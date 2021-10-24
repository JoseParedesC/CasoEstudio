package com.cava.web.mapper;

import com.cava.web.domain.Administrador;
import com.cava.web.domain.Usuario;
import com.cava.web.dto.AuthDTO;

public interface AdministradorMapper {
	Administrador toAdministrador(AuthDTO authDTO, Usuario usuario);
}