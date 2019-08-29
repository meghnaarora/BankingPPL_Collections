package com.capgemini.bean;

public class Account {

	private long accountNo;
	private String firstName;
	private String LastName;
	private long mobileNo;
	private String gender;
	private double balance;

	public Account() {
		super();

	}

	public Account(long accountNo, String firstName, String lastName, long mobileNo, String gender, double balance) {
		super();
		this.balance = balance;
		this.accountNo = accountNo;
		this.firstName = firstName;
		LastName = lastName;
		this.mobileNo = mobileNo;
		this.gender = gender;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public double getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "\n" + "accountNo=" + accountNo + "\tbalance=" + balance + "\tfirstName=" + firstName + "\tLastName="
				+ LastName + "\tmobileNo=" + mobileNo + "\tgender=" + gender;
	}

}
