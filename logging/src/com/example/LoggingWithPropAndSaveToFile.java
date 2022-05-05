package com.example;

import java.io.IOException;
import java.util.logging.FileHandler;

import com.example.model.Book;

public class LoggingWithPropAndSaveToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file	=LoggingWithPropFile.class.getClassLoader()
				.getResource("logging.properties")
				.getFile();
			
				System.setProperty("java.util.logging.config.file", file);
				
			
				try {
					FileHandler handler = new FileHandler("logs2.log");
					Book.log.addHandler(handler);
					Book.log.info("Logging Properties Done Right");
					Book java = new Book();
					Book.log.info(java.toString());
					
					
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
	}

}
