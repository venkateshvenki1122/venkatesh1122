package com.training;

import com.training.ifaces.Conditional;
import com.training.services.StudentResultService;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentResultService student = new StudentResultService();
		
		System.out.println("Is Pass :" + student.test(90.0));
		
		System.out.println("Is Fail :" + student.negate(90.00));
		System.out.println(Conditional.getMessage());
	}

}
