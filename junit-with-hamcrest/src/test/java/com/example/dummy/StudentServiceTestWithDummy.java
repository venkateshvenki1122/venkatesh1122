package com.example.dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.fake.StudentRepoFake;
import com.example.ifaces.ProfessorRepository;
import com.example.model.Student;
import com.example.service.StudentService;

public class StudentServiceTestWithDummy {

	@DisplayName(value = "Test Add Method Return inserted object back")
	@Test
	void testAddMethod() {
		
		StudentRepoFake fake = new StudentRepoFake();
		DummyRepo dummy = new DummyRepo();
		
		StudentProfessorService service = new StudentProfessorService(fake, dummy);
		
		Student ram = new Student(101, "Ram");
		
		Student actual = service.add(ram);
		
		assertEquals(actual, ram);
	}
}
