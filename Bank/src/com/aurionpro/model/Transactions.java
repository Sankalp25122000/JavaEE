package com.aurionpro.model;


public class Transactions {

	private int transactionId;
	private int accountNumber;
	private String transactionType;
	private String dateTime;
	private int amount;

	public Transactions(int transactionId, int accountNumber, String transactionType, String dateTime,
			int amount) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.transactionType = transactionType;
		this.dateTime = dateTime;
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", accountNumber=" + accountNumber
				+ ", transactionType=" + transactionType + ", dateTime=" + dateTime + ", amount=" + amount + "]";
	}

}
