package com.aurionpro.model;

public class User {
	private int userId;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private double balance;

	public User(int userId, String fname, String lname, String username, String password,double balance) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(int userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	
	public User(int userId, String username, String password, double balance) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.balance = balance;

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", username=" + username
				+ ", password=" + password + ", balance=" + balance + "]";
	}

}
