package com.example.stub;

import java.util.Arrays;
import java.util.List;

import com.example.ifaces.StudentRepository;
import com.example.model.Student;

public class StudentRepositoryStub implements StudentRepository {

	@Override
	public Student add(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return Arrays.asList(new Student(201, "Thamo"),new Student(202,"Guru"));
	}

}
