package com.capg.bank.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.capg.bank.beans.BankAccount;
import com.capg.bank.exception.MyException;

public class BankDAOImp implements IBankDAO {
	
	BankAccount bank = new BankAccount(); 
	
	static Map<Integer,BankAccount> custList = new HashMap<Integer,BankAccount>();
	//static List<String> list = new ArrayList<String>();
	//static Map<Integer,list>trans= new HashMap<Integer,list>();
	static Map<Integer,StringBuffer>trans= new HashMap<Integer,StringBuffer>();
	
	StringBuffer j = new StringBuffer();
	
	public boolean createAccount(int account_Number, BankAccount b) throws MyException{
		
			boolean isAdded= true; 
	    custList.put(account_Number,b);
	    //System.out.println(custList);
	    
	    trans.put(b.getAccount_Number(),j.append("Your Initial balance is Rs "+b.getAccount_balance()+" that you deposited during account opening"));
		return isAdded;
		
	}
	public boolean isValid(int account_Number,int pin_number) throws MyException{
		   
			   boolean flag=false;
		   
		       for (BankAccount b : custList.values()) 
			   {
				if(b.getAccount_Number()==account_Number && b.getPin_Number()==pin_number)
				{
		   
		         flag = true;
				
				}
				 
			 }
		   return flag;
		  
	   }
	 
	 public boolean isValid(int account_Number) throws MyException{
		  
		   boolean flag=false;
		   
				if(custList.containsKey(account_Number))
				{
		         
		         flag = true;
					
			 }
		 
		   return flag;
	  
	 }
	   
		 public double showBalance(int account_Number,int pin_number) throws MyException
		 { 
			 
			 double a=0.0;
			
			for (BankAccount b : custList.values()) {
				
		     if(b.getAccount_Number()==account_Number && b.getPin_Number()==pin_number)
			 {
				
					  a = b.getAccount_balance() ;	
					  System.out.println("Your account balance is: " + a);
					
			}
			}
			 return a;
				
					
					
		 }
		
		 public double deposit(int account_Number ,double depamt) throws MyException{
			
		   double a=0.0;
		   for (BankAccount b : custList.values()) 
			 {
				if(b.getAccount_Number()==account_Number)
				{
					a= b.getAccount_balance();
					a=a+depamt;
					b.setAccount_balance(a);
				    trans.put(b.getAccount_Number(), j.append("You Deposited Rs "+depamt+" to your account"));
				    System.out.println(trans.values());
				}
				
			 }
		
		   System.out.println("Your new Balance is "+a);
		   return a;
			
	 }
		
		 public double withdraw(int account_Number,int pin_number, double widAmt) throws MyException{
		
			 double a=1.0;
			   for (BankAccount b : custList.values()) 
				 {
					if(b.getAccount_Number()==account_Number)
					{
						a= b.getAccount_balance();
						if(a>widAmt){
						a=a - widAmt;
						b.setAccount_balance(a);
						trans.put(b.getAccount_Number(), j.append("You Withdraw Rs "+widAmt+" from your account"));
						}
					}
					
				 }
			
			   System.out.println("Your new Balance is "+a);
			   return a;
		
		 }
		 public double fundTransfer(int account_Number,int account_Number2,int pin_number, double tAmt) throws MyException{
			
			 
			 double a= 0.0;
			 double k =0.0;
			   for (BankAccount b : custList.values()) 
				 {
					if(b.getAccount_Number()==account_Number &&b.getPin_Number()==pin_number )
					{
						a= b.getAccount_balance();
						if(a>tAmt)
						{
							a= a-tAmt;
							b.setAccount_balance(a);
							for (BankAccount b1 : custList.values()) 
							{
								if(b1.getAccount_Number()==account_Number2 )
								{
									k=b1.getAccount_balance();
									k = k+tAmt;
									b1.setAccount_balance(k);
									System.out.println(b1);
									trans.put(b1.getAccount_Number(), j.append("You received Rs "+tAmt+" to your account from the account number "+ b.getAccount_Number()));
								}
								
								
							}
							trans.put(b.getAccount_Number(), j.append("You transferred Rs "+tAmt/*" from your account to the account number "+ b1.getAccount_Number()*/));
						}
						
						else 
							System.out.println("can't transfer");
						
					}
					
				 }
			
			   System.out.println("Your new Balance is "+a);
			   return a;
			
		 }
		 public void printTransactions(int account_Number,int pin_number) throws MyException{
			 
			 /*for (StringBuffer s : trans.values()) {*/
				 
				 if (trans.containsKey(account_Number)) {
					   Object value = trans.get(account_Number);
					 System.out.println("Key : " + account_Number +" value :"+ value);
					 }
		       } 
		 }
			// }
		 
			 
			 /*for (BankAccount b : custList.values()){
				 if(b.getAccount_Number()==account_Number && b.getPin_Number()==pin_number){
			
					 for (StringBuffer s : trans.values()) {
						 if(b.getAccount_Number()==account_Number){
						 //System.out.println(s.getChars(arg0, arg1, arg2, arg3););
					             System.out.println(trans.values().);
			                }
					   }
				    }
			    }*/
		   
			
			 /*
					 for (Integer i : trans.keySet()) {
						 if(trans.keySet()==account_Number){
					            
						
							 
							 
							 for (StringBuffer s : trans.values()) {
					 
					    Iterator<> it = trans.iterator();
						while (it.hasNext()){
							c =it. next();
							System.out.println(c);
							}
			 
			 */
			 
			 
			
			/* 
			     }
			 }
		
	}*/
			 
