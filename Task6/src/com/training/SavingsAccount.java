package com.training;

public class SavingsAccount extends BankAccount {

	
	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(double minimumBalance, double deposit) {
		super(minimumBalance, deposit);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double deposit(double amount) {

		//double minimumBalance;
		if(amount < getMinimumBalance()) {
			
		System.out.println("You should maintain minimum balance of 5000");
		}
		
		
		return getMinimumBalance() - amount;
	}

	@Override
	public double withdraw(double amount) {

		if(amount >getDeposit()) {
			System.out.println("Deposit Less than 100000");
		}
		
		return 0;
	}

}
