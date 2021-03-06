package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AccountHolder;
import com.example.demo.entity.MiniScript;
import com.example.demo.service.AccountHolderService;

@RestController
@RequestMapping (path ="/api/v1/accountholder")
public class AccountHolderController {

	@Autowired
	private AccountHolderService service;
	
	
	
	@GetMapping
	public List<AccountHolder> findAll(){
		
		return this.service.findAll();
	}
 	
	@PostMapping(path="/add")
	public AccountHolder add( @RequestBody AccountHolder entity) {
		
		return this.service.add(entity);
	}
	
	@GetMapping(path = "/{accountNumber}")
    public AccountHolder findByAccountNumber(@PathVariable("accountNumber") long accountNumber) {
		
		return this.service.findByAccountNumber(accountNumber);
	}
	
	
	@GetMapping(path = "/balance/{accountNumber}")
	public double balanceAmount(@PathVariable("accountNumber") long accountNumber) {
		
		return this.service.balanceAmount(accountNumber);
	}
	
	@PutMapping(path = "/transfer/{accountNumber1}/{accountNumber2}/{amount}")
	public Object transferAmount(@PathVariable("accountNumber1")long accountNumber1,@PathVariable("accountNumber2")long accountNumber2,@PathVariable("amount")double amount) {
	
		return this.service.balanceAfterTransfer(amount, accountNumber1, accountNumber2);
	}
	
	@GetMapping(path="/view/miniscript/{accountnumber}")
	public List<MiniScript> getMiniStatement(@PathVariable("accountnumber")long accountNumber){
		return this.service.getMiniScript(accountNumber);
	}
	
	
	
}
