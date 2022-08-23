package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConfigClientOneApplication {
	
	//@Value("${customer.firstName}")
	
//	private String name;
//	
//	@GetMapping(path="/names")
//	public String getName() {
//		
//		return this.name;
//	}
	
	
	@GetMapping(path="/employees")
	public List<Employee> findAll(){
		
		return this.findAll();
	}

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(ConfigClientOneApplication.class, args);
		
		EmployeeRepository repo = ctx.getBean(EmployeeRepository.class);
		
		repo.findAll().forEach(System.out::println);
	}

}
