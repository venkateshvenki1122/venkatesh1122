package com.example;

import java.util.*;
//import java.util.Date;
import java.sql.*;
import java.sql.Date;
import java.time.*;



public class WorkingWithDifferentDateClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Step-1  Creating UTIL Date
		java.util.Date date1 = new java.util.Date();
	//	java.sql.Date date2 = new java.sql.Date(10203);
		
		System.out.println(date1);
		
		// Step-2 UTIL Date to SQL Date
		java.sql.Date date2 = new java.sql.Date(date1.getTime());
		
		System.out.println(date2);
		
		//Step-3 SQL Date to LocalDate
		LocalDate localDate = date2.toLocalDate();
		System.out.println(localDate);
		
		//Step-4 Local Date to SQL Date
		
		java.sql.Date sqlDate = new java.sql.Date(localDate.toEpochDay());
		System.out.println("SQL Date 2 : "+sqlDate);
		
		java.sql.Date sqlDate1 = java.sql.Date.valueOf(localDate);
		System.out.println("SQL Date  : "+sqlDate1);
		
	}

}
