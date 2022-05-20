package com.example.demo.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	public List<Employee> findByDateOfBirth(LocalDate date);
	
	public List<Employee> findByLocation(String loc);
	
	public List<Employee> findBySkillSet(String skill);
	
	public List<Employee> findByLocationAndSkillSet(String loc,String skill);
	
	@Query(nativeQuery=true,
			value="select * from venki_employee1 where location=:loc or skillset=:skill")
	public List<Employee> getByLocation(@Param("loc") String loc,@Param("skill") String skill);
}
