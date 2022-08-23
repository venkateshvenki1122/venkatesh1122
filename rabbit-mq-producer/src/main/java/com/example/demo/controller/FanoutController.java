package com.example.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.direct.config.FanOutExchange;
import com.example.demo.entity.Student;

@RestController
public class FanoutController {


	@Autowired
	private RabbitTemplate template;
	
	@PostMapping(path = "/add")     
	public String addStudent(@RequestBody Student entity) {
		
		template.convertAndSend(FanOutExchange.EXCHANGE,"",entity);
		
		return "One Student Added";
	}
}
