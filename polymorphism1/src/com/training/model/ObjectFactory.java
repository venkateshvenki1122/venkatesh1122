package com.training.model;

public class ObjectFactory {

	public Automobile getObject(int key) {
		
		switch (key) {
		case 1:
			
			return new MarutiCar();
		
		case 2:
			
			return new ToyotaCar();

		default:
			return null;
		}
		
		
	}
	public void printQuote(Automobile poly) {
		
		if(poly!=null) {
		System.out.println(poly.getColor());
		System.out.println(poly.getModel());
		System.out.println(poly.getPrice());
	}else {
		System.out.println("Invalid choice");
	}
		}
	
}
