package com.cava.web.mapper;

import org.springframework.stereotype.Component;

import com.cava.web.domain.Usuario;
import com.cava.web.dto.UsuarioDTO;
import com.cava.web.utilities.Constantes;
import com.cava.web.utilities.PasswordUtil;

@Component
public class UsuarioMapperImpl extends PasswordUtil implements UsuarioMapper {

	@Override
	public UsuarioDTO toUsuaarioDTO(Usuario usuario) {
		if(usuario == null)
			return null;
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		return usuarioDTO;
	}

	@Override
	public Usuario toUsuario(UsuarioDTO usuarioDTO) {
		if(usuarioDTO == null)
			return null;
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setUsername(usuarioDTO.getEmail());
		usuario.setPassword(hashPassword(usuarioDTO.getPassword()));
		usuario.setRol(usuarioDTO.getRol());
		usuario.setIdentificador(usuarioDTO.getNroDocumento());
		usuario.setEstado(Constantes.HABILITADO.getValue());
		return usuario;
	}

}