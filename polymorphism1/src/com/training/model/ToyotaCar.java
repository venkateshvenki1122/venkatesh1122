package com.training.model;

public class ToyotaCar implements Automobile {

	@Override
	public String getColor() {

		String color = "Black";
		
		return color;
	}

	@Override
	public String getModel() {
		
		String model = "Galanza";
		
		return model;
	}

	@Override
	public double getPrice() {
		
		double price = 900000;
		
		return price;
	}

}
