package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

@RestController
public class ProductController {

	
	@Autowired
	@Qualifier("tv")
	private Product tv;
	
	@Autowired
	@Qualifier("printer")
	private Product printer;
	
	@GetMapping(path = "/products/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		
		return id == 101 ? tv:printer;
	}
//	
//	@GetMapping(path = "/products")
//	public List<Product> findAll(){
//		
//		return this.service.findAll();
//	}
//	
//	@PostMapping(path = "/products/add")
//	public ResponseEntity<Product> add(@RequestBody Product entity) {
//		
//		Product added =  this.service.add(entity);
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(added);
//		
//	}
}
