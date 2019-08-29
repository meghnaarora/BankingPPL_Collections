package com.capgemini.bean;

public class Transaction {
	long transactionId;
	String transactionType;
	String transactionDate;
	long accountNo;
	double amount;
	public Transaction() {
		super();
	}
	public Transaction(long transactionId, String transactionType, String transactionDate, long accountNo, double amount) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.accountNo = accountNo;
		this.amount = amount;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "\ntransactionId=" + transactionId + "\ttransactionType=" + transactionType
				+ "\ttransactionDate=" + transactionDate + "\taccountNo=" + accountNo + "\tamount=" + amount ;
	}

	
}
