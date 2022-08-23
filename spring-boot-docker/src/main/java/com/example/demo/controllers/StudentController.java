package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@GetMapping(path = "/students/{name}")
	public String getMessage(@PathVariable("name") String name) {
		
		return "Welcome  :" + name;
	}
	
	
	
}
