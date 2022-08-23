package com.training.ifaces;

@FunctionalInterface
public interface Conditional<T> {

	public boolean test(T t);
	
	default boolean negate(Double value) {
		
		return value <=80.00;
	}
	
	public static String getMessage() {
		return "Static Method in Interface - Yes Its Real";
	}
}
