package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties.ConfigureAction;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@SpringBootApplication
public class SpringDataJpaTask1Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(SpringDataJpaTask1Application.class, args);
	
	Employee employee = ctx.getBean(Employee.class);
	
	EmployeeService service = ctx.getBean(EmployeeService.class);
	
//	Employee added = service.add(employee);
//	
//	if(added!=null) {
//		
//		System.out.println("One row added");
//	}
//	
	//service.findByDateOfBirth(LocalDate.of(2001, 10, 11)).forEach(System.out::println);
	
	//service.findByLocation("Madurai").forEach(System.out::println);
	
	//service.findBySkillSet("Java").forEach(System.out::println);
	//service.findAll().forEach(System.out::println);
	
	service.getByLocation("Chennai", "Android").forEach(System.out::println);
	
	//service.findByLocationAndSkillSet("Madurai", "Java")
	//.forEach(System.out::println);
	
	ctx.close();
	}

	@Bean
	public Employee venki() {
		
		return new Employee(104,"Kawin",LocalDate.of(2001, 10,04),"Madurai","Java",8857523);
	}
}
