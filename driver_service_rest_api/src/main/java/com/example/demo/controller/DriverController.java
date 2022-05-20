package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Driver;
import com.example.demo.service.DriverService;

import lombok.Delegate;

@RestController
@RequestMapping(path="/api/v1")


public class DriverController {

	
	private DriverService service;

	@Autowired
	public DriverController(DriverService service) {
		super();
		this.service = service;
	}
	
	@GetMapping(path="/drivers")
	public List<Driver> getAllDrivers(){
		
		return this.service.findAll();
	}
	
	@GetMapping(path="/drivers/{id}")
	public Driver getDriverById(@PathVariable("id") int id){
		
		return this.service.findById(id);
	}
	
//	@PostMapping(path="/drivers")
//	public Driver addDriver(@RequestBody Driver entity) {
//		
//		return this.service.add(entity);
//	}
	
	@PostMapping(path="/drivers")
	public ResponseEntity<Driver> addDriver(@RequestBody Driver entity) {
		
		Driver driver = this.service.add(entity);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(entity.getDriverId()).toUri();
		
		return ResponseEntity.created(location).body(driver);
		//return ResponseEntity.status(HttpStatus.CREATED).body(driver);
	}
	
	@DeleteMapping(path="/drivers/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		
	
		//Driver result =this.service.removeById(entity);
		
		//if(result !=null) {
			
			return ResponseEntity.status(HttpStatus.CREATED).build();

		}
		
	@GetMapping(path="/drivers/srch/number/{mobileNumber}")
	public List<Driver> getDriverByMobileNumber(@PathVariable("mobileNumber") long mobileNumber){
		
		return this.service.srchByMobileNumber(mobileNumber);
	}

	@GetMapping(path="/drivers/srch/name/{driverName}")
	public List<Driver> getDriverByName(@PathVariable("driverName") String srchName){
		
		return this.service.findByDriverName(srchName);
	}
	
	@GetMapping(path="/drivers/srch/rate/{rating}")
	public List<Driver> getDriverByRating(@PathVariable("rating") double rating){
		
		return this.service.srchByDriverRating(rating);
	}
	
	@PutMapping(path="/drivers/update/{id}/{rating}")
	public ResponseEntity<String> updateRating(@PathVariable("id") int id,
			@PathVariable("rating") double updatedRating){
		
		int update =this.service.updateRating(id, updatedRating);
		return ResponseEntity.status(HttpStatus.CREATED).body(update+ "   Record Updated");
	}
	
	@GetMapping(path="/drivers/sort/{driverName}")
	public List<Driver> sortedId (@PathVariable("driverName") String name){
		
		return this.service.sortedList(name);
	}
	
	
}


