package com.cava.web.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.cava.web.domain.Administrador;
import com.cava.web.domain.Usuario;
import com.cava.web.dto.UsuarioDTO;

@Component
public class AdministradorMapperImpl implements AdministradorMapper {

	@Override
	public Administrador toAdministrador(UsuarioDTO usuarioDTO, Usuario usuario) {
		if(usuarioDTO == null)
			return null;
		Administrador administrador = new Administrador();
		administrador.setId(usuarioDTO.getId());
		administrador.setNombre(usuarioDTO.getNombre());
		administrador.setApellido(usuarioDTO.getApellido());
		administrador.setNrodocumento(usuarioDTO.getNroDocumento());
		administrador.setTelefono(usuarioDTO.getTelefono());
		administrador.setTipo_documento(usuarioDTO.getTipoDocumento());
		administrador.setCreated(new Date());
		administrador.setUsuario(usuario);
		return administrador;
	}
}