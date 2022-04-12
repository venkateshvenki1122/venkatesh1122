package com.training.model;

public class SavingsAccount extends BankAccount {

	private String nominee;
	//Whenever sub class constructor is called its super class constructor also called.
	//Even if super() key word is not present

	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SavingsAccount(int accountNumber, String accountHolderName, double balance, String accountType,
			String nominee) {
		super(accountNumber, accountHolderName, balance, accountType);
		this.nominee = nominee;
	}
	public String getNominee() {
		return nominee;
	}
	public void setNominee(String nominee) {
		this.nominee = nominee;
	}
	
//	public SavingsAccount() {
//		
//		System.out.println("Constructor of SUB CLASS called");
//	}
//	public SavingsAccount() {
//		super(1020,"Venki",5000,"savings");
//		System.out.println("Constructor of SUB CLASS called");
//	}
	
	
}
