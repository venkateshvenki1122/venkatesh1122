package com.example.demo.entity;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)


public class TripDetail {

	int tripID;
	
	int driverId;
	
	@DateTimeFormat(iso=ISO.DATE)
	LocalDate tripDate;
	
	double amount;	
	
}
