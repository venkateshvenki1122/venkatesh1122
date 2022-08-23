package com.training;

import java.util.HashSet;
import java.util.Set;

public class Doctor {

	private int doctorId;
	private String doctorName;
	private String departments;
		
	private 	Set<Patient> patientList;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int doctorId, String doctorName, String departments, Set<Patient> patientList) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.departments = departments;
		this.patientList = patientList;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDepartments() {
		return departments;
	}

	public void setDepartments(String departments) {
		this.departments = departments;
	}

	public Set<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(Set<Patient> patientList) {
		this.patientList = patientList;
	}

	
	
	
	
	
}
