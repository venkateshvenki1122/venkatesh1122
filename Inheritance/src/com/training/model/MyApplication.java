package com.training.model;
import com.training.services.*;
public class MyApplication {

	public static void main(String[] args) {

		SavingsAccount account = new SavingsAccount(1001,"Venki",1000,"savings","Thamo");
//		System.out.println(account.getAccountHolderName());
//		System.out.println(account.getNominee());
		SavingsAccountService service = new SavingsAccountService();
		
		System.out.println(service.getCustomerInfo(account));
		
		System.out.println(service.calculateInterest(account));
		
		BankAccountService service2 = new SavingsAccountService();
		// Cannot access the sub class method with super class reference
		//service2.getCustomerInfo(account)
		
	SavingsAccountService savingService2 = (SavingsAccountService)service2;
		System.out.println(savingService2.getCustomerInfo(account));
		
		
	}

}
