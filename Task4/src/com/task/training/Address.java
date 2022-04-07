package com.task.training;

public class Address {

	private int doorNumber;
	private String streetName;
	private String district;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int doorNumber, String streetName, String district) {
		super();
		this.doorNumber = doorNumber;
		this.streetName = streetName;
		this.district = district;
	}
	public int getDoorNumber() {
		return doorNumber;
	}
	
	public void setDoorNumber(int doorNumber) {
		this.doorNumber = doorNumber;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
	
	
	
}
