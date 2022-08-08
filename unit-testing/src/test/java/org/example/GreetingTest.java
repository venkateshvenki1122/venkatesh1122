package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GreetingTest {

	@Test
	@DisplayName(value = "Test the Get Message return a string of Length 8 charactes")
	void testMaxLength() {
		
		Greeting grtObj = new Greeting();
		
		int actual = grtObj.getMessage().length();
		
		int expected = 7;
		
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName(value = "Test the Birthday wish method does not return null")
	void testBirthdayWish() {
		
		Greeting grtObj = new Greeting();
		
		String actual = grtObj.birthdayWish("Punnya");
		
		assertNotNull(actual);
	}
	
	
	@Test
	@DisplayName(value = "Test Birthday Wish method should return Happy Birthday with user name suffixed")
	
	void testBirthdayWishWithName() {
		
		Greeting grtObj = new Greeting();
		
		String name = "Punnya";
		
		String actual = grtObj.birthdayWish(name);
		
		String expected =  "Happy Birthday "+ name;
		
		
		assertEquals(expected, actual);
	}
	
	
}
