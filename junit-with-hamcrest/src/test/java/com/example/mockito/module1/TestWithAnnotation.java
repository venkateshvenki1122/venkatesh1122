package com.example.mockito.module1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.ifaces.StudentRepository;
import com.example.model.Student;
import com.example.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class TestWithAnnotation {

	
	@Mock
	StudentRepository repo;
	
	@InjectMocks
	StudentService service;
	
	@Test
	@DisplayName(value = "Test FindAll Method with Mockito stub and Annotation")
	void testFindAll() {
		
		
		
		Student venki = new Student(501, "Venki");
		Student thamo = new Student(502, "Thamo");
		Student guru = new Student(503, "Guru");
		
		List<Student> list = new ArrayList<Student>();
		list.add(venki);
		list.add(thamo);
		list.add(guru);
		
		//Stubbing
		
		Mockito.when(repo.findAll()).thenReturn(list);
		
		assertEquals(service.findStudentSize(), 3);
	}
}
