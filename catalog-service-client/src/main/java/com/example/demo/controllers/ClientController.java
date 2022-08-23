package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(path="/api/v1/clients")
public class ClientController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping(path="/client")
	@CircuitBreaker(name ="catalog",fallbackMethod="getCatalogFallBack")
	public String getCatalog() {
		
		return template.getForObject("http://localhost:2020/api/v1/catalog", String.class);
	}
	
	public String getCatalogFallBack(Exception e) {
		
		return "From Fall Back";
		}
	
	
	
	
	
}
