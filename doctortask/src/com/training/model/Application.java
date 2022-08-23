package com.training.model;
import java.util.*;

import com.training.Doctor;
import com.training.Patient;
import com.training.demo.Appointment;
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Patient patient1 = new Patient(100, "Thamo", "Maduari", 6374969825L);
		Patient patient2 = new Patient(101, "Prawin", "Chennai", 7894683990L);
		Patient patient3 = new Patient(102, "Kawin", "Vnr", 7894683990L);
		
		Set<Patient> patients = new HashSet<>();
		
		patients.add(patient1);
		patients.add(patient2);
		patients.add(patient3);
		
		Doctor doctor1 = new Doctor(420, "Kawin", "Eye Specialist",patients);
		Doctor doctor2 = new Doctor(420, "Kawin", "Eye Specialist",patients);
		Set<Patient> lists   =doctor1.getPatientList();
		for (Patient patient : lists) {
			
			System.out.println(patient);
		}
		System.out.println("***************************************************");
		Map<Doctor, Set<Patient>> map = new HashMap<Doctor, Set<Patient>>();
		map.put(doctor1, patients);
		//map.put(doctor2, patient2);
		Appointment appoint = new Appointment(map);
	
		Map<Doctor, Set<Patient>> map1 = appoint.getMap();
		 
		System.out.println(map1.get(doctor1));
		
	}

}
