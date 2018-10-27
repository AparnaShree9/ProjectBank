package com.capg.bank.ui;
import java.util.Random;
import java.util.Scanner;

import com.capg.bank.beans.BankAccount;
import com.capg.bank.exception.MyException;
import com.capg.bank.service.BankServiceImp;

public class Client {
	
	
	public static void main(String[] args) throws MyException
		 {
		// TODO Auto-generated method stub
		
        System.out.println("---------Welcome to XYZ bank-----------");
         while (true){
		System.out.println("Choose the services you want to avail");
		System.out.println("1.Create Account");
		System.out.println("2.Show Balance");
		System.out.println("3.Deposit");
		System.out.println("4.Withdraw");
		System.out.println("5.Fund Transfer");
		System.out.println("6.Print Transactions");
		System.out.println("7.Exit");
		System.out.println("Enter your choice :");
		   Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		                  Client dm = new Client();
		              BankAccount bean = new BankAccount();
		            BankServiceImp service = new BankServiceImp();
		     switch (n) {
			case 1:
				try{
					Scanner sc1 = new Scanner(System.in);
				   System.out.println("Enter your name:");
				   String cname = sc1.nextLine();
				   boolean isTrue = service.validateName(cname);
				   boolean validname;
				   String cname1;
				   if(!isTrue){
					   do{
						   System.err.println("Enter your name as per your ID with fist letter capital");
						   System.out.println("Enter your name:");
						   cname1 = sc1.nextLine();
						   validname = service.validateName(cname1);
					   }while(!validname);
					   bean.setCustomer_name(cname1);   
					   }else 
						   bean.setCustomer_name(cname);
					  
				   
				   System.out.println("Give your permanent government ID (Adhaar No.): ");
				   String cid = sc.next();
				   boolean isTrue1 = service.validateID(cid);
				   boolean validid;
				   String cid1;
				   if(!isTrue1){
					   do{
						   System.err.println("Enter your 12 digit Adhaar number");
						   System.out.println("Give your permanent government ID (Adhaar No.): ");
						   cid1 = sc.next();
						   validid = service.validateID(cid1);
					   }while(!validid);
					   bean.setCustomer_id(cid1);   
					   }else 
						   bean.setCustomer_id(cid);
				   
				   
				   System.out.println("enter your age:");
				   int age = sc.nextInt();
				  boolean isTrue2=service.validateAge(age);
				  boolean validage;
				  int age1;
				  if(!isTrue2){
					  do{
						  System.err.println("The age should be more than 12");
						  System.out.println("Re-enter your age");
						  age1 =sc.nextInt();
						  validage = service.validateAge(age1);  
					  }while(!validage);
						  bean.setAge(age1);
				  }else
					  bean.setAge(age);
				   
				   
				   System.out.println("Enter your address :");
				      StringBuffer b = new StringBuffer();
			         
			          StringBuffer w = b.append(sc.next());
			          boolean isTrue3=service.validateAdd(w);
					  boolean validcity;
					  StringBuffer city;
					  if(!isTrue3){
						  do{
							  System.err.println("Enter correct city with first letter capital");
							  System.out.println("Re-enter your city");
							   city = b.append(sc.next());
							  validcity = service.validateAdd(city);  
						  }while(!validcity);
						       bean.setCustomer_address(city);
					  }else 
					
			          bean.setCustomer_address(w);
			          
				   System.out.println("Enter your mobile number");
				   String number = sc.next();
            
				   boolean isTrue4=service.validatenum(number);
					    boolean validnum;
					  String num;
					  if(!isTrue4){
						  do{
							  System.err.println("Enter valid number");
							  System.out.println("Re-enter your number");
							  num =sc.next();
							  validnum = service.validatenum(num);  
						  }while(!validnum);
							  bean.setCustomer_mobileNumber(num);
					  }else
						  bean.setCustomer_mobileNumber(number);
					   
		           System.out.println("Enter the minimum balance for your account");
		           System.out.println("The minimum amount limit is 500");
		                   double amt =sc.nextDouble();
		                   boolean isTrue5=service.validateAmt(amt);
		 				  boolean validamt;
		 				  double amt1;
		 				  if(!isTrue5){
		 					  do{
		 						  System.err.println("The minimum amount limit is 500");
		 						  System.out.println("Re-enter amount");
		 						  amt1 =sc.nextDouble();
		 						  validamt = service.validateAmt(amt1);  
		 					  }while(!validamt);
		 						  bean.setAccount_balance(amt1);
		 				  }else
		 					  bean.setAccount_balance(amt);
		 				   
		               
			       System.out.println("Congratulations ! Your account has been created");
			      
			       Random rd1= new Random();
			       int accNum= 100000+ rd1.nextInt(99999);
			    //  
			       bean.setAccount_Number(accNum);
			      /* System.out.println(bean);*/
			        boolean isAdded= service.createAccount(accNum,bean);
			        if(isAdded){
		
	    		    System.out.println("record added succesfully");
	    		    System.out.println("your Account number is " + accNum );
		             
			        }
			        
			        Random rd2= new Random();
				       int accPin= 1000+ rd2.nextInt(9999);
			       System.out.println("your PIN number is " + accPin );
			              bean.setPin_Number(accPin);
			       System.out.println(bean);
				}catch(MyException exp){
            		
            		System.out.println("It's an Error message"+exp.getMessage());
            	} 
			       
			       break;
			
            case 2:
            	       System.out.println("Enter your account number");
				          int accNum= sc.nextInt();
				          
				          System.out.println("Enter your PIN");
				          int pn= sc.nextInt();
				try{
				          boolean valid= service.isValid(accNum,pn);
				         
				             // service.displayCustomer(accNum);
				          service.showBalance(accNum, pn);
				      
				        //System.out.println();
            	}catch(MyException exp){
            		
            		System.out.println("It's an Error message"+exp.getMessage());
            	} 
				   break;
            case 3:
            	try{
            	System.out.println("Enter your account number");
            	int acNum = sc.nextInt();
            	boolean valid1= service.isValid(acNum);
            	if(valid1){
            	        System.out.println("Enter the amount to be deposited");
            	        double depamt = sc.nextDouble();
            	        double newbal =service.deposit(acNum, depamt);
            	        
            	     //bean.setAccount_balance(newbal);
            	  
            	}
            	}catch(MyException exp){
            		
            		System.out.println("It's an Error message"+exp.getMessage());
            	} 
            	break;
           
            case 4:
            	try{
            	System.out.println("Enter your account number");
		          int accNum1= sc.nextInt();
		          
		          System.out.println("Enter your PIN");
		          int pn1= sc.nextInt();
		          boolean valid2= service.isValid(accNum1,pn1);
		          
		          
		          if(valid2){
	
		          System.out.println("Enter the amount you want to withdraw");
		          double widAmt= sc.nextDouble();
            	  double newbal2=service.withdraw(accNum1, pn1, widAmt);
		         // bean.setAccount_balance(newbal2);
		        
		          }
            	}catch(MyException exp){
            		
            		System.out.println("It's an Error message"+exp.getMessage());
            	} 
				break;
            case 5:
            	try{
            	System.out.println("Enter your account number");
				int accnumf = sc.nextInt();
				System.out.println("Enter your PIN");
				int fpin = sc.nextInt();
				boolean valid3= service.isValid(accnumf,fpin);
				if(valid3){
				            System.out.println("Enter beneficiary's account number");
				            int accnums = sc.nextInt();
				            boolean valid4 = service.isValid(accnums);
				             if(valid4){
					             System.out.println("Enter the amount to be transferred");
					             double tAmt = sc.nextDouble();
					             double newbal3 = service.fundTransfer(accnumf, accnums, fpin, tAmt);
				             }
				  }
            	}catch(MyException exp){
            		
            		System.out.println("It's an Error message"+exp.getMessage());
            	} 
				
				break;
            case 6:
            	System.out.println("Enter your account number");
				int accnumt = sc.nextInt();
				System.out.println("Enter your PIN");
				int pint = sc.nextInt();
				boolean valid5= service.isValid(accnumt,pint);
				if(valid5){
					System.out.println("Your Transaction Details: ");
					service.printTransactions(accnumt,pint);
				
					}
				break;
            case 7:
            	System.exit(0);
				break;	
			default:
				System.err.println("Invalid Number !!!!!  Enter the correct choice ");
				break;
			}

	}

}
}
