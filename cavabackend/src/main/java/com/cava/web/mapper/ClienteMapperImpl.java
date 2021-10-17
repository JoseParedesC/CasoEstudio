package com.cava.web.mapper;

import org.springframework.stereotype.Component;

import com.cava.web.domain.CarroCompra;
import com.cava.web.domain.Cliente;
import com.cava.web.domain.Usuario;
import com.cava.web.dto.UsuarioDTO;

@Component
public class ClienteMapperImpl implements ClienteMapper {

	@Override
	public Cliente toCliente(UsuarioDTO usuarioDTO, CarroCompra carroCompra, Usuario usuario) {
		if(usuarioDTO == null)
			return null;
		Cliente cliente = new Cliente();
		cliente.setId(usuarioDTO.getId());
		cliente.setNombre(usuarioDTO.getNombre());
		cliente.setCarroCompra(carroCompra);
		cliente.setNroDocumento(usuarioDTO.getNroDocumento());
		cliente.setTelefono(usuarioDTO.getTelefono());
		cliente.setTipoDocumento(usuarioDTO.getTipoDocumento());
		cliente.setUsuario(usuario);
		return cliente;
	}

}