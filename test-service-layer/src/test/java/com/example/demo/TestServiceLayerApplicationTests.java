package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.CabDriver;
import com.example.demo.services.CabDriverService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class TestServiceLayerApplicationTests {
	
	
	@Autowired
	CabDriverService service;
	
	@BeforeAll
	void setUp() {
		
		CabDriver driver = new CabDriver(2001, "Thamo", 987856, "Pondicherry", LocalDate.of(2001, 07, 8), 4.0);
	
		service.save(driver);
	}
	

	@Test
	@DisplayName("Find All Method should return a empty Array")
	void testFindAll() {
		
		assertTrue(service.findAll().isEmpty());
	}

	
	@Test
	@DisplayName("Find All Method should return an Array with Element")
	void testFindAllSuccess() {
		
		assertFalse(service.findAll().isEmpty());
	}
	
	@Test
	@DisplayName(value = "FindById Method should return an element with the given id")
	void testFindById() {
		
		//assertEquals("Thamo", service.findById(2001).get().getDriverName());
		CabDriver driver = service.findById(2000).orElseThrow(EntityNotFoundException::new);
		
		assertEquals("Thamo", driver.getDriverName());
		
	}
}
