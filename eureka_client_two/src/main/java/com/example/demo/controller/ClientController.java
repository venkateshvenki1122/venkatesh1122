package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path="/api/v1")
public class ClientController {

	private RestTemplate template;

	private String BASEURL = "http://CLIENT-ONE/api/v1/";
	@Autowired
	public ClientController(RestTemplate template) {
		super();
		this.template = template;
	}
	
	
	@GetMapping(path="/client/books")
	public String getBooks() {
		
		return this.template.getForObject(BASEURL+"/books", String.class);
	}
	
	@GetMapping(path="/client/books/{id}")
	public String getBooks(@PathVariable int id) {
		
		
		return this.template.getForObject(BASEURL+"/books/"+id, String.class);
	}
}
