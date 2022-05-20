package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

//import ch.qos.logback.classic.Logger;

@Service


public class AccountService {

	Logger log = Logger.getAnonymousLogger();

	
	public List<String> getAccounts(){
		
		log.info(" Service Method called");
		return Arrays.asList("Ramesh","Suresh","Magesh");
	}
}
