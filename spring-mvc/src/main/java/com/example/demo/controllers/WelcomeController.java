package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc")
public class WelcomeController {

	@RequestMapping(value ="/greet",method = RequestMethod.GET)
	@ResponseBody
	public String getMessage() {
		
		return "<h1 style='color:red;text-align:center;font-size:50;font-style:times'> Welcome to Spring MVC</h1>";
	}
	
	
	
}
