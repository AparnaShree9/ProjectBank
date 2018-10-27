package com.capg.bank.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capg.bank.beans.BankAccount;
import com.capg.bank.dao.BankDAOImp;
import com.capg.bank.exception.MyException;

public class BankServiceImp implements IBankService {
	
	BankDAOImp dao = new BankDAOImp();
	
	
	
public boolean validateName	(String customer_name) throws MyException{
	Pattern name = Pattern.compile("^[A-Z][A-Za-z\\s]*$");
	
        Matcher match = name.matcher(customer_name);
        if(match.matches()){
            return true;
        }
        return false;
    }
public boolean validateID(String customer_id) throws MyException{
	Pattern id = Pattern.compile("\\d{12}");
	
        Matcher match = id.matcher(customer_id);
        if(match.matches()){
            return true;
        }
        return false;
    }
	
public boolean validateAge(int age) throws MyException{
	if(age>12){
		return true;
	}
	return false;

}

public boolean validateAdd(StringBuffer customer_address){
	
	Pattern addr = Pattern.compile("[A-Za-z0-9,]+");
	
    Matcher match = addr.matcher(customer_address);
    if(match.matches()){
        return true;
    }
    return false;
	
	
	
}
/*public boolean validateAdd(StringBuffer customer_address){
	String addressToken="[\\p{Punct}&&[#,.()-]]+\\d*+\\s?+[\\p{Alpha}+\\s?]*";

    String addressPattern="("+addressToken+"){1,6}";
	
	
    Matcher match = addressPattern.matcher(customer_address);
    if(match.matches()){
        return true;
    }
    return false;
	
	
	
}*/
public boolean validatenum(String customer_mobileNumber) throws MyException{
	Pattern num = Pattern.compile("\\d{10}");
	
        Matcher match = num.matcher(customer_mobileNumber);
        if(match.matches()){
            return true;
        }
        return false;
    }

public boolean validateAmt(double account_balance) throws MyException{
	if(account_balance>=500){
		return true;
	}
	return false;

}


	public boolean createAccount(int account_Number,BankAccount b) throws MyException{
		
		return dao.createAccount(account_Number,b);
		}

	 public double showBalance(int account_Number,int pin_number) throws MyException{
		 
		return	 dao.showBalance(account_Number, pin_number); 
	 }
	 
	 public boolean isValid(int account_Number,int pin_number) throws MyException{
		 
		 return dao.isValid(account_Number,pin_number);
		 
	 }
     public boolean isValid(int account_Number) throws MyException{
		 
		 return dao.isValid(account_Number);
		 
	 }
   
	 public double deposit(int account_Number, double depamt) throws MyException{
		 
		 return dao.deposit(account_Number, depamt);
	 
	 }
	 
	 public double withdraw(int account_Number,int pin_number,double widAmt) throws MyException{
		 
		return dao.withdraw(account_Number,pin_number,widAmt);
		 
	 }
	 
	 public double fundTransfer(int account_Number,int account_Number2,int pin_number, double tAmt) throws MyException{
		 
		return dao.fundTransfer(account_Number,account_Number2,pin_number,tAmt);
		 
	 }
	 
	
	 public void printTransactions(int account_Number,int pin_number) throws MyException{
		dao.printTransactions(account_Number,pin_number);
 
	 }
	 /*public BankAccount displayCustomer(int account_Number)
	 {
		 return dao.displayCustomer(account_Number);
	 }*/
}
