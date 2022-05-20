package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;

@SpringBootApplication
public class SpringDataJpaSimpleMappingApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.
			run(SpringDataJpaSimpleMappingApplication.class, args);
	
	Doctor siva = ctx.getBean(Doctor.class);
	DoctorService service = ctx.getBean(DoctorService.class);
//	
//	Doctor added = service.add(siva);
//	
//	if(added!=null) {
//		
//		System.out.println("One Doctor Added");
//	}
	
	//service.findAll().forEach(System.out::println);
	
	//service.findByDepartment("ENT").forEach(System.out::println);
	
	//System.out.println(service.findByDoctorName("Siva Kolunthu"));
	
	//service.findByDoctorNameAndDepartment("Sivan", "ENT").forEach(System.out::println);
	
	service.getByNameDept("Sivan", "ENT").forEach(System.out::println);
	
	ctx.close();
	}

	@Bean
	public Doctor siva() {
		
		return new Doctor(2027,"Siva Kolunthu","Bone Specialist",5740);
	}
//	@Bean
//		public Doctor sivan() {
//		
//		return new Doctor(2020,"Siva","eng",63740);
//	}
	
}
