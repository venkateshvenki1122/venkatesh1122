package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MiniStatement;
import com.example.demo.service.MiniStatementService;

@RestController
@RequestMapping(path = "/api/v1/miniStatement")
public class MiniStatementController {

	
 private MiniStatementService service;
	@GetMapping
	public Map<Long, MiniStatement> viewMiniStatement(long accountNumber,double amount,double balance) {
	
	return this.service.viewMiniStatement(accountNumber, amount, balance);
	}
}