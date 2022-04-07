package com.task.training;

public class Application {

	public static void main(String[] args) {
		
		Address address = new Address(22, "ManiStreet", "Madurai");

		MobileBill bill = new MobileBill("Venki", 7904749066L, "prepaid",address );
		System.out.println("Amount :" + bill.findAmount());
		//System.out.println(bill.getAddress());
		System.out.println(MobileBill.SERVICEPROVIDER);
		System.out.println(bill.toString());
	}

}
