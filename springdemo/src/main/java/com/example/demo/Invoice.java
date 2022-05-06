package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Invoice {

	Customer customer;
	Product product;
	
	
@Autowired	
	public Invoice(@Qualifier("suresh")Customer customer,Product product) {
		super();
		System.out.println("Invoice Constructor called ");
		this.customer = customer;
		this.product = product;
	}
	
}
