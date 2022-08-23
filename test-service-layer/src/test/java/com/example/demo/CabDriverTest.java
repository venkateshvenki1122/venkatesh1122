package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.hasSize;

import com.example.demo.entity.CabDriver;
import com.example.demo.services.CabDriverService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
public class CabDriverTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	CabDriverService service;
	
	private CabDriver thamo;
	private CabDriver guru;
	private CabDriver vijay;
	
	
	@BeforeAll
	void init() {
		
		 thamo = new CabDriver(2001, "Thamo", 987856, "Pondicherry", LocalDate.of(2001, 07, 8), 4.0);
		 guru = new CabDriver(2002, "Guru", 9878534, "Chittoor", LocalDate.of(2004, 07, 9), 4.5);
		 vijay = new CabDriver(2003, "Vijay", 9878126, "VNR", LocalDate.of(2001, 07, 8), 4.0);	
	
	}
	
	
	@DisplayName(value = "Test FindAll Method return a array")
	@Test
	void testFindAll()  throws Exception{
	
		//List<CabDriver> list = Arrays.asList(thamo,guru,vijay);
		List<CabDriver> list = new ArrayList<CabDriver>();
		
		list.add(thamo);
		list.add(guru);
		list.add(vijay);
		
		given(service.findAll()).willReturn(list);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/drivers")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk()).andExpect(jsonPath("$",hasSize(3)))
			.andExpect(jsonPath("$[1].driverName", is("Guru")));
		
	}
	
	@DisplayName(value = "Test Add Method return status code 201 and "
			+ "returns the element Added")
	@Test
	void testAdd() throws Exception {
		
		CabDriver parth = new CabDriver(2006,"Sathish",876543,"Sivakasi",LocalDate.of(2005,10,12),4.0);
	
		given(service.save(parth)).willReturn(parth);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/drivers/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(parth)))
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.driverName",is("Sathish")));

	}
	
	

	public  String asJsonString(CabDriver obj) {
	try {

	//ObjectMapper objectMapper = new ObjectMapper();
	return mapper.writeValueAsString(obj);

	}
	catch(Exception e) {
	throw new RuntimeException(e);
	}
	}
	
	@Test
	@DisplayName("Test getid method ")
	void testFindById()
	{
	
		Optional<CabDriver> element=Optional.of(thamo);
	
		given(service.findById(2001)).willReturn(element);
	
		try {
	
			mockMvc.perform(MockMvcRequestBuilders
			.get("/api/v1/drivers/2001"))
			.andExpect(jsonPath("$.driverName", is("Thamo")));
	
	} catch (Exception e) {

	e.printStackTrace();
	}
	}
	
	@DisplayName(value = "Test DeleteById Method")
	@Test
	void testDeleteById() {
		
		Optional<CabDriver> element=Optional.of(guru);
		
		given(service.remove(2009)).willReturn(element);
		
		try {
			
			mockMvc.perform(MockMvcRequestBuilders
			.delete("/api/v1/drivers/remove/2002")
			.contentType(MediaType.APPLICATION_JSON))
			
			.andExpect(jsonPath("$.driverName", is("Guru")));
	
	} catch (Exception e) {

	e.printStackTrace();
	}
		
	}
}
