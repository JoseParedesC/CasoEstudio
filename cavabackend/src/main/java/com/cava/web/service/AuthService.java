package com.cava.web.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cava.web.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cava.web.domain.Administrador;
import com.cava.web.domain.CarroCompra;
import com.cava.web.domain.Cliente;
import com.cava.web.domain.Usuario;
import com.cava.web.domain.Vendedor;
import com.cava.web.dto.AuthDTO;
import com.cava.web.repository.AdministradorRepository;
import com.cava.web.repository.CarroCompraRepository;
import com.cava.web.repository.ClienteRepository;
import com.cava.web.repository.UsuarioRepository;
import com.cava.web.repository.VendedorRepository;
import com.cava.web.utilities.Constantes;
import com.cava.web.utilities.PasswordUtil;


@Service
public class AuthService extends PasswordUtil {
	//Inyección de dependencias
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private CarroCompraRepository carroCompraRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AdministradorRepository administradorRepository;
	//Mappers
	@Autowired
	private AuthMapperImpl authMapper;
	@Autowired
	private ClienteMapperImpl clienteMapper;
	@Autowired
	private VendedorMapperImpl vendedorMapper;
	@Autowired
	private AdministradorMapperImpl administradorMapper;
	@Autowired
	private UsuarioMapperImpl usuarioMapper;
	
	public Map<String, Object> saveUser(AuthDTO usuario) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(usuarioRepository.existsByUsernameOrIdentificador(usuario.getEmail(), usuario.getNroDocumento())) {
				map.put("valid", false);
				map.put("message", "El número de documento y/o email ya esta en uso. Intente con otro");
			}else {				
				Usuario usuariodb = authMapper.toUsuario(usuario);
				usuarioRepository.save(usuariodb);
				if(usuariodb.getRol().equals(Constantes.CLIENTE.getValue())) {
					CarroCompra carroCompra = carroCompraRepository.save(new CarroCompra(0L, 0.0, null, null, new Date()));
					Cliente cliente = clienteMapper.toCliente(usuario, carroCompra, usuariodb);
					clienteRepository.save(cliente);
					map.put("message", usuarioMapper.fromClienteToUsuarioDTO(cliente));
				}else if(usuariodb.getRol().equals(Constantes.VENDEDOR.getValue())){
					Vendedor vendedor =  vendedorRepository.save(vendedorMapper.toVendedor(usuario, usuariodb));
					map.put("message", usuarioMapper.fromVendedorToUsuarioDTO(vendedor));
				}else {
					Administrador administrador = administradorRepository.save(administradorMapper.toAdministrador(usuario, usuariodb));
					map.put("message", usuarioMapper.fromAdministradorToUsuarioDTO(administrador));
				}
				map.put("valid", true);
			}
		}catch(Exception e) {
			e.printStackTrace();
			map.put("valid", false);
			map.put("message", "Upps algo ha salido mal. Intente nuevamente");
		}
		return map;
	}
	
	public Map<String, Object> identifyUser(AuthDTO usuario) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Usuario usuariodb = usuarioRepository.findByUsername(usuario.getEmail());
			if(usuariodb == null) {
				map.put("valid", false);
				map.put("message", "El usuario no existe");
			}else if(!verifyPassword(usuario.getPassword(), usuariodb.getPassword())) {
				map.put("valid", false);
				map.put("message", "La contraseña es incorrecta");
			}else {					
					if(usuariodb.getRol().equals(Constantes.CLIENTE.getValue())) {
						map.put("message", usuarioMapper.
								fromClienteToUsuarioDTO(clienteRepository.findByUsuario(usuariodb)));
					}else if(usuariodb.getRol().equals(Constantes.VENDEDOR.getValue())) {
						map.put("message", usuarioMapper.
								fromVendedorToUsuarioDTO(vendedorRepository.findByUsuario(usuariodb)));
					}else {
						map.put("message", usuarioMapper.
								fromAdministradorToUsuarioDTO(administradorRepository.findByUsuario(usuariodb)));
					}
				map.put("valid", true);
			}
		}catch(Exception e) {
			e.printStackTrace();
			map.put("valid", false);
			map.put("message", "Upps algo ha salido mal. Intente nuevamente");
		}
		return map;
	}
}