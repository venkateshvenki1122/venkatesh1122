package com.training;

import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Finishings;

import com.training.model.StreamService;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con;
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@10.90.1.105:1521/DEV","HR","HR");
			
			System.out.println(con);
			UsingStreams stream = new UsingStreams();
			
			StreamService service = new StreamService(con);
			service.findAll().forEach(System.out::println);
			List<UsingStreams> list1 =service.findAll();
			System.out.println(service.findPlaceByCountry("india", list1));
			
			service.findCity("india", list1);
			System.out.println("**************");
			System.out.println(service.findPopulation("india", list1));
			System.out.println("*********************");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
		}
		
		
		
	}

}
