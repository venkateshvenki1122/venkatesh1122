package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Customer;
import com.example.demo.Product;
import com.example.demo.Student;
import com.example.demo.Teacher;

@Configuration
public class AppConfig {
	
	//ID of the bean as the method name
	@Bean
	public Student venki() {
		
		return new Student(101,"Venki",89);
	}
	@Bean
	public Teacher harish() {
		
		return new Teacher(4848,"Harish","Computer");
	}

	@Bean
	public Product tv() {
		
		return new Product(101,"sony tv");
	}
	
	@Bean 
	public Customer suresh() {
		
		return new Customer(202,"suresh");
	}
	
	@Bean
	public Customer magesh() {
		
		return new Customer(890, "magesh");
	}
	
	@Bean
	public Customer rajesh() {
		
		return new Customer(891, "Rajesh");
	}
}
