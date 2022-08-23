package com.example.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.Student.ifaces.StudentRepositoryRepo;
import com.example.ifaces.StudentRepository;
import com.example.model.Student;

public class StudentService {

	
	private StudentRepository repo;
	
	private StudentRepositoryRepo repository;
	
	public StudentService(StudentRepository repo) {
		
		super();
		this.repo = repo;
		//this.repository = repository;
	}
	
	public Object add(Student entity) {
		
		return this.repo.add(entity);
		
	}
	
	public List<Student> findAll(){
		
		return this.repo.findAll();
	}
	
	public int findStudentSize() {
		
		return this.repo.findAll().size();
	}

	public Object addWithCondition(Student sam) {

		Student added = null;
		
		if(sam.getRollNumber()>2000) {
			
			this.repo.add(sam);
			added = sam;
		}
	return added;
	
	}	
	
	public Optional<Student> findByRollNumber(int rollNumber) {
		
		return this.repository.findByRollNumber(rollNumber);
		
	}	
	
    public Optional<Student> deleteByRollNumber(int rollNumber) {
		
		return this.repository.deleteByRollNumber(rollNumber);
		
	}	
}
