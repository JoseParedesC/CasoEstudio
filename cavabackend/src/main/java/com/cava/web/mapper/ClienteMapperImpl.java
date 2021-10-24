package com.cava.web.mapper;

import org.springframework.stereotype.Component;

import com.cava.web.domain.CarroCompra;
import com.cava.web.domain.Cliente;
import com.cava.web.domain.Usuario;
import com.cava.web.dto.AuthDTO;

@Component
public class ClienteMapperImpl implements ClienteMapper {

	@Override
	public Cliente toCliente(AuthDTO authDTO, CarroCompra carroCompra, Usuario usuario) {
		if(authDTO == null)
			return null;
		Cliente cliente = new Cliente();
		cliente.setId(authDTO.getId());
		cliente.setNombre(authDTO.getNombre());
		cliente.setCarroCompra(carroCompra);
		cliente.setNroDocumento(authDTO.getNroDocumento());
		cliente.setTelefono(authDTO.getTelefono());
		cliente.setTipoDocumento(authDTO.getTipoDocumento());
		cliente.setUsuario(usuario);
		return cliente;
	}

}