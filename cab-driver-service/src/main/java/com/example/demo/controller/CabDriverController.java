package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CabDriver;
import com.example.demo.services.CabDriverService;

@RestController
@RequestMapping(path="/api/v1/drivers")
@CrossOrigin(origins = "*")

public class CabDriverController {

	@Autowired
	private CabDriverService service;
	
	@Value("${server.port}")
	private String port;
	
	@PostMapping(path="/add")
	public CabDriver add(@RequestBody CabDriver entity) {
		
		return this.service.save(entity);
	}
	
	@GetMapping
	public List<CabDriver> findAll(){
		
		return this.service.findAll();
	}
	
	@GetMapping(path="/{id}")
	public CabDriver findById(@PathVariable("id") int id) {
		
		return this.service.findById(id).orElseThrow(()->new RuntimeException("Element Not Found"));
	}
	
	@GetMapping(path="/remove/{id}")
	public String remove(@PathVariable("id") int id) {
		
		Optional<CabDriver> found= this.service.findById(id);
		
		if(found.isPresent()) {
			
			this.service.remove(id);
			
			return "Element deleted";
		}else {
			
			  return "Element not found";
		}
	}
	
	@GetMapping(path = "/srch/{name}")
	public CabDriver findByDriverName(@PathVariable("name") String driverName){
	
		CabDriver found = this.service.findByDriverName(driverName);
	
		found.setLocation(found.getLocation()+":"+port);
	
		return found;
	}
	
	
}
