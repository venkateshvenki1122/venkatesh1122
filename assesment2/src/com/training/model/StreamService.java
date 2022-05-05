package com.training.model;
import java.util.stream.Collectors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.training.UsingStreams;

public class StreamService {

	private Connection con;

	public StreamService(Connection con) {
		super();
		this.con = con;
	}
	
	List<UsingStreams> list = new ArrayList<UsingStreams>();
	
	public List<UsingStreams> findAll(){
		
		List<UsingStreams> list = new ArrayList<UsingStreams>();
		
		String sql = "select * from venki_streams";
		
		try(PreparedStatement pds = con.prepareStatement(sql)){
			
			ResultSet result = pds.executeQuery();
			while(result.next()) {
				String country = result.getString("country");
				String place = result.getString("place");
				long population = result.getLong("population");
				
				
				UsingStreams stream = new UsingStreams(country, place, population);
				
				list.add(stream);
			}	
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<String> findPlaceByCountry(String country,List<UsingStreams> list){
		
		List<String> lists = new ArrayList<>();
		 List<UsingStreams>stream =findAll();
		
		lists=stream.stream().filter(e->e.getCountry().equalsIgnoreCase(country)).
				map(e->e.getPlace()).collect(Collectors.toList());
		
		return lists;
	}
	
	public List<Long> findPopulation(String country,List<UsingStreams> lists) {
		
		List<Long> pop= lists.stream().filter(e->e.getCountry().equalsIgnoreCase(country))
						.map(e->e.getPopulation()).collect(Collectors.toList());
		
		//System.out.println(pop);
		long sum = 0;
		for (Long long1 : pop) {
			
			sum=sum+long1;
		}
		System.out.println(sum);
	
		return pop;
	}
	
	public void findCity(String city ,List<UsingStreams> lists) {
	
		long cou=lists.stream().filter(e->e.getCountry().equalsIgnoreCase(city))
			.count();
	
	System.out.println(cou);
	}
	
	
	
	
}
