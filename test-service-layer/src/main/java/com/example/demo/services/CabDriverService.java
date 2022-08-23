package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CabDriver;
import com.example.demo.repo.CabDriverRepository;

@Service
public class CabDriverService {

	
	private CabDriverRepository repo;

	@Autowired
	public CabDriverService(CabDriverRepository repo) {
		super();
		this.repo = repo;
	}

	public Optional<CabDriver> findById(int id){
		
		return repo.findById(id);
	}
	
	public List<CabDriver> findAll(){
		
		return repo.findAll();
	}
	
	public CabDriver save(CabDriver entity) {
		
		 return repo.save(entity);
	}
	
//	public void remove (int id) {
//		
//		Optional<CabDriver> foundElement = repo.findById(id);
//		
//		if (foundElement.isPresent()) {
//			
//			repo.deleteById(id);
//		}else {
//			
//			throw new RuntimeException("Element with" + id +"Not present");
//		}
//	}
	
	public CabDriver findByDriverName(String driverName) {
		
		return this.repo.findByDriverName(driverName);
	}
	
	public Optional<CabDriver> remove(int id) {
		Optional<CabDriver> foundElement=repo.findById(id);

		if(foundElement.isPresent())
		{
		
			repo.deleteById(id);
		
		}else {
		
			throw new RuntimeException("Element with"+id+"Not Present");
		}
		
		return foundElement;
		
	}
	
}
