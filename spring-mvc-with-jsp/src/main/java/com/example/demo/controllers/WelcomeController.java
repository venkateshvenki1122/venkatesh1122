package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Product;
import com.example.demo.repos.ProductRepository;

@Controller
@RequestMapping("/mvc")

public class WelcomeController {

	
	private ModelAndView mdlView;
	
	private ProductRepository product;

	

//	@Autowired
//	public WelcomeController(ModelAndView mdlView) {
//		super();
//		this.mdlView = mdlView;
//		
//	}
	public WelcomeController(ModelAndView mdlView, ProductRepository product) {
		super();
		this.mdlView = mdlView;
		this.product = product;
	}
	

	@RequestMapping(value ="/first",method = RequestMethod.GET)
	public String getFirstPage() {
		
		return "welcome";
	}
	
	@RequestMapping(value="/second",method=RequestMethod.GET)
	public ModelAndView getHomePage() {
		
		List<Product> prdList = product.findAll();
		 mdlView.addObject("list",prdList);
		 mdlView.setViewName("home");
		 return mdlView;
	}

	
}
