package com.cava.web.mapper;

import com.cava.web.domain.Administrador;
import com.cava.web.domain.Cliente;
import com.cava.web.domain.Vendedor;
import com.cava.web.dto.UsuarioDTO;
import com.cava.web.utilities.Constantes;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UsuarioMapperImpl implements UsuarioMapper{
    @Override
    public UsuarioDTO fromClienteToUsuarioDTO(Cliente cliente) {
        if(cliente == null){
            return null;
        }
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(cliente.getId());
        usuarioDTO.setNombre(cliente.getNombre());
        usuarioDTO.setCarro(cliente.getCarroCompra().getId());
        usuarioDTO.setRol(Constantes.CLIENTE.getValue().toLowerCase());
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO fromVendedorToUsuarioDTO(Vendedor vendedor) {
        if(vendedor == null){
            return null;
        }
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(vendedor.getId());
        usuarioDTO.setNombre(vendedor.getNombre());
        usuarioDTO.setCarro(null);
        usuarioDTO.setRol(Constantes.VENDEDOR.getValue().toLowerCase());
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO fromAdministradorToUsuarioDTO(Administrador administrador) {
        if(administrador == null){
            return null;
        }
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(administrador.getId());
        usuarioDTO.setNombre(administrador.getNombre());
        usuarioDTO.setCarro(null);
        usuarioDTO.setRol(Constantes.ADMIN.getValue().toLowerCase());
        return usuarioDTO;
    }
}