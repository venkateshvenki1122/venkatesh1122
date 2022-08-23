package com.training;

import java.util.Optional;

public class UsingOptional {
	
	public static Optional<String> getValue(int key){
		
		Optional<String> response = Optional.empty();
		if (key == 1) {
			response = Optional.of("Hi");
		}
		return response;
	}

	public static Object getString(int key) {
		
		switch (key) {
		case 1:
			
			return new String("Chocobar");
		case 2:
			return new StringBuffer("Cassatta");

		default:
			return null;
		}	
	}
	
	
	
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		// Will throw NullPointerException for values 3 and above
		//System.out.println(getString(3).toString());
		
		//To avoid NullPointerException and return a default value
		//New feature of java 8 Optional is used
		Optional<Object> optional = Optional.ofNullable(getString(3));
		
		System.out.println(optional.orElse("Vannila"));
		
		//Here we are checking if the value is present
		//It is present then only we will call get method
		
		Optional<Object> opt2 = Optional.ofNullable(getString(3));
		if(opt2.isPresent()) {
			System.out.println("Value is Present"+opt2.get());
		}else {
			System.out.println("Value is not present");
		}
		
		//Optional<Object> opt3 = Optional.ofNullable(getString(3));
		//opt3.orElseThrow(()->new RuntimeException("No Object for value 3 Try again"));
		
		
		Optional<String> opt4 =getValue(1);
		System.out.println(opt4);
//		if(opt4.isPresent()) {
//			System.out.println(opt4.get().toString());
//		}else {
//			System.out.println("Invalid choice Enter 1");
//		}
//		
		//Optional<String> opt5 = Optional.ofNullable(getValue(2));
		try {
			opt4.orElseThrow(()-> new Exception ("Invalid Choice"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
