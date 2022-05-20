package com.example.oracle.loan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.entity.Customer;
import com.example.entity.LoanApplication;
import com.example.method.CustomerService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.90.1.105:1521/DEV","HR","HR");
			System.out.println(con);
			CustomerService service = new CustomerService(con);
			 //int removed = service.remove(2004);
			//System.out.println("Removed :"+ removed);
			//LoanApplication loan = new LoanApplication(applicationNumber, customer, loanAmount)
		//service.findAll().forEach(System.out::println);
			//System.out.println(service.findById(1001));
			Customer cust = new Customer(1010, "varun", 9378487409L,680.0);
			LoanApplication loan = new LoanApplication(8, cust, 5289.0);
			
			//int addRow=service.add(loan);
			//System.out.println("Added :"+addRow);
			
			System.out.println("Added"+service.add(loan));
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    	
    }
}
