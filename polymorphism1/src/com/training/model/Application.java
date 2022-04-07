package com.training.model;

public class Application {

	public static void main(String[] args) {
		
		ObjectFactory factory = new ObjectFactory();
		//PrintQuote quote = new PrintQuote();
		Automobile maruti = factory.getObject(1);
		Automobile toyato = factory.getObject(2);
		
		factory.printQuote(toyato);
		System.out.println("*****************"+Automobile.SHOWROOM+"*******************");
		factory.printQuote(maruti);
		

	}

}
