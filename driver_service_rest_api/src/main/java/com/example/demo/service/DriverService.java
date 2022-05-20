package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Driver;
import com.example.demo.ifaces.DriverRepository;

@Service
public class DriverService {

	@Autowired
	private DriverRepository repo;
	
	public List<Driver> findAll(){
		
		return this.repo.findAll();
	}
	
	public Driver add(Driver entity) {
		
		return this.repo.save(entity);
	}
	
	public Driver findById(int id) {
		
		return this.repo.findById(id).orElseThrow(() -> new RuntimeException(id+"Not Found"));
	}
	
	public Driver removeById(Driver entity) {
		
		//Optional<Driver> optional = Optional.empty();
	
	boolean	result =this.repo.existsById(entity.getDriverId());
	
	if(result) {
		this.repo.delete(entity);
	}else {
		
		throw new NoSuchElementException("Element with Id =" + entity.getDriverId()+"Not Present");
	}
		return entity;
	}
	
	public List<Driver> findByDriverName(String srchName){
		
		return this.repo.findByDriverName(srchName);
	}
	
	public List<Driver> srchByMobileNumber(long mobileNumber){
		
		return this.repo.findByMobileNumber(mobileNumber);
	}
	
	public List<Driver> srchByDriverRating(double rating){
		
		return this.repo.searchByRating(rating);
	}
	
	public int updateRating(int id, double rating) {
		
		
		return this.repo.modifyRating(id, rating);
	}
	
	public List<Driver> sortedList(String name){
		
		return this.repo.findAll(Sort.by(name));
	}
	
	
	
	
}
