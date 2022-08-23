package com.example;

import com.example.model.*;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student ram = new Student();
		ram.setRollNumber(1001);
		//public method able to access
		//System.out.println("RollNumber :" +ram.getRollNumber());
		//ram.setFirstName("Venki");
		//unable to access because Student class in com.example.package
		//Application class in com.example package
		//System.out.println("Name \t:" +ram.getFirstName());
		//ram.setMarkScored(95);
		// unable to access because Application class is not a subclass of a Student class
		//System.out.println("Marks Scored :" + ram.getMarkScored());
		//ram.setBranch("BE.CSE");
		// unable to access because the method is in private in Student class
		//System.out.println("Branch :"+ram.getBranch());
		Student thamo = new Student(11,"thamo","cse",99);
		//System.out.println("Thamo"+thamo.getFirstName());
		//System.out.println("Thamo Branch :"+thamo.getBranch());
		Student guru = new Student (100,"guru","ece");
		System.out.println(guru.getRollNumber());
		System.out.println(guru.getFirstName());
		System.out.println(guru.getBranch());
		System.out.println(guru.getMarkScored());
		Student kawin = new Student(101,"kawin","cse");
		
		
	}

}
