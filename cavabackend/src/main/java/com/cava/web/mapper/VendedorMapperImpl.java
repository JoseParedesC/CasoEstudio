package com.cava.web.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.cava.web.domain.Usuario;
import com.cava.web.domain.Vendedor;
import com.cava.web.dto.UsuarioDTO;

@Component
public class VendedorMapperImpl implements VendedorMapper {

	@Override
	public Vendedor toVendedor(UsuarioDTO usuarioDTO, Usuario usuario) {
		if(usuarioDTO == null)
			return null;
		Vendedor vendedor = new Vendedor();
		vendedor.setId(usuarioDTO.getId());
		vendedor.setNombre(usuarioDTO.getNombre());
		vendedor.setApellido(usuarioDTO.getApellido());
		vendedor.setDireccion(usuarioDTO.getDireccion());
		vendedor.setNroDocumento(usuarioDTO.getNroDocumento());
		vendedor.setTelefono(usuarioDTO.getTelefono());
		vendedor.setTipoDocumento(usuarioDTO.getTipoDocumento());
		vendedor.setUsuario(usuario);
		vendedor.setCreated(new Date());
		return vendedor;
	}
}