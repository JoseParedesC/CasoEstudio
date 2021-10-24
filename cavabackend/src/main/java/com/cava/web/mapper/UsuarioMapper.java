package com.cava.web.mapper;

import com.cava.web.domain.Administrador;
import com.cava.web.domain.Cliente;
import com.cava.web.domain.Vendedor;
import com.cava.web.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper {
    UsuarioDTO fromClienteToUsuarioDTO(Cliente cliente);
    UsuarioDTO fromVendedorToUsuarioDTO(Vendedor vendedor);
    UsuarioDTO fromAdministradorToUsuarioDTO(Administrador administrador);
}