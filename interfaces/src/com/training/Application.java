package com.training;

import com.training.ifaces.CheckCondition;
import com.training.ifaces.Conditional;
import com.training.ifaces.Function;
import com.training.services.CurrencyConverter;

public class Application {

	public static void main(String[] args) {
		
		
		//subtype = new subtype
		
		
		Function converter = new CurrencyConverter(); 
		System.out.println(Function.COUNTER);
		//CurrencyConverter converter = new CurrencyConverter();
		
		System.out.println("Response :"+ converter.apply(10));
		
		System.out.println("Response1 :"+ converter.apply(20));
		
		if(converter instanceof CheckCondition) {
			CheckCondition obj =(CheckCondition)converter;
			System.out.println(obj.test(10));
		}
		//CurrencyConverter con = new CurrencyConverter();
		
		Conditional conobj = new DiscountCalculator();
		
		System.out.println(conobj.test(400));
		System.out.println(conobj.negate(400));
		
	}

}
