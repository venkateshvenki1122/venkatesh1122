package com.training.demo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.training.Doctor;
import com.training.Patient;

public class Appointment {
	//Set<Patient> patients = new HashSet<>();
	
	private Map<Doctor,Set<Patient>> map;

	public Appointment(Map<Doctor, Set<Patient>> map) {
		super();
		this.map = map;
	}

	public Map<Doctor, Set<Patient>> getMap() {
		return map;
	}

	public void setMap(Map<Doctor, Set<Patient>> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Appointment [map=" + map + "]";
	}

	public Set<Patient> getPatients(Doctor key){
		
		return this.map.get(key);
	}
	
}
