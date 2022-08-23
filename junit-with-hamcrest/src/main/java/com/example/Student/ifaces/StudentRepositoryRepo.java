package com.example.Student.ifaces;

import java.util.Optional;

import com.example.model.Student;

public interface StudentRepositoryRepo {

    public Optional<Student> findByRollNumber(int rollNumber);
	
	public Optional<Student> deleteByRollNumber(int rollNumber);
}
