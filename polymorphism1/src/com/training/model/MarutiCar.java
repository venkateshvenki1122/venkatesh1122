package com.training.model;

public class MarutiCar implements Automobile {

	@Override
	public String getColor() {

		String color = "Red";
		
		return color;
	}

	@Override
	public String getModel() {
		
		String model = "Suzuki";
		
		return model;
	}

	@Override
	public double getPrice() {
		
		double price = 500000;
		
		return price;
	}

}
