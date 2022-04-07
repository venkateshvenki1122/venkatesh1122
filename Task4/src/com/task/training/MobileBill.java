package com.task.training;

public class MobileBill {

	private String customerName;
	private long mobileNumber;
	private String planName;
	private Address address;
	
	public static final  String SERVICEPROVIDER="Airtel";
	
	public MobileBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MobileBill(String customerName, long mobileNumber, String planName, Address address) {
		super();
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.planName = planName;
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public double findAmount() {
		
		double amount=0;
		String plan = getPlanName();
		switch (plan) {
		case "postpaid":
			amount=300;
			break;
		case "prepaid" :
			amount=200;
			break;
		default:
			System.out.println("Enter the valid plan");
			break;
		}
		return amount;
		
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return address.getDoorNumber()+","+address.getStreetName()+","+address.getDistrict();
	}
	
}
