package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.utils.DoctorUtils;

@SpringBootApplication
public class SpringDataJpaOne2manyApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(SpringDataJpaOne2manyApplication.class, args);
	
//	Doctor doci = ctx.getBean(Doctor.class);
//	
//	Patient patient = ctx.getBean(Patient.class);
//	
	DoctorUtils util = ctx.getBean(DoctorUtils.class);
	
	//util.create();
	util.findAll();
	
	ctx.close();
	}

	@Bean
	public Doctor venki() {
		
		Doctor doctor = new Doctor();
		doctor.setDoctorId(101);
		doctor.setDoctorName("Venki");
		doctor.setPhoneNumber(7904749);
		doctor.setDepartment("ENT");
		return doctor;
	}
	
	@Bean
	public Patient thamo() {
		
		return new Patient(201,"Thamo",876565);
	}
	
	@Bean
	public Patient guru() {
		
		return new Patient(202,"Guru",976565);
	}
	
	@Bean
	public Patient sathish() {
		
		return new Patient(203,"sathish",676565);
	}
}
