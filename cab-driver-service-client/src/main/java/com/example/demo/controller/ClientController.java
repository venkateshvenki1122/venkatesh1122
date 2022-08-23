package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.CabDriverServiceClientApplication;
import com.example.demo.entity.CabDriver;
import com.example.demo.entity.TripDetail;
import com.example.demo.trip.dto.TripDto;

@RestController
@RequestMapping(path="/client")
public class ClientController {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private TripDto dto;
//	
//	@GetMapping(path="/drivers")
//	public String getDrivers() {
//		
//		return this.template.getForObject("http://CAB-DRIVER-SERVICE/api/v1/drivers", String.class);
//	}
	
	@GetMapping(path="/drivers/json")
	public CabDriver[] getDriversAsJson() {
		
		return this.template.getForObject("http://CAB-DRIVER-SERVICE/api/v1/drivers", CabDriver[].class);
	}
	
	@GetMapping(path="/srch/{name}")
	public String getDriverByName(@PathVariable("name") String name) {
		
		return this.template.getForObject("http://CAB-DRIVER-SERVICE/api/v1/drivers/srch/"+name, String.class);
	}
	
	@GetMapping(path="/trips")
	public String getTrips() {
		
		return this.template.getForObject("http://TRIP-DETAIL-SERVICE/api/v1/trips", String.class);
	}
	
	@GetMapping(path="/trips/{id}")
	public String getDriverTrips(@PathVariable("id") int id) {
		
	String driver= this.template.getForObject("http://CAB-DRIVER-SERVICE/api/v1/drivers/"+id,String.class);
	
	String trips= this.template.getForObject("http://TRIP-DETAIL-SERVICE/api/v1/trips/driver/"+id,String.class);
	
	return driver+trips;
	}
	
	@GetMapping(path="/trips/json/{id}")
	public TripDto getTripsAsJson(@PathVariable("id") int id) {
		
	CabDriver driver= this.template.getForObject("http://CAB-DRIVER-SERVICE/api/v1/drivers/"+id, CabDriver.class);
	TripDetail[] trips= this.template.getForObject("http://TRIP-DETAIL-SERVICE/api/v1/trips/driver/"+id,TripDetail[].class);
	
	dto.setDriver(driver);
	//List<TripDetail> detail = Arrays.asList(trips);
	Set<TripDetail> detail = Arrays.stream(trips).collect(Collectors.toSet());
	
	dto.setTrips(detail);
	
	return dto;
	
	}
}
