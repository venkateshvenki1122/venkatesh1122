package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student ram = new Student(101, "Venki",
				LocalDate.of(2001, 10, 11),
				LocalDateTime.of(2000, Month.OCTOBER, 22, 10, 30));
		
		Student shyam = new Student(102, "Thamo",
				LocalDate.now(),
				LocalDateTime.now());
		
		System.out.println("Rams year of birth :" +ram.getDateOfBirth().getYear());
		System.out.println("Rams first birthday :" + ram.getDateOfBirth().plus(5, ChronoUnit.MONTHS));
		
		System.out.println("Shyams year of birth :" + shyam.getDateOfBirth().getYear());;
		
		System.out.println("Thamo birthday :" + shyam.getDateOfBirth()
		+"             Thamo Joining   " 
		+ shyam.getDateOfJoining());
	}

}
