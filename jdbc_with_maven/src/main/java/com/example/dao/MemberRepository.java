package com.example.dao;


import java.util.ArrayList;
import java.util.List;

import com.example.entity.Member;

import com.example.ifaces.CrudRepository;
import java.sql.*;
import java.time.LocalDate;
public class MemberRepository implements CrudRepository<Member> {

	private Connection con;
	
	public MemberRepository(Connection con) {
		super();
		this.con = con;
	}

	public int add(Member obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Member> findAll() {
		// TODO Auto-generated method stub
		
		List<Member> memberList = new ArrayList<Member>();
		
		String sql = "select * from venkimember";
		
		try(PreparedStatement pds = con.prepareStatement(sql)){
			
			ResultSet result = pds.executeQuery();
			while(result.next()) {
				int memberId = result.getInt("MEMBER_ID");
			String memberName = result.getString("MEMBER_NAME");
			String memberAddress=result.getString("MEMBER_ADDRESS");
			LocalDate accountOpenDate=(result.getDate("ACC_OPEN_DATE")).toLocalDate();
			String membershipType = result.getString("MEMBERSHIP_TYPE");
			double feesPaid = result.getDouble("FEES_PAID");
			int maxBookAllowed = result.getInt("MAX_BOOKS_TYPE");
			double penaltyAmount = result.getDouble("PENALTY_AMOUNT");
				
				Member prod = new Member(memberId, memberName,memberAddress,
						accountOpenDate,membershipType,feesPaid,
						maxBookAllowed,penaltyAmount);
				
				memberList.add(prod);
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return memberList;
		
	}

	public int remove(int id) {
		// TODO Auto-generated method stub
		int removed = 0;
		String sql = "delete from venkimember where MEMBER_ID =?";
		try(PreparedStatement pds = con.prepareStatement(sql)){
			
			pds.setInt(1,id);
			removed = pds.executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return removed;
	}

	public Member findById(int id) {
		// TODO Auto-generated method stub
		Member mem=null;
		String sql="select * from venkimember where MEMBER_ID=? ";
		try(PreparedStatement pds = con.prepareStatement(sql)){
			pds.setInt(1,id);
			ResultSet result = pds.executeQuery();
			
	if(result.next()) {
		int memberId = result.getInt("MEMBER_ID");
	
	String memberName = result.getString("MEMBER_NAME");
	String memberAddress=result.getString("MEMBER_ADDRESS");
	LocalDate accountOpenDate=(result.getDate("ACC_OPEN_DATE")).toLocalDate();
	String membershipType = result.getString("MEMBERSHIP_TYPE");
	double feesPaid = result.getDouble("FEES_PAID");
	int maxBookAllowed = result.getInt("MAX_BOOKS_TYPE");
	double penaltyAmount = result.getDouble("PENALTY_AMOUNT");
			
				
	 mem = new Member(memberId, memberName,memberAddress,
			accountOpenDate,membershipType,feesPaid,
			maxBookAllowed,penaltyAmount);
	}
		
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return mem;
	}

	public int update(int id, Member member) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		String sql ="update venkimember set MEMBER_ID=? where MEMBER_NAME=?";
		try(PreparedStatement pds = con.prepareStatement(sql)){
			pds.setInt(1,id);
			String ven= member.getMemberName();
			pds.setString(2,ven);
			
			rowsUpdated = pds.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rowsUpdated;
		
	}

}
