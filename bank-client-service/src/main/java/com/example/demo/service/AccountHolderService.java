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
	
	double accountBalance1 = 0.0;
	double accountBalance2 = 0.0;
	
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
	
	public Object balanceAfterTransfer(double amount,
			long accountNumber1,long accountNumber2) {
		
		AccountHolder account1 = findByAccountNumber(accountNumber1);
		AccountHolder account2 = findByAccountNumber(accountNumber2);
		
		double amt = 0.0;
		double amt1 = 0.0;
		
		if (account1.getBalance() >= amount) {
			
			amt = account2.getBalance()+ amount;
			account2.setBalance(amt);
			repo.balanceAfterTransfer1(amt, accountNumber2);
			
			amt1 = account1.getBalance()-amount;
			account1.setBalance(amt1);
			repo.balanceAfterTransfer(amt1, accountNumber1);
		
		}else
		{
			
			return  "Pothumaana alavuku kaasu illada ";
		}
		
		return account1;
	}
	
}	

