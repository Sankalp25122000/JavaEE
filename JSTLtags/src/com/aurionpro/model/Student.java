package com.aurionpro.model;

public class Student {
	private String name;
	private int rollNo;
	private String email;
	private boolean scholarship;

	public Student(String name, int rollNo, String email, boolean scholarship) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.email = email;
		this.scholarship = scholarship;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isScholarship() {
		return scholarship;
	}

	public void setScholarship(boolean scholarship) {
		this.scholarship = scholarship;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", email=" + email + ", scholarship=" + scholarship
				+ "]";
	}

}
