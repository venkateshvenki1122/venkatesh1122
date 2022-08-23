package com.training.services;

import com.training.ifaces.AgeCondition;
import com.training.ifaces.Conditional;

public class StudentResultService implements Conditional<Double> ,AgeCondition<Double> {

	@Override
	public boolean test(Double t) {
		// TODO Auto-generated method stub
		return t>80;
	}

	@Override
	public boolean negate(Double age) {
		// TODO Auto-generated method stub
		// Completely overriding super type with custom code
		//if(age >100) {
			//return true;
		//}else {
			//return false;
		//}
		
		
		
		
		//Calling both the super type
		
		boolean result1 = Conditional.super.negate(age);
		boolean result2 = AgeCondition.super.negate(age);
		if(result1 && result2) {
			return true;
		}else {
			return false;
		}
	}

}
