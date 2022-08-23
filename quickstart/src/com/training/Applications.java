package com.training;

public class Applications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account = new BankAccount("Venki",1000);
		
		//System.out.println(account.getUpdatedBalance(2000));
		
		//System.out.println(BankAccount.getCount());
		BankAccount account2 = new BankAccount("kawin",2000);
		System.out.println(account2.getUpdatedBalance(2000));
		System.out.println(account2.getAccountNumber());
		//System.out.println(account2.getUpdatedBalance(2000));
		
		BankAccount account3 = new BankAccount("Prawin",500);

		System.out.println(account3.getUpdatedBalance(200));
		System.out.println(account3.getAccountNumber());
		BankAccount account4 = new BankAccount("Thamo",500);

		System.out.println(account4.getUpdatedBalance(200));
		System.out.println(account4.getAccountNumber());
		//System.out.print(account4.setAccountNumber(200));
	}

}
