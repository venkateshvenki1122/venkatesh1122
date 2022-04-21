package com.training.model;

public class Application {
	
	
	public static void printPremium(Insurance object) {
		
		System.out.println("Premium :" +object.calculatePremium());
	}

	public static void main(String[] args) {

	VehicleInsurance car = new VehicleInsurance(1010, "Venki","car", 2019);
		
		printPremium(car);
		
		LifeInsurance life = new LifeInsurance(1001, "Thamo", 21);
		
		printPremium(life);
		
		String[] illness = {"bp","sugar","thyroid","ent"};
		HealthInsurance health = new HealthInsurance(1001,"Guru",illness);
		
		printPremium(health);
	}

}
