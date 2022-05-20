package com.example.method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.entity.Customer;
import com.example.entity.LoanApplication;
//import com.example.entity.Member;
import com.example.ifaces.CrudRepository;

public class CustomerService implements CrudRepository<LoanApplication > {

	private Connection con;
	
	public CustomerService(Connection con) {
		super();
		this.con = con;
	}

	

	public List<LoanApplication> findAll() {
		// TODO Auto-generated method stub
		
List<Customer> memberList = new ArrayList<Customer>();
		
		//String sql = "select * from venkimember";
		List<LoanApplication> loanList=new ArrayList<LoanApplication>();
		String sql="select * from venki_loan_application l left outer join venki_customer c on l.customer_ref=c.customer_id";
		
		try(PreparedStatement pstmt=con.prepareStatement(sql)){
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				
				int applicationNumber=rs.getInt("application_number");
				double loanAmount=rs.getDouble("loan_amount");
				
				int customerId=rs.getInt("customer_Id");
				String customerName = rs.getString("customer_name");
				long phoneNumber =rs.getLong("phone_number");
				double creditScore = rs.getDouble("credit_score");
			Customer customer=new Customer(customerId, customerName, phoneNumber, creditScore);
				LoanApplication prod=new LoanApplication(applicationNumber, customer,loanAmount);
				loanList.add(prod);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return loanList;
		
	}

	public int remove(int id) {
		// TODO Auto-generated method stub
		
		int removed = 0;
		String sql = "delete from venki_loan_application where application_number=?";
		try(PreparedStatement pds = con.prepareStatement(sql)){
			
			pds.setInt(1,id);
			removed = pds.executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return removed;
	}

	

	@Override
	public int add(LoanApplication obj) {
		// TODO Auto-generated method stub
		int addRow =0;
		String sql ="insert into venki_loan_application values (?,?,?)";
		String sql1 = "insert into venki_customer values (?,?,?,?)";
		Customer customer = obj.getCustomer();
		try(PreparedStatement pds = con.prepareStatement(sql1);
				PreparedStatement pds1= con.prepareStatement(sql)){
			
			pds.setInt(1,customer.getCustomerId());
			pds.setString(2,customer.getCustomerName());
			pds.setLong(3, customer.getPhoneNumber());
			pds.setDouble(4, customer.getCreditScore());
			
			addRow = pds.executeUpdate();
			
			pds1.setInt(1,obj.getApplicationNumber());
			pds1.setDouble(2,obj.getLoanAmount());
			pds1.setInt(3,obj.getCustomer().getCustomerId());
			
			addRow =+pds1.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return addRow;
	}

	@Override
	public LoanApplication findById(int id) {
		// TODO Auto-generated method stub
		LoanApplication prod = null;
		String sql = "select * from venki_loan_application l left outer join venki_customer c on l.customer_ref=c.customer_id where customer_id=?";
	//	List<LoanApplication> loanList = new ArrayList<>();
		try(PreparedStatement pds = con.prepareStatement(sql)){
			
		pds.setInt(1, id);
		ResultSet result = pds.executeQuery();
			
		if(result.next()) {
				
		int applicationNumber=result.getInt("application_number");
		double loanAmount=result.getDouble("loan_amount");
				
		int customerId=result.getInt("customer_Id");
		String customerName = result.getString("customer_name");
		long phoneNumber =result.getLong("phone_number");
		double creditScore = result.getDouble("credit_score");
		Customer customer=new Customer(customerId, customerName, phoneNumber, creditScore);
		prod=new LoanApplication(applicationNumber, customer,loanAmount);
				
				
			}	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return prod;
	}

	@Override
	public int update(int id, LoanApplication customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	
}
