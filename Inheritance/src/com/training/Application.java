package com.training;
import com.training.model.*;
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount account = new BankAccount(1010,"Venki",50000,"savings");
		System.out.println(account.toString());
	}

}
