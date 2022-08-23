package com.example.demo;

public class Converter {

	public String convert(String str) {
		
		return str.toUpperCase();
	}
	//Creating a overloaded method 
	
	public double convert(double farenTemp) {
		
		return (farenTemp-32)*5/9;
	}
	
	public double convert(double amount,int frm) {
		
		if(frm==1)
			return amount*100;
		else
			return amount*120;
	}
	
}
