package com.devsuperior.dscatalogsrt3.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.devsuperior.dscatalogsrt3.entities.Product;
import com.devsuperior.dscatalogsrt3.tests.Factory;

@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository repository;
	
	private long existingId;
	private long nonExistingId;
	private long countTotalProducts;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 100L;
		countTotalProducts = 25L;
	}
	
	@Test
	public void saveShouldPersistWithAutoincrementIdIsNull() {
		
		Product product = Factory.createProduct();
		product.setId(null);
		
		product = repository.save(product);
		
		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(countTotalProducts + 1, product.getId());
	}
	
	@Test
	public void findByIdShouldReturnOptionalObjNonEmptyWhenIdExists() {
		
		Optional<Product> result = repository.findById(existingId);
		
		Assertions.assertTrue(result.isPresent());
	}
	
	@Test
	public void findByIdShouldReturnOptionalObjEmptyWhenIdDoesNotExists() {
		
		Optional<Product> result = repository.findById(nonExistingId);
		
		Assertions.assertTrue(result.isEmpty());
	}
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		
		//Arrange
		//long existingId = 1L;
		
		//Act
		repository.deleteById(existingId);
		
		//Assert
		Optional<Product> result = repository.findById(existingId);
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void deleteShouldthrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
		
		//Arrange
		//long nonExistingId = 100L;
		
		//Action and Assertion
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});
	}
}
