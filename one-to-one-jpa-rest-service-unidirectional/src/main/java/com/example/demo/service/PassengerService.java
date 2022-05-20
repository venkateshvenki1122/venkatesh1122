package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Passenger;
import com.example.demo.entity.TripHistory;
import com.example.demo.ifaces.PassengerRepository;

@Service
public class PassengerService {

	@Autowired
	private PassengerRepository repo;
	
//	@Autowired
//	Passenger pass;
//	
//	@Autowired
//	List<TripHistory> trip;
	
	public Passenger addPassenger(Passenger entity) {
		
		return this.repo.save(entity);
	}
	
	public List<Passenger> findAll(){
		
		return this.repo.findAll();
	}
	
	public List<Passenger> getLocalDate(LocalDateTime date){
		
		return this.repo.findByTripHistoryListTripDateTime(date);
	}
	
	public List<Passenger> getPassengerName(String name){
		
		return this.repo.findByPassengerName(name);
	}
	
}
