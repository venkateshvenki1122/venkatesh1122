package com.training.services;

public class ExceptionHandling {

	public void usingArrayIndexException(String[] args) {
		
		try {
			System.out.println(args[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
	System.out.println("Method requireds three values to be passed [a,b,c]");
			//e.printStackTrace();
		}
	}
	
	public void usingNumberFormatException(String value) {
		
		//int age = 0;
		try {
			int age = Integer.parseInt(value);
			System.out.println(age);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Give the numbers");
			e.printStackTrace();
		}
		
	}
	
	public void usingFinallyBlock() {
		int denominator=0;
		
		try {
			System.out.println(4/denominator);
		}catch(ArithmeticException e) {
			System.out.println("Denominator should not be zero");
		}
		finally {
			System.out.println("Inside finally");
		}
		System.out.println("Thanks , Bye Bye");
	}
	
	public String underStandFinallyBlock() {
		int denominator=4;
		
		try {
			System.out.println(4/denominator);
		}catch(ArithmeticException e) {
			System.out.println("Denominator should not be zero");
			try {
				throw new Exception();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Hii");
				//e1.printStackTrace();
			}
			//return "Welcome";
		}
		
		finally {
			System.out.println("Inside finally");
		}
		System.out.println("Thanks , Bye Bye");
		return "Thanks";
	}
	
	
}
