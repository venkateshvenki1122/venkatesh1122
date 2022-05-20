package com.example.demo.utils.bidirectional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.ifaces.DoctorRepository;

@Component
public class DoctorUtils {

	@Autowired
	List<Patient> patientList;
	
	@Autowired
	Doctor doc;
	
	@Autowired
	 private DoctorRepository repo;
	
	
	public void create() {
		
		doc.setPatientList(patientList);
		
		Doctor added = repo.save(doc);
		if(added!=null) {
			
			System.out.println("One row added");
		}
	}
	
	public void findAll() {
		
		List<Doctor> doctors = repo.findAll();
		for (Doctor doctor : doctors) {
			
		System.out.println(doctor);
		}
			
	}
	
	
}
