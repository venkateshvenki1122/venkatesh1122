package com.training;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
public class HandleDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> ageList = Arrays.asList(45,55,65,78,55,80,45);
		
		Set<Integer> filtered = new HashSet<>();
		
		List<Integer> list = ageList.stream()
				.filter(e-> !filtered.add(e))
				.collect(toList());
		
		
		System.out.println(list);
		
		
		
		
		
		
	}

}
