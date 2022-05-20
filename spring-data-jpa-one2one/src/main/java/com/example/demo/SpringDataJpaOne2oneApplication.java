package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Seminar;
import com.example.demo.entity.Speaker;
import com.example.demo.utils.SeminarUtil;

@SpringBootApplication
public class SpringDataJpaOne2oneApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(SpringDataJpaOne2oneApplication.class, args);
	
	SeminarUtil util = ctx.getBean(SeminarUtil.class);
	
	util.create();
	
	
	ctx.close();
	}

	@Bean
	public Speaker speak() {
		
		return new Speaker(201,"sony","Louder");
	}
	@Bean
	public Seminar venki() {
		
		Seminar sem = new Seminar();
		sem.setId(101);
		sem.setName("Database");
		sem.setDuration(10);
		return sem;
	}
}
