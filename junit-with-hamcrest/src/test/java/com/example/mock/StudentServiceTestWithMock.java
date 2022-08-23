package com.example.mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.model.Student;
import com.example.service.StudentService;

public class StudentServiceTestWithMock {

	
	@DisplayName(value = "Test verify Add Method with Mock")
	@Test
	void testAddWithMock() {
		
		StudentServiceMock mock = new StudentServiceMock();
		
		StudentService service = new StudentService(mock);
		
		Student kavi = new Student(301, "Kavitha");
		Student kavya = new Student(302, "Kavya");
		
		
		service.add(kavya);
		mock.verify(kavya, 1);
		
		service.add(kavi);
		mock.verify(kavi, 2);
		
	}
}
