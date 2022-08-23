package com.example.demo;

import java.util.Scanner;
import java.util.*;

public class Application2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the Name :");
		
		String name = scan.nextLine();
		
		System.out.println("Enter the Farenheit Temp :");
		
		double farenTemp = scan.nextDouble();
		System.out.println("Enter the amount :");
		double amount = scan.nextDouble();
		System.out.println("Enter the curreny to convert 1-USD 2-EURO:");
		int frm = scan.nextInt();
		
		Converter converter = new Converter();
		
		System.out.println("Name :"+converter.convert(name));
		System.out.println("Farenheit :"+converter.convert(farenTemp));
		
		System.out.println(converter.convert(amount, frm));
		
		
		
		
		
		
		scan.close();
	}

}
