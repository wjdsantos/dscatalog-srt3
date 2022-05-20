package com.devsuperior.dscatalogsrt3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalogsrt3.entities.Category;
import com.devsuperior.dscatalogsrt3.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional
	public List<Category> findAll() {
		return repository.findAll();
	}
}
