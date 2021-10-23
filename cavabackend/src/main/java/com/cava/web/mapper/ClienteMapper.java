package com.cava.web.mapper;

import org.mapstruct.Mapper;

import com.cava.web.domain.CarroCompra;
import com.cava.web.domain.Cliente;
import com.cava.web.domain.Usuario;
import com.cava.web.dto.AuthDTO;

@Mapper
public interface ClienteMapper {
	Cliente toCliente(AuthDTO authDTO, CarroCompra carroCompra, Usuario usuario);
}