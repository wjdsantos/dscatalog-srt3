package com.devsuperior.dscatalogsrt3.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalogsrt3.dto.CategoryDTO;
import com.devsuperior.dscatalogsrt3.entities.Category;
import com.devsuperior.dscatalogsrt3.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());  //expressão lambda
		
		
/*		List<CategoryDTO> listDto = new ArrayList<>(); 
		for (Category cat : list) {
			listDto.add(new CategoryDTO(cat));
		}
		
		return listDto;*/
	}
}
