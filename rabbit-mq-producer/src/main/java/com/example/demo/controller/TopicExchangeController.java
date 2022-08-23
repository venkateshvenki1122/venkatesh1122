package com.example.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.direct.config.TopicExchangeConfig;
import com.example.demo.entity.Student;

@RestController
public class TopicExchangeController {

	@Autowired
	@Qualifier("second")
	private RabbitTemplate template;
	
	@PostMapping(path = "/topic/students")
	public String addStudent(@RequestBody Student entity) {
		
		String routeKey = "award.ece.2022";
		 
		if (entity.getStudentId()>200) {
			
			routeKey = "award.cse.2022";
		}
		
		template.convertAndSend(TopicExchangeConfig.EXCHANGE_NAME,routeKey,entity);
		
		return " Added One";
	}
}
