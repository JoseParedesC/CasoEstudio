package com.cava.web.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cava.web.domain.CarroCompra;
import com.cava.web.domain.Cliente;
import com.cava.web.domain.Vendedor;
import com.cava.web.dto.UsuarioDTO;
import com.cava.web.repository.CarroCompraRepository;
import com.cava.web.repository.ClienteRepository;
import com.cava.web.repository.VendedorRepository;
import com.cava.web.utilities.Constantes;


@Service
public class AuthService {
	//Inyección de dependencias
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private CarroCompraRepository carroCompraRepository;
	
	public Map<String, Object> saveUser(UsuarioDTO usuario) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(usuario.getRol().equalsIgnoreCase(Constantes.CLIENTE.toString())) {
				if(clienteRepository.existsByNroDocumentoOrCorreo(usuario.getNroDocumento(), usuario.getEmail())) {
					map.put("valid", false);
					map.put("message", "El número de documento y/o email ya esta en uso. Intente con otro");
					return map;
				}
				CarroCompra carroCompra = carroCompraRepository.save(new CarroCompra(0L, 0.0, null, null, new Date()));
				Cliente cliente = new Cliente(usuario.getId(), usuario.getEmail(), usuario.getNombre(), usuario.getApellido(), 
						usuario.getTipoDocumento(), usuario.getNroDocumento(), usuario.getTelefono(), usuario.getPassword(), 
						Constantes.CLIENTE.toString(), Constantes.HABILITADO.toString(), carroCompra);
				clienteRepository.save(cliente);
			}else {
				if(vendedorRepository.existsByNroDocumento(usuario.getNroDocumento())){
					map.put("valid", false);
					map.put("message", "El número de documento ya esta en uso. Intente con otro");
					return map;
				}
				Vendedor vendedor = new Vendedor(usuario.getId(), usuario.getEmail(), usuario.getDireccion(), usuario.getNombre(), 
						usuario.getApellido(), usuario.getTipoDocumento(), usuario.getNroDocumento(), usuario.getTelefono(), 
						usuario.getPassword(), Constantes.VENDEDOR.toString(), Constantes.HABILITADO.toString(), null, new Date());
				vendedorRepository.save(vendedor);
			}
			map.put("valid", true);
			map.put("message", "Su registro ha sido exitoso");
		}catch(Exception e) {
			map.put("valid", false);
			map.put("message", "Upps algo ha salido mal. Intente nuevamente");
			return map;
		}
		return map;
	}
	
	public Map<String, Object> identifyUser(UsuarioDTO usuario) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(usuario.getRol().equalsIgnoreCase(Constantes.CLIENTE.toString())) {
				Cliente cliente = clienteRepository.findByCorreo(usuario.getEmail());
				if(cliente == null) {
					map.put("valid", false);
					map.put("message", "El usuario no existe");
					return map;
				}else {
					if(cliente.getPassword().equals(usuario.getPassword())) {
						map.put("valid", true);
						map.put("message", cliente);
						return map;
					}else {
						map.put("valid", false);
						map.put("message", "Contraseña incorrecta. Intente nuevamente");
						return map;
					}
				}
			}else if(usuario.getRol().equalsIgnoreCase(Constantes.VENDEDOR.toString())) {
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			map.put("valid", false);
			map.put("message", "Upps algo ha salido mal. Intente nuevamente");
			return map;
		}
		return map;
	}
}