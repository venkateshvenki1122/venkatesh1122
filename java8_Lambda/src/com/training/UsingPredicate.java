package com.training;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
public class UsingPredicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> names = Arrays.asList("India","Srilanka","Indonesia","Bhutan");
		
		Predicate<String> conditionChar = (country)->country.toUpperCase().startsWith("I");
		Consumer<String> consumer = (value)->{
			if(conditionChar.test(value)) {
				System.out.println(value);
			}
		};
		names.forEach(consumer);
		
		
		
		
	}

}
