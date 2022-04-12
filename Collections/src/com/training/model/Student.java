package com.training.model;

public class Student implements Comparable<Student>{

	private int rollNumber;
	private String firstNAme;
	private double markScored;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int rollNumber, String firstNAme, double markScored) {
		super();
		this.rollNumber = rollNumber;
		this.firstNAme = firstNAme;
		this.markScored = markScored;
	}
	
	public int getRollNumber() {
		return rollNumber;
	}
	
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public String getFirstNAme() {
		return firstNAme;
	}
	
	public void setFirstNAme(String firstNAme) {
		this.firstNAme = firstNAme;
	}
	
	public double getMarkScored() {
		return markScored;
	}
	
	public void setMarkScored(double markScored) {
		this.markScored = markScored;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", firstNAme=" + firstNAme + ", markScored=" + markScored + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstNAme == null) ? 0 : firstNAme.hashCode());
		long temp;
		temp = Double.doubleToLongBits(markScored);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + rollNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (firstNAme == null) {
			if (other.firstNAme != null)
				return false;
		} else if (!firstNAme.equals(other.firstNAme))
			return false;
		if (Double.doubleToLongBits(markScored) != Double.doubleToLongBits(other.markScored))
			return false;
		if (rollNumber != other.rollNumber)
			return false;
		return true;
	}

	@Override
	public int compareTo(Student otherObj) {
		// TODO Auto-generated method stub
		return this.firstNAme.compareTo(otherObj.firstNAme);
	}
	
	
	
	
	
	
}
