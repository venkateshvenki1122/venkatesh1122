package com.example.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;
import com.example.demo.repos.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private Product entity;
	
	@Autowired
	private ProductRepository repo;

	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String initForm(Model model) {
		
		model.addAttribute("title", "Add Products");
		model.addAttribute("command", entity);
		
		return"addProduct";
	}
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public String submitForm(@ModelAttribute("command") Product entity) {
	
		int rowAdded;
		try {
			rowAdded = this.repo.add(entity);
			
			return "success";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "failure";
		}
			//return "addProduct";
	
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String search(Model model) {
		
		model.addAttribute("command", "search Product");
		return "search";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String formSearch(@RequestParam("id") int id,Model model) {
		
		Product product=repo.findById(id);
		model.addAttribute("Object", product);
		return "display";
	}
	 
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Model model) {
		model.addAttribute("command", "Delete Product");
		return "search";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String deleteForm(@RequestParam("id") int id,Model model) {
		
		model.addAttribute("Object","one row deleted");
		return "display";
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String indexForm(Model model) {
		
		model.addAttribute("msg","Index Form");
		return "index";
	}
}
