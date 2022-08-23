package com.example.mockito.module1;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.omg.CORBA.RepositoryIdHelper;

import com.example.Student.ifaces.StudentRepositoryRepo;
import com.example.ifaces.*;
import com.example.model.Student;
import com.example.service.StudentService;
public class StudentServiceTest {


	@Mock
	StudentRepository repo; //= Mockito.mock(StudentRepository.class);
	
	@Mock
	StudentRepositoryRepo studRepo; 
	
	@Mock
	StudentService serviceMock;
	
	@InjectMocks
	StudentService service;  //= new StudentService(repo);
	
	
//	@Test
//	@DisplayName(value = "Test FindAll Method with Mockito stub")
//	void testFindAll() {
//		
//	
//		
//		Student venki = new Student(501, "Venki");
//		Student thamo = new Student(502, "Thamo");
//		Student guru = new Student(503, "Guru");
//		
//		List<Student> list = new ArrayList<Student>();
//		list.add(venki);
//		list.add(thamo);
//		list.add(guru);
//		
//		//Stubbing
//		
//		Mockito.when(repo.findAll()).thenReturn(list);
//		
//		assertEquals(service.findStudentSize(), 3);
//		
//		
//	}
//	
//	@DisplayName(value = "Test addWithCondition Method of the service "
//			+ "it should add elements only roll number is greater than 2000"
//			+ "else it should return a null value")
//	@Test
//	void testAddWithCondition() {
//		
//		
//		
//		int rollNumber = 2000;
//		
//		Student sam = new Student(2022, "Sam");
////		List<Student> list = new ArrayList<Student>();
////
////		list.add(sam);
////		
//		assertNotNull(service.addWithCondition(sam));
//	}
//	
//	@Test
//	void verifyAddWithCondition() {
//
//		
//		
//		Student stud = new Student(2020,"Raja");
//		//serviceMock.addWithCondition(stud);
//		service.addWithCondition(stud);
//		
//		verify(service, times(1)).addWithCondition(stud);
//	}
	@Test
	void testFindByCondition() {

		Student venki = new Student(101, "Venki");
		Student sun = new Student(102, "sun");
		//stubbing
		Mockito.when(studRepo.findByRollNumber(101)).thenReturn(Optional.of(venki));


		//assertNotNull(asgservice.findByRollNumber(101));



		Optional<Student> expected = service.findByRollNumber(101);
		assertEquals(expected, 101);


		verify(studRepo).findByRollNumber(venki.getRollNumber());

		}
	
}
