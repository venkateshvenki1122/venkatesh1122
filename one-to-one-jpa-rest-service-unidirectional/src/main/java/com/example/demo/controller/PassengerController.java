package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Passenger;
import com.example.demo.entity.TripHistory;
import com.example.demo.service.PassengerService;

@RestController
@RequestMapping(path="/api/v2")
public class PassengerController {

	@Autowired
	 private PassengerService ser;
	
//	@Autowired
//	private TripHistory trip;
	
	@PostMapping(path="/Passenger")
	public ResponseEntity<Passenger> addDriver(@RequestBody Passenger entity) {

		Passenger pass = this.ser.addPassenger(entity);
		
		return ResponseEntity.ok(pass);
	}
	
	
	@GetMapping(path ="/passengers")
	public List<Passenger> getAllPassengers(){
		
		return this.ser.findAll();
	}
	
	@GetMapping(path="/trip/{localDate}")
	public List<Passenger> getLocalDate(@PathVariable("localDate")
		@DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime date){
		
		return this.ser.getLocalDate(date);
	}
	
	@GetMapping(path="/name/{passengerName}")
	public List<Passenger> getPassengerName(@PathVariable("passengerName") String name){
		
		return this.ser.getPassengerName(name);
	}
}
