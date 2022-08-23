package com.example;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import com.example.service.ProductService;

public class ProductServiceTest {

	ProductService service = null;
	@BeforeEach
	void init() {
		
		service = new ProductService();
	}
	
	@DisplayName(value = "Test findDiscount method returns 0.20 or above "
			+ "for tv and laptops")
	@Test
	void testFindDiscount() {
		
		double actual = service.findDiscount("tv");
		
		assertThat(actual, is(greaterThan(0.19)));
	}
	
	@DisplayName(value = "Test findProducts method returns a list of four brands")
	@Test
	void testFindProductsReturns() {
		
		List<String> list = new ArrayList<String>();
		list = service.findProduct();
		int length = list.size();
		
		assertThat(4, is(equalTo(length)));

	}
	
	@DisplayName(value = "Test findProducts method returns a list containing"
						+"Dell,Lenova,Hp,Asus for product laptop")
	@Test
	void testFindProductHasItems() {
		
		List<String> products = service.findProduct();
		
		assertThat(products, is(hasItems("Dell","Lenova","Hp","Asus")));
	}
	
}
