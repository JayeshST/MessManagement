package com.code;

import java.io.Serializable;
import java.time.LocalDate;

public class customer implements Comparable<customer>,Serializable {

//	Create a Java Application Monthly Mess System
//	Create a Customer class with following attributes
//	Customer id(int) ,first name(String), last name (String),email(String),password(String),Address String,RegisterDate(LocalDate),
//	planEndDate(LocalDate), Address(String),Phone No(String),plan Enum, final_amount double
//	Messplan(Plan : enum) Plans Are as follows:-
//	 Monthly (3000), Quarterly (11700), Half Year (17500), Yearly (32000)
//	All CRUD operations MUST happen in constant time performance (by using HASHMAP)
//	You perform serialization (Store)(Hint:-JAVA App->OOS->FOS)
//	 De-serialization (Restore)(Hint:-JAVA App<-OIS<-FIS)
//	Imperative/Declarative
//	Write the separate utility classes
//	:For populated map, and for i/o operations
//	Validation and parsing are on:
//	a)Validate Customer check for Duplication
//	b)Validatecustomer login if not exist or invalid mail & invalid password
//	Email must be like regex provided in :
//	"[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"
//	e.g user1.dac@iacsd.com
//	c)ParseValidatePlan , registration amount must be match with plan
//	d) Parse local Date
//	registration date can be only todays date or after todays dateand end date must be depend on plan selected
//	e.g if user reg date is 11/10/2023 and selected plan is of 1 year then end date set automatically as 11/12/2024
//	e) Phone number must be only 10 character and the number could be between 0 to 9. 
//	Hint : regex
//	1. Sign up Customer
//	2. If already register then sign in
//	3. Change Password
//	4. Sort Customer as per 
//	A) First name 
//	B) According to plan
//	C) According to date of registration
//	(Imperative/Declarative way)
//	5. Unsubscribe customer according plan duration (month wise (1, 3, 6, 12))
//	6. Display all Customers
//	7) Modify all customers first name (make first Letter capital of customers first name)
//	8) Display email addresses of the customers who did registration in month of January
//	10)Display count of the Customer 3swho have register for plan:Monthly
//	11) Search the Customer who lived in Akurdi.
//	12) Give the 20% discount to the customers who have selected plan for 1 year.

	private int customerid;
	private String fname, lname, email, password, address, phoneno;
	private LocalDate regdate, planenddate;
	private serviceplan plan;
	private double finalamount;

	public customer(int customerid, String fname, String lname, String email, String password, String address,
			String phoneno, LocalDate regdate, LocalDate planenddate, String plan, double finalamount) {
		super();
		this.customerid = customerid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneno = phoneno;
		this.regdate = regdate;
		this.planenddate = planenddate;
		this.plan = serviceplan.valueOf(plan);
		this.finalamount = finalamount;
	}

	// add a method to check duplicate for check validation rules
	// add overloaded constr to wrap pk

	public customer(String email) {
		this.email = email;
	}

	
	
	
	
	
	
	
	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public LocalDate getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}

	public LocalDate getPlanenddate() {
		return planenddate;
	}

	public void setPlanenddate(LocalDate planenddate) {
		this.planenddate = planenddate;
	}

	public serviceplan getPlan() {
		return plan;
	}

	public void setPlan(serviceplan plan) {
		this.plan = plan;
	}

	public double getFinalamount() {
		return finalamount;
	}

	public void setFinalamount(double finalamount) {
		this.finalamount = finalamount;
	}

	@Override
	public String toString() {
		return "customerid=" +  customerid   + 
				", fname= \n" + fname  +  
				", lname= \n" + lname +  
				", email= \n" + email +
 				 ", password= \n" + password +
				", address= \n" + address +
				", phoneno= \n" + phoneno + 
				", regdate= \n" + regdate +
			     ", planenddate= \n" + planenddate + 
				", plan= \n" + plan + 
				", finalamount= \n" + finalamount + "";
	
	
	}

	// for check
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof customer) {
			customer c1 = (customer) obj;
			return this.email.equals(c1.email);
		}
		return false;
	}

	// this method only for sort operation
	// only for natural ordering sort
	@Override
	public int compareTo(customer o) {
		System.out.println("compare To");
		return this.email.compareTo(o.email);
	}

}
