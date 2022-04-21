package com.training.model;

public class LifeInsurance  extends Insurance{

	private int age;
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LifeInsurance(int policyNumber, String policyHolderName, int age) {
		super(policyNumber, policyHolderName);
		this.age = age;
	}

	public LifeInsurance(int age) {
		super();
		this.age = age;
	}

	//public LifeInsurance() {
		//super();
		// TODO Auto-generated constructor stub
	//}

	
	@Override
	public double calculatePremium() {
	 double premium = 5000;
	 
		if(age < 20) {
			
			premium = 2000;
		}
	 return premium;
 }
	
	
	
}
