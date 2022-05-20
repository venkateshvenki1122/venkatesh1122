package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository emp;
	
	@Autowired
	public EmployeeService(EmployeeRepository emp) {
		super();
		this.emp = emp;
	}


	public Employee add(Employee entity) {
		
		return this.emp.save(entity);
	}
	
	public List<Employee> findAll(){
		
		return this.emp.findAll();
	}
	
	public List<Employee> findByDateOfBirth(LocalDate date){
		
		return this.emp.findByDateOfBirth(date);
	}
	
	public List<Employee> findByLocation(String loc){
		
		return this.emp.findByLocation(loc);
	}
	
	public List<Employee> findBySkillSet(String skill){
		
		return this.emp.findBySkillSet(skill);
	}
	
	public List<Employee> getByLocation(@Param("loc") String loc,@Param("skill") String skill)
	{
		
		return this.emp.getByLocation(loc, skill);
	}
	
	public List<Employee> findByLocationAndSkillSet(String loc,String skill){
		
		return this.emp.findByLocationAndSkillSet(loc, skill);
	}
	
}
