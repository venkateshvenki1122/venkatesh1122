package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

	public static void main(String[] args) {
		
		Logger log = Logger.getLogger("First.log");//("com.example.Application");
		
		log.setLevel(Level.WARNING);
		
		log.info("Info Message");
		
		log.warning("Warning Message ************");
		
		log.severe("Severe Message ******");
		//System.out.println("Info Message");
		
		log.fine("I am fine Message =======================");
		
		

	}

}
