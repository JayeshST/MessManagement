package com.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.code.customer;
import com.code.serviceplan;

import static com.tester.validationrules.inputall;

public class tester {

	public static void main(String[] args) {

		List<customer> cust = new ArrayList<>();
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit) {
				System.out.println(
						"Choose 1 sign up customer \n 2. sign in \n  3 change password \n  4 sort per email \n 5 sort per fname \n"
								+ "6 Dispaly all customer \n    7  Modify all customers first name (make first Letter capital of customers first name) \n"
								+ "   8     Display email addresses of the customers who did registration in month of January \n "
								+ "   9 Display count of the Customerswho have register for plan:Monthly \n"
								+ "10  search customer who lived in akurdi \n   11  for serialization \n 12 for deserialization \n 0 exit \n   ");

				try {
					System.out.println("Enter choice");
					switch (sc.nextInt()) {

					case 1:
						System.out.println(

								// 1 sign up customer

								"Enter customer details int customerid, String fname, String lname, String email,"
										+ " String password, String address,\r\n"
										+ "String phoneno, String regdate, String planenddate, String plan, double finalamount");
						customer c1 = inputall(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), cust);
						cust.add(c1);
						System.out.println("Customer added successfully");
						System.out.println("-----------------------");
						break;

					case 2:

						// 2. sign in

						System.out.println("Sign in");
						System.out.println("Enter email and password");
						customer c2 = new customer(sc.next());
						boolean check = false;
						for (customer c : cust) {
							if (c.equals(c2))
								check = true;
							// System.out.println("Enter password");
							String s = sc.next();
							if (c.getPassword().contains(s))
								System.out.println("Login Successfully");
							System.out.println(c);
						}
						break;
					case 3:

//						3 change password
						System.out.println("Enter email ");
						customer c3 = new customer(sc.next());
						for (customer c : cust) {
							if (c.equals(c3))
								System.out.println("Enter password");
							if (c.getPassword().contains(sc.next()))
								System.out.println("Enter new password");
							c.setPassword(sc.next());
							System.out.println("Password save successfully");
						}

						break;

					case 4:
						// 4 sort per email
						// natural orderring sort as per email
						Collections.sort(cust); {
						System.out.println(cust);
					}

						break;
					case 5:

//						 5 sort per fname
						// custom ordering sort as per fname

						Collections.sort(cust, new Comparator<customer>() {
							@Override
							public int compare(customer o1, customer o2) {
								System.out.println("Custom ordering sort as per fname");
								return o1.getFname().compareTo(o2.getFname());
							}
						});

						break;

					case 6:

						// 6 Dispaly all customer
						for (customer c : cust) {
							System.out.println("---------------------");
							System.out.println(c);
							System.out.println("---------------------");
						}
						break;

					case 7:
						// Modify all customers first name (make first Letter capital of customers first
						// name

						break;

					case 8:

						// Display email addresses of the customers who did registration in month of
						// January

						cust.stream()
						.filter(i->i.getRegdate().getMonthValue()==1)
						.forEach(i->System.out.println(i));
						
						
						break;

					case 9:

						// display count of customer who have register for plan:Monthly
					
						
						long p=cust.stream()
                         .filter(i->i.getPlan()==serviceplan.MONTHLY).count();
						System.out.println(p);
						
						break;

					case 10:
						// 10 search customer who lived in akurdi
						System.out.println("search akurdi");

						cust.stream()
						.filter(i -> i.getAddress().equals("akurdi"))
						.forEach(i -> System.out.println(i));

						break;

					case 11:

					// for storage serilization 
						System.out.println("Enter file name");
						com.tester.serial.encoder(cust, sc.next());
						
						
						break;
					
					case 12:
						//for deserialization 
						System.out.println("Enter file name=");
						List<customer>cust1=com.tester.serial.decoder(sc.next());
						System.out.println(cust1);
						
						
						break;

					case 0:

						System.out.println("Exit");
						exit = true;
						break;

					}

				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
					sc.nextLine();
				}

			}

		}

	}

}

//    11 Jayesh Patil  jay1@gmail.com  abc1 pune 1234567890  2002-02-02 2003-03-03 MONTHLY  65000
//    12 Anil Patil  jay2@gmail.com  abc2  akurdi 1234567890  2002-02-02 2003-03-03 MONTHLY  45000
//    13 rahul Patil  jay3@gmail.com  abc3 mumbai 1234567890  2002-02-02 2003-03-03 MONTHLY  85000
//    14  pooja Patil  jay4@gmail.com  abc4 delhi 1234567890  2002-02-02 2003-03-03 MONTHLY  95000
//    15 raj Patil  jay5@gmail.com  abc5 jalgaon 1234567890  2002-02-02 2003-03-03 MONTHLY  55000
