package com.example.dummy;

import java.util.List;

//import com.example.fake.StudentRepoFake;
import com.example.ifaces.ProfessorRepository;
import com.example.ifaces.StudentRepository;
import com.example.model.Student;

public class StudentProfessorService {

	
private StudentRepository repo;
private ProfessorRepository prof;
	
	public StudentProfessorService(StudentRepository repo) {
		
		super();
		this.repo = repo;
	}
	
	public StudentProfessorService(StudentRepository fake, ProfessorRepository dummy) {
		// TODO Auto-generated constructor stub
		super();
		this.repo = repo;
		this.prof = prof;
		
	}

	public Student add(Student entity) {
		
		return this.repo.add(entity);
	}
	
	public List<Student> findAll(){
		
		return this.repo.findAll();
	}
}
