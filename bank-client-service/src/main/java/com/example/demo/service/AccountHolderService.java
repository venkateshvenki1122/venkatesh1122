package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AccountHolder;
import com.example.demo.repo.AccountHolderRepository;

@Service
public class AccountHolderService {
	
	@Autowired
	private AccountHolderRepository repo;
	
	@Autowired
	private AccountHolder account;
	
	public List<AccountHolder> findAll(){
		
		return this.repo.findAll();
	}
	
	public AccountHolder findByAccountNumber(long accountNumber) {
		
		return this.repo.findByAccountNumber(accountNumber);
	}
	
	public AccountHolder add(AccountHolder entity) {
		
		return this.repo.save(entity);
	}
	
	public double balanceAmount(long accountNumber) {
		
		AccountHolder account = findByAccountNumber(accountNumber);
		
		double balance = account.getBalance();
		
		return balance;
	}

}
