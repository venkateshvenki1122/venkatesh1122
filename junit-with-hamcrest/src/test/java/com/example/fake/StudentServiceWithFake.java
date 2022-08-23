package com.example.fake;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.model.Student;
import com.example.service.StudentService;

public class StudentServiceWithFake {

	StudentRepoFake fake = null;
	
	StudentService service = null;
	
	@BeforeEach
	public void init() {
		
		fake = new StudentRepoFake();
		service = new StudentService(fake);
	}
	
	@DisplayName(value = "Test Add Method Return inserted object back")
	@Test
	void testAddMethod() {
		
		
		Student ram = new Student(101, "Ram");
		
		Student actual = service.add(ram);
		
		assertEquals(actual, ram);
	}
	
	@DisplayName(value = "Test FindAll Method Return all the elements Added")
	@Test
	void testFindAllMethod() {
		
		Student ram = new Student(104, "Ram");
		Student venki = new Student(105, "Venki");
		
		service.add(ram);
		service.add(venki);
		List<Student> list = service.findAll();
		
		int length = list.size();
		assertEquals(2, length);
		
	}
}
