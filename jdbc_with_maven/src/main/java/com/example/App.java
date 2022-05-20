package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.dao.MemberRepository;
import com.example.demo.services.ProductService;
import com.example.entity.Member;
import com.example.entity.Product;
import com.example.util.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void member() {
		
		   
     Connection con = ConnectionFactory.getOracleConnection();
//		
  	//Connection con = ConnectionFactory.getPostgressConnection();
		
		
     MemberRepository member = new MemberRepository(con);
     System.out.println("___________________________________________");
     System.out.println(con);
     System.out.println("____________________________________________");
//     member.findAll().forEach(System.out::println);
//    System.out.println("Removed Items"+ member.remove(6));
//    
    //Member meme = new Member();
//    
  // System.out.println("Updated :"+ member.update(4, meme));
//      
    // System.out.println(member.findById(4));
      

		
		
	}
	
	public static void product() {
		
		Connection con = ConnectionFactory.getPostgressConnection();
		ProductService service = new ProductService(con);
		
		Product toAdd = new Product(9,"UPS",17470.00);
		int rowAdded = service.addProduct(toAdd);
		System.out.println(rowAdded);
//	       MemberRepository member = new MemberRepository(con);
//	       System.out.println("___________________________________________");
//	       System.out.println(con);
//	       System.out.println("____________________________________________");
//	       
		
	}
	
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        
  Connection con = ConnectionFactory.getOracleConnection();
////		
    	//Connection con = ConnectionFactory.getPostgressConnection();
//		
//		
//       MemberRepository member = new MemberRepository(con);
//       System.out.println("___________________________________________");
//       System.out.println(con);
//       System.out.println("____________________________________________");
//       member.findAll().forEach(System.out::println);
//      System.out.println("Removed Items"+ member.remove(6));
//      
      //Member meme = new Member();
//      
    // System.out.println("Updated :"+ member.update(4, meme));
//        
      // System.out.println(member.findById(4));
    	ProductService service = new ProductService(con);
    	Product prd1 = new Product(700, "halwa", 100);
    	//Product prd2 = new Product(233, "jilebi",150);
    	//service.usingTxn(prd1, prd2);
    	Invoice inv = new Invoice(40, "Arun", 8, 104);
        service.usingTnxWithCatchBlock(prd1, inv);
    	
       // product();
    }
}
