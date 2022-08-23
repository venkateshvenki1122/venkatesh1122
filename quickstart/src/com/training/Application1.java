package com.training;

public class Application1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(args[0]);
//		
//		System.out.println(args[1]);
//		
//		System.out.println(args[2]);
//		
//		int value = Integer.parseInt(args[0]);
//		
//		System.out.println(++value);
		
		CurrencyConverter conv = new CurrencyConverter();
		
		double amount = Double.parseDouble(args[0]);
		
		System.out.println(conv.inrToUsd(amount));
		
		Double inrValue = Double.parseDouble(args[1]);
		//AutoBoxing is used in the above code(It will convert into primitive type)
		System.out.println(conv.inrToEuro(inrValue));
		double salary = 40000.00;
		int intsal = (int)salary;
		int age = 42;
		String strAge = Integer.toString(age);
		
		int intAge = Integer.valueOf(strAge);
	}

}
