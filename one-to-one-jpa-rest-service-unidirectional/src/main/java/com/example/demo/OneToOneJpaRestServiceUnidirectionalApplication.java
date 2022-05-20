package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

//import com.example.demo.entity.Driver;
import com.example.demo.entity.Passenger;
import com.example.demo.entity.TripHistory;
//import com.example.demo.ifaces.DriverRepository;
import com.example.demo.ifaces.PassengerRepository;
import com.example.demo.service.PassengerService;

@SpringBootApplication
public class OneToOneJpaRestServiceUnidirectionalApplication {

	public static void main(String[] args) {
	
	SpringApplication.run(OneToOneJpaRestServiceUnidirectionalApplication.class, args);
	
		
		//service.create();
	
	
	}

	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			PassengerRepository repo;
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				Passenger passenger = new Passenger();
				
				passenger.setPassengerId(102);
				passenger.setPassengerName("Thamo");
				passenger.setEmail("guru87@gmail.com");
				passenger.setLocation("VNR");
				
			TripHistory trip = new TripHistory(206, LocalDateTime.of(2022, 11, 22, 10, 50), "Madurai", "Banglore", 800.0);
			TripHistory trip1 = new TripHistory(207, LocalDateTime.of(2022, 10, 11, 12, 55), "Banglore", "Chennai", 900.0);
			
			List<TripHistory> list = Arrays.asList(trip,trip1);
			passenger.setTripHistoryList(list);
			repo.save(passenger);
			
			}
		};
	}

	
}
