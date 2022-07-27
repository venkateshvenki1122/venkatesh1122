package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AccountHolder;
import com.example.demo.repo.AccountHolderRepository;

@Service
public class AccountHolderService {
	
	@Autowired
	private AccountHolderRepository repo;
	
	
	Map<Long, List<Double>> miniScript;
	//List<Object> list = new ArrayList<>();
	
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
		
		double amt1 = 0.0;
		double amt2 = 0.0;
		
		if (account1.getBalance() >= amount) {
			
			amt2 = account2.getBalance()+ amount;
			account2.setBalance(amt2);
			repo.balanceAfterTransfer1(amt2, accountNumber2);
			
			amt1 = account1.getBalance()-amount;
			account1.setBalance(amt1);
			repo.balanceAfterTransfer(amt1, accountNumber1);
			
		
		}else
		{
			
			return  " Not enough money to Transfer";
		}
		setMiniScript(accountNumber1, amount);
		return account1.getBalance();
	}
	
	
	public void setMiniScript(long accountNumber,double amount) {
		miniScript=new TreeMap<>();
		List<Double>amountList=miniScript.get(accountNumber);
		amountList.add(amount);
		if(!(miniScript.containsKey(accountNumber))) {
			
			miniScript.put(accountNumber, amountList);
		}
	}
	public List<Double> getMiniScript(long accountNumber){
		return miniScript.get(accountNumber);
	}
	
	
}	
