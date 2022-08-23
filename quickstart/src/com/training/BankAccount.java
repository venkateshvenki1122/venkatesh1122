package com.training;

public class BankAccount {
	//Static variable 
	private static int count;
	
	//Instance variable
	private String accountHolderName;
	private double balance;
	private int accountNumber;
	static int temp;
	public int getAccountNumber() {
		accountNumber = ++temp + accountNumber;
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	//Static method
	public static int getCount()
	{
		
		return ++count;
		
	}
	
	public double getUpdatedBalance(double amount) {
		//Local variable
		//double updatedBalance;
		
		//double currentBalance=0;
		//Local variable should be initialized before using
		//System.out.println(updatedBalance);
		//currentBalance = this.balance+amount;
		//this.balance = currentBalance;
		this.balance = this.balance + amount;
		return this.balance;
	}

	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(String accountHolderName, double balance) {
		super();
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static void setCount(int count) {
		BankAccount.count = count;
	}
	
}
