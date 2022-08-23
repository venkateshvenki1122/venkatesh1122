package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public Product add(Product entity) {
		
		return this.repo.save(entity);
	}
	
	public List<Product> findAll(){
		
		return this.repo.findAll();
	}
	
}
