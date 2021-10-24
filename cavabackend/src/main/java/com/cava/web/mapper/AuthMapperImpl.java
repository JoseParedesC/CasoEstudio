package com.cava.web.mapper;

import org.springframework.stereotype.Component;

import com.cava.web.domain.Usuario;
import com.cava.web.dto.AuthDTO;
import com.cava.web.utilities.Constantes;
import com.cava.web.utilities.PasswordUtil;

@Component
public class AuthMapperImpl extends PasswordUtil implements AuthMapper {

	@Override
	public AuthDTO toUsuarioDTO(Usuario usuario) {
		if(usuario == null)
			return null;
		AuthDTO authDTO = new AuthDTO();
		
		return authDTO;
	}

	@Override
	public Usuario toUsuario(AuthDTO authDTO) {
		if(authDTO == null)
			return null;
		Usuario usuario = new Usuario();
		usuario.setId(authDTO.getId());
		usuario.setUsername(authDTO.getEmail());
		usuario.setPassword(hashPassword(authDTO.getPassword()));
		usuario.setRol(authDTO.getRol());
		usuario.setIdentificador(authDTO.getNroDocumento());
		usuario.setEstado(Constantes.HABILITADO.getValue());
		return usuario;
	}

}