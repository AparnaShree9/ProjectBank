package com.capg.bank.beans;

public class BankAccount {
	private String customer_name;
	private String customer_id;
	private int age;
	private String customer_mobileNumber;
	private double account_balance;
	private StringBuffer customer_address;
	private int account_Number;
	private int pin_Number;
	private StringBuffer Transaction;
	public BankAccount(){}

	public BankAccount(String customer_name, String customer_id, int age,
			String customer_mobileNumber, double account_balance,
			StringBuffer customer_address) {
		super();
		this.customer_name = customer_name;
		this.customer_id = customer_id;
		this.age = age;
		this.customer_mobileNumber = customer_mobileNumber;
		this.account_balance = account_balance;
		this.customer_address = customer_address;
	}

	
	
	public StringBuffer getTransaction() {
		return Transaction;
	}

	public void setTransaction(StringBuffer transaction) {
		Transaction = transaction;
	}

	public String getCustomer_name() {
		return customer_name;
	}





	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}





	public String getCustomer_id() {
		return customer_id;
	}





	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}





	public int getAge() {
		return age;
	}





	public void setAge(int age) {
		this.age = age;
	}





	public String getCustomer_mobileNumber() {
		return customer_mobileNumber;
	}





	public void setCustomer_mobileNumber(String customer_mobileNumber) {
		this.customer_mobileNumber = customer_mobileNumber;
	}





	public double getAccount_balance() {
		return account_balance;
	}





	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}





	public StringBuffer getCustomer_address() {
		return customer_address;
	}





	public void setCustomer_address(StringBuffer customer_address) {
		this.customer_address = customer_address;
	}





	public int getAccount_Number() {
		return account_Number;
	}





	public void setAccount_Number(int account_Number) {
		this.account_Number = account_Number;
	}





	public int getPin_Number() {
		return pin_Number;
	}





	public void setPin_Number(int pin_Number) {
		this.pin_Number = pin_Number;
	}





	@Override
	public String toString() {
		return "BankAccount [customer_name=" + customer_name + ", customer_id="
				+ customer_id + ", age=" + age + ", customer_mobileNumber="
				+ customer_mobileNumber + ", account_balance="
				+ account_balance + ", customer_address=" + customer_address
				+ ", account_Number=" + account_Number + ", pin_Number="
				+ pin_Number + ", Transaction=" + Transaction + "]";
	}

	
 
 
}	
	
