package com.example.fake;

import java.util.ArrayList;
import java.util.List;

import com.example.ifaces.StudentRepository;
import com.example.model.Student;

public class StudentRepoFake implements StudentRepository {

	
	private List<Student> list;
	
	public  StudentRepoFake() {
		
		super();
		list = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public Student add(Student entity) {
		// TODO Auto-generated method stub
		return list.add(entity)? entity:null;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return this.list;
	}

}
