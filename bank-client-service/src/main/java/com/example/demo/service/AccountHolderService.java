package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AccountHolder;
import com.example.demo.entity.MiniScript;
import com.example.demo.repo.AccountHolderRepository;
import com.example.demo.repo.CrudRepository;


@Service
public class AccountHolderService implements CrudRepository{
	
	@Autowired
	private AccountHolderRepository repo;
	
//	@Autowired
//	private MiniScriptService miniService;
	
	Map<Long,List<MiniScript>> miniScript=new TreeMap<>();
	
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
			this.repo.balanceAfterTransfer1(amt2, accountNumber2);
			//setMiniScript(accountNumber2, amount,"Credit");

			
			amt1 = account1.getBalance()-amount;
			account1.setBalance(amt1);
			this.repo.balanceAfterTransfer(amt1, accountNumber1);
			setMiniScript(accountNumber1, amount,"Debit",LocalDateTime.now());

			
			
		}
		else{
			return  " Not enough money to Transfer";
		}
		
		return account1.getBalance();
	}
	@Override
	public void setMiniScript(long accountNumber, double amount, String type,LocalDateTime dateTime) {
		List<MiniScript> amountList=new ArrayList<MiniScript>();
		
		if(miniScript.containsKey(accountNumber)) {
			amountList=miniScript.get(accountNumber);
			MiniScript scriptValues=new MiniScript(dateTime, amount, type);
			amountList.add(scriptValues);
		}
		else {
			
			miniScript=new TreeMap<>();
			MiniScript scriptValues=new MiniScript(dateTime, amount, type);
			amountList.add(scriptValues);
		}

		miniScript.put(accountNumber, amountList);
	}

	@Override
	public List<MiniScript> getMiniScript(long accountNumber) {
		return miniScript.get(accountNumber);
	}
	
	
}	
