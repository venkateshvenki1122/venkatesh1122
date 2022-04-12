package com.training.model;

import com.training.exception.RangeCheckException;

public class Student {

	private int rollNumber;
	private String name;
	private double markScored;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int rollNumber, String name, double markScored)throws RangeCheckException {
		super();
		if(markScored<0) {
			throw new RangeCheckException("Mark should be positive integer [0-100]");
		}else {
		this.rollNumber = rollNumber;
		this.name = name;
		this.markScored = markScored;
	}
	}
	
	public int getRollNumber() {
		return rollNumber;
	}
	
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getMarkScored() {
		return markScored;
	}
	
	public void setMarkScored(double markScored) {
		
		if(markScored<0) {
			
			try {
				throw new RangeCheckException("Mark should be positive integer[0-100]");
			} catch (RangeCheckException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else {
			this.markScored = markScored;
		}
		
		this.markScored = markScored;
	}
	
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", markScored=" + markScored + "]";
	}

	
	
}
