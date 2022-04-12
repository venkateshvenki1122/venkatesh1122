package com.training.services;

import com.training.model.BankAccount;

public class BankAccountService {

	public double calculateInterest(BankAccount account) {
		   
		double simpleInterest = 0.05;
		
		if(account.getAccountNumber()<5000)
			
			simpleInterest = 0.06;
		
		return account.getBalance()*1*simpleInterest;
			
	}
	// OverLoaded Method	
	public void calculateInterest (BankAccount[] accounts) {
		
		for(BankAccount eachAccount : accounts) {
			
			double simpleInterest = 0.05;
			System.out.println(calculateInterest(eachAccount));
		}
	}
	
	public double[] findInterest(BankAccount[] accounts) {
		
		double[] values = new double[3];
		int i = 0;
	for(BankAccount eachAccount : accounts) {
			
			double simpleInterest = 0.05;
			values[i]= calculateInterest(eachAccount);
			
			i++;
		}
	
	return values;
	}
	
	private double calculateByAccountType(BankAccount account, double rateOfInterest) {
		
//		String type = account.getAccountType();
//		double rateOfInterest = 0.07;
//		
//		if(type.equals("savings")) {
//			rateOfInterest = 0.05;
//		}
//		
//		if(type.equals("fixed") || type.equals("recurring")) {
//			rateOfInterest = 0.06;
//		}
		
		
//		return rateOfInterest;
		return account.getBalance()*1*rateOfInterest;
	}
	
	
	
	
	public double[] findInterestByAccountType(BankAccount[] accounts) {
		
		double[] values = new double[accounts.length];
		int i = 0;
		for(BankAccount eachAccount : accounts) {
			if(eachAccount!=null) {
			String key = eachAccount.getAccountType();
			
			switch (key) {
			case "savings":
				//double value = calculateByAccountType(eachAccount);
				//values[i] = value;
				values[i] = calculateByAccountType(eachAccount, 0.5);
				break;

			case "fixed" :
				//double value1 = calculateByAccountType(eachAccount);
				//values[i] = value1;
				values[i]= calculateByAccountType(eachAccount, 0.7);
				break;
			case "recurring" :
				//double value2 = calculateByAccountType(eachAccount);
				//values[i] = value2;
				values[i] = calculateByAccountType(eachAccount, 0.7);
				break;
				
			default:
				
				break;
			}
			i++;
			}
		}return values;
	}
	
}
