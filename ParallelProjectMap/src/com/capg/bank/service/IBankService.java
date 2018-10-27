package com.capg.bank.service;
import com.capg.bank.exception.MyException;
import com.capg.bank.beans.BankAccount;
import com.capg.bank.exception.MyException;

public interface IBankService {
	
	 public boolean createAccount(int account_Number,BankAccount b) throws MyException;
	
	 public double showBalance(int account_Number,int pin_number) throws MyException;
	 
	// public boolean isValid(int account_Number,int pin_number);
	// public boolean isValid(int account_Number);
	
	 
	 public double deposit(int account_Number,double depamt) throws MyException;
	 
	 public double withdraw(int account_Number,int pin_number,double widAmt) throws MyException;
	 
	 public double fundTransfer(int account_Number,int account_Number2,int pin_number, double tAmt) throws MyException;
	 
	 public void printTransactions(int account_Number,int pin_number) throws MyException;
	// public BankAccount displayCustomer(int account_Number);
}
