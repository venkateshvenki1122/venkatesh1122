package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MiniStatement;
import com.example.demo.repo.AccountHolderRepository;
import com.example.demo.repo.MiniStatementRepository;

@Service
public class MiniStatementService {

	
	private AccountHolderService service;
	
	MiniStatement mini;
	Map<Long, MiniStatement> map=new HashMap<Long, MiniStatement>(); 
	
	public Map<Long, MiniStatement> viewMiniStatement(long accountNumber,double amount,double balance) {
		
		
		mini=new MiniStatement();
	      mini.setBalance(balance);
	      mini.setAccountNumber(accountNumber);
	      mini.setAmount(amount);
	      map.put(accountNumber, mini);
		
		
		return map;
		
	}
	
}
