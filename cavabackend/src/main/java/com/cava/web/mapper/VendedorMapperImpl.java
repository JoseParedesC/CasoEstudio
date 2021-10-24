package com.cava.web.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.cava.web.domain.Usuario;
import com.cava.web.domain.Vendedor;
import com.cava.web.dto.AuthDTO;

@Component
public class VendedorMapperImpl implements VendedorMapper {

	@Override
	public Vendedor toVendedor(AuthDTO authDTO, Usuario usuario) {
		if(authDTO == null)
			return null;
		Vendedor vendedor = new Vendedor();
		vendedor.setId(authDTO.getId());
		vendedor.setNombre(authDTO.getNombre());
		vendedor.setApellido(authDTO.getApellido());
		vendedor.setDireccion(authDTO.getDireccion());
		vendedor.setNroDocumento(authDTO.getNroDocumento());
		vendedor.setTelefono(authDTO.getTelefono());
		vendedor.setTipoDocumento(authDTO.getTipoDocumento());
		vendedor.setUsuario(usuario);
		vendedor.setCreated(new Date());
		return vendedor;
	}
}