package com.example.demo;

import java.sql.*;
import java.util.Optional;

import com.example.demo.services.ProductService;
import com.example.entity.Product;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Connection con = 
			DriverManager.getConnection("jdbc:oracle:thin:@10.90.1.105:1521/DEV","HR","HR");
			
			ProductService service = new ProductService(con);
			service.findAll().forEach(System.out::println);
			
//			Product toAdd = new Product(211, "UPS", 5023.00);
//			int rowAdded = service.addProduct(toAdd);
//			System.out.println("Row Added :"+ rowAdded);
//			int rowAdded1 = service.deleteById(101);
//			System.out.println("Deleted Row :"+rowAdded1);
			System.out.println("*************************");
			 //System.out.println(service.findById(100));
			 System.out.println("************************");
			 
			 Optional<Product> pro = service.findById(108);
			 
			 if(pro.isPresent()) {
				 
				 System.out.println(pro.get());
			 }else {
				 
				 System.out.println("Product with given ID is not present");
			 }
			 
			 System.out.println("+++++++++++++++++++++++++++");
			
			 System.out.println("Updated Rows"+service.updateTable("car", 101));
			 
			 System.out.println("++++++++++++++++++++++++++++");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
