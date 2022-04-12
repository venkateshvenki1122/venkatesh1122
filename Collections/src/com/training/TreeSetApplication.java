package com.training;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.training.model.Student;

public class TreeSetApplication {

	public static void main(String[] args) {
		
		Student venki = new Student(101,"Venki",78);
		
		Student kawin = new Student(102, "Kawin", 90);
		
		Student prawin = new Student(103, "Prawin", 88);
		Student chinnaThambu = new Student(103, "Prawin", 88);
		
		Set<Student> set = new TreeSet<>();
		set.add(venki);
		set.add(kawin);
		set.add(prawin);
		set.add(chinnaThambu);
		
		//System.out.println(set);
		
		for (Student student : set) {
			
			System.out.println(student.getFirstNAme());
		}
		

	}

}
