package com.training.resources;
//import com.training.resources;
import java.sql.*;
import java.util.*;

//import org.glassfish.jersey.client.HttpUrlConnectorProvider.ConnectionFactory;


import com.example.entity.*;
import com.example.util.ConnectionFactory;

public class ProductService {

	private Connection con;
	
	public ProductService( ) {
		super();
		this.con = ConnectionFactory.getOracleConnection();
	}
	
public int updateTable(String product_name ,int id) {
	int rowsUpdated = 0;
	String sql ="update venki_product1 set product_name=? where product_id=?";
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
	
	public void usingTxn(Product prd1,Product prd2) {
		
		String sql="insert into venki_product1 values(?,?,?)";
		try(PreparedStatement pds = con.prepareStatement(sql)){
			
			con.setAutoCommit(false);
			
		pds.setInt(1, prd1.getProductId());	
		pds.setString(2, prd1.getProductName());
		pds.setDouble(3, prd1.getPrice());
			
		int rowAdded = pds.executeUpdate();
		
		pds.setInt(1, prd2.getProductId());
		pds.setString(2, prd2.getProductName());
		pds.setDouble(3, prd2.getPrice());
		
		int rowsAdded = pds.executeUpdate();
		
		if(prd2.getPrice()>prd1.getPrice()) {
			con.commit();
		}else {
			con.rollback();
		}
		
		System.out.println("Row Added :"+rowAdded);
		
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}	
	}
	
//	public void usingTnxWithCatchBlock(Product prd1,Invoice inv) {
//		
//		String sql="insert into venki_product1 values(?,?,?)";
//		String invoSql="insert into venki_invoice values(?,?,?,?)";
//		try(PreparedStatement pds = con.prepareStatement(sql);
//				PreparedStatement invPds = con.prepareStatement(invoSql)){
//			
//			con.setAutoCommit(false);
//			
//		pds.setInt(1, prd1.getProductId());	
//		pds.setString(2, prd1.getProductName());
//		pds.setDouble(3, prd1.getPrice());
//			
//		 pds.executeUpdate();
//		
//		invPds.setInt(1, inv.getInvoiceNumber());
//		invPds.setString(2, inv.getCustomerNAme());
//		invPds.setInt(3, inv.getQuantity());
//		invPds.setInt(4, inv.getProductRef());
//		
//		int productAddCount =invPds.executeUpdate();
//		
//		con.commit();
//		
//		//pds.setInt(1, prd2.getProductId());
//		//pds.setString(2, prd2.getProductName());
//		//pds.setDouble(3, prd2.getPrice());
//		
//		//int rowsAdded = pds.executeUpdate();
//		
////		if(prd2.getPrice()>prd1.getPrice()) {
////			con.commit();
////		}else {
////			con.rollback();
////		}
//		
//		//System.out.println("Row Added :"+rowAdded);
//		
//			
//		}catch(SQLException e) {
//			
//			e.printStackTrace();
//			try {
//				con.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}	
//	}
//	
	
}
