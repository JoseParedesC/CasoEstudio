package com.cava.web.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.cava.web.domain.Administrador;
import com.cava.web.domain.Usuario;
import com.cava.web.dto.AuthDTO;

@Component
public class AdministradorMapperImpl implements AdministradorMapper {

	@Override
	public Administrador toAdministrador(AuthDTO authDTO, Usuario usuario) {
		if(authDTO == null)
			return null;
		Administrador administrador = new Administrador();
		administrador.setId(authDTO.getId());
		administrador.setNombre(authDTO.getNombre());
		administrador.setApellido(authDTO.getApellido());
		administrador.setNrodocumento(authDTO.getNroDocumento());
		administrador.setTelefono(authDTO.getTelefono());
		administrador.setTipo_documento(authDTO.getTipoDocumento());
		administrador.setCreated(new Date());
		administrador.setUsuario(usuario);
		return administrador;
	}
}