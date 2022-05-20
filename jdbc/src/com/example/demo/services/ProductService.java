package com.example.demo.services;

import java.sql.*;
import java.util.*;
import com.example.entity.*;

public class ProductService {

	private Connection con;
	
	public ProductService(Connection con) {
		super();
		this.con = con;
	}
	
public int updateTable(String product_name ,int id) {
	int rowsUpdated = 0;
	String sql ="update venki_product1 set product_name='?' where product_id=?";
	try(PreparedStatement pds = con.prepareStatement(sql)){
		pds.setString(1,product_name);
		pds.setInt(2, id);
		
		rowsUpdated = pds.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return rowsUpdated;
}

	
public int deleteById(int id) {

	int rowsDeleted=0;
	String sql = "delete from venki_product1 where product_id=?";
	try(PreparedStatement pds = con.prepareStatement(sql)){
		
		pds.setInt(1, id);
		rowsDeleted =pds.executeUpdate();
		
	}catch(SQLException e) {
		
		e.printStackTrace();
	}
	
	return rowsDeleted;
}
	
public Optional<Product> findById(int id){
	
	  Optional<Product> obj = Optional.empty();
	//List<Product> productList = new ArrayList<Product>();
	String sql="select * from venki_product1 where product_id=? ";
	try(PreparedStatement pds = con.prepareStatement(sql)){
		pds.setInt(1,id);
		ResultSet result = pds.executeQuery();
		
		if(result.next()) {
			int productId = result.getInt("product_id");
			String productName = result.getString("product_name");
			double price = result.getDouble("price");
			
			Product prod = new Product(productId,productName,price);
			
			obj=Optional.of(prod);
		}
		
	}catch(SQLException e) {
		
		e.printStackTrace();
	}
	
	return obj;
}
	
public int addProduct(Product product) {
	
	int rowAdded=0;
	String sql = "insert into venki_product1 values (?,?,?)";
	try(PreparedStatement pds = con.prepareStatement(sql)){
		
		pds.setInt(1, product.getProductId());
		pds.setString(2, product.getProductName());
		pds.setDouble(3, product.getPrice());
		
		rowAdded= pds.executeUpdate();
		
	}catch(SQLException e) {
		 
		e.printStackTrace();
	}
	return rowAdded;
	
}
	
	
	
public List<Product> findAll(){
	
	List<Product> productList = new ArrayList<Product>();
	
	String sql = "select * from venki_product1";
	
	try(PreparedStatement pds = con.prepareStatement(sql)){
		
		ResultSet result = pds.executeQuery();
		while(result.next()) {
			int productId = result.getInt("product_id");
			String productName = result.getString("product_name");
			double price = result.getDouble("price");
			
			
			Product prod = new Product(productId, productName, price);
			
			productList.add(prod);
		}
		
		
		
	}catch(SQLException e) {
		
		e.printStackTrace();
	}
	
	
	return productList;
}
	
	
	
	
}
