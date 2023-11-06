package com.tester;

import java.time.LocalDate;
import java.util.List;

import com.code.customer;
import com.code.serviceplan;

public class validationrules {

	
	
	//for check enum serviceplan
	
	public static serviceplan parseplanenum(String plan) throws invalidexception{
		
		return serviceplan.valueOf(plan);
	}
	
	// for check LocalDate for registerdate
	
	public static LocalDate parsedate(String regdate) throws invalidexception
	{
		LocalDate redate=LocalDate.parse(regdate);
		LocalDate chkdate=LocalDate.of(2001, 01, 01);
		if(redate.isBefore(chkdate)) {
			throw new invalidexception("Date is before checkdate");
		}
		return redate;
	}
	
	// check LocalDate  for planendDate
	
	public static LocalDate parseenddate(String planenddate)throws invalidexception{
		
		LocalDate planenddate1=LocalDate.parse(planenddate);
		return planenddate1;
	}
		
		//add validation rules for email pattern 
	
	public static void duplicate(String email,List<customer>list)throws invalidexception{
		
		String pattern="[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
		if(!email.matches(pattern)) {
			throw new invalidexception("Email Pattern not match");
		}
		
		customer c1=new customer(email);
		if(list.contains(c1)) {
			throw new invalidexception("Duplicate email....");
		}
		
		
	}
		
	
	
	//validation rule for phone no check for 10 character
	
	public static void phoneno(String phoneno,List<customer>list)throws invalidexception{
		
		String regex="^[0-9]{10}$";
		if(!phoneno.matches(regex)) {
			throw new invalidexception("phone regex ont matches");
		}
		
	}
		
	
	
	
	
	
	
	
	// for validation all customer
	public static customer  inputall (int customerid, String fname, String lname, String email, String password, String address,
			String phoneno, String regdate, String planenddate, String plan, double finalamount,List<customer>list)throws invalidexception{
		serviceplan plan1=parseplanenum(plan);
		LocalDate d1=parsedate(regdate);
		LocalDate d2=parseenddate(planenddate);
		duplicate(email, list);
		
		
	return new customer(customerid, fname, lname, email, password, address, phoneno, d1, d2, plan, finalamount);
	}
	
	
	
	
	
	
	
	
}
