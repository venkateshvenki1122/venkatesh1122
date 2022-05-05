package com.example;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LogToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Logger log = Logger.getLogger(LogToFile.class.getName());
		
		FileHandler handler;
		try {
			handler = new FileHandler("logs.log");
			log.addHandler(handler);
			log.info("Try Block Called");
			throw new Exception("Hii");
		} catch (SecurityException e) {
			
			log.warning(e.getMessage());
			//e.printStackTrace();
		} catch (IOException e) {
			
			log.warning(e.getMessage());
		//	e.printStackTrace();
		}catch(Exception e) {
			
			log.warning(e.getMessage());
		}
		
		
		
	}

}
