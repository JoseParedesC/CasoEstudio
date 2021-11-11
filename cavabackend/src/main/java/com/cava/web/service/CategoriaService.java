package com.cava.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.cava.web.domain.CategoriaProducto;
import com.cava.web.dto.CategoriaDTO;
import com.cava.web.dto.TableDTO;
import com.cava.web.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public boolean save(CategoriaDTO categoriaDto) {
		try {
			if(categoriaDto.getId() != 0) {
				CategoriaProducto categoria = categoriaRepository.findById(categoriaDto.getId()).get();
				categoria.setNombre(categoriaDto.getNombre());
				categoriaRepository.save(categoria);
			}else {
				categoriaRepository.save(new CategoriaProducto(0L, categoriaDto.getNombre(), new Date()));
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Optional<CategoriaDTO> findById(Long id){
		Optional<CategoriaDTO> optional = Optional.empty();
		try {
			if(categoriaRepository.existsById(id)) {
				optional = Optional.of(new CategoriaDTO(categoriaRepository.findById(id).get().getId(), 
						categoriaRepository.findById(id).get().getNombre(), categoriaRepository.findById(id).get().getCreated()));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return optional;
	}
	
	public List<CategoriaDTO> findAll(){
		List<CategoriaDTO> list = new ArrayList<CategoriaDTO>();
		try {
			for(CategoriaProducto categoria : categoriaRepository.findAll()) {
				list.add(new CategoriaDTO(categoria.getId(), categoria.getNombre(), categoria.getCreated()));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean deleteById(Long id) {
		try {
			categoriaRepository.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
<<<<<<< HEAD
	
	public TableDTO findAllTable(){
		List<CategoriaDTO> list = new ArrayList<CategoriaDTO>();
		TableDTO table = new TableDTO();
		try {
			for(CategoriaProducto categoria : categoriaRepository.findAll()) {
				list.add(new CategoriaDTO(categoria.getId(), categoria.getNombre(), categoria.getCreated()));
			}
			Page<?> page = new PageImpl<>(list);
			table = new TableDTO(page.getTotalPages(), page.getTotalElements(), page.getContent());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return table;
	}
	
=======
>>>>>>> d48f026fe51cd469426d348d152bbfcc11c503a7
}