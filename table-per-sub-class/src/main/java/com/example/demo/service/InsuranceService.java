package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.HealthInsurance;
import com.example.demo.ifaces.InsuranceRepository;

@Service
public class InsuranceService {

	@Autowired
	InsuranceRepository repo;
	
	@Autowired
	HealthInsurance entity;
	
	public void addHealthPolicy() {
		
		Object obj = repo.save(entity);
		
		if(obj!=null) {
			
			System.out.println("One row Added");
		}
		
	}
	
	public void getHealthPolicy() {
	
		
		repo.findHealthProducts().forEach(System.out::println);
	}
	
}
