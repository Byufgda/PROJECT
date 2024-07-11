package Busbooking;

import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("serial")
public class booking extends Exception{
	
	private int memcapacity=0;
	private int busbookings=0;
	private Scanner scan;
	public void busbooking() {
		Bus bus=new Bus();
		booking book =new booking();
		Date date=new Date();
		login log=new login();
		this.scan=new Scanner(System.in);
		int choice;

		do {
	System.out.println("Enter Show buses -> 1, Book buses -> 2, Logout -> 3 ");
		choice=scan.nextInt();
		scan.nextLine();
	switch(choice) {
	
	case 1:{
		System.out.println("Here is the bus list \n");
		bus.totbus();
		bus.disp();
		bus.display();
		break;
	}
	case 2:{
		System.out.println("Enter bus name :");
	String busname =scan.nextLine();
		System.out.println("Enter bus number :");
	int busnumber =scan.nextInt();
	
	if(bus.available(busname, busnumber)) {
		for(Bus b:bus.getbuses()) {	
			if(b.getbusnumber()==busnumber && b.getbusname().equals(busname)) {
				System.out.println("\nEnter the members :");
				int mem=scan.nextInt();scan.nextLine();				
				book.memcapacity+=mem;
				System.out.println("Member capacity :"+book.memcapacity);
				
				if(b.getbuscapacity()>=book.memcapacity) {			
					book.busbookings++;
					System.out.println("Your booking was successful :) \n"+date);
					System.out.println("--Payment was not refunded--");
					System.out.println("Your bookings : "+book.busbookings);
					System.out.println("Do you an want another booking or 3 to exit \n\t↓");
					busbooking();
					}
				else {System.out.println("Bus full :(");break;}				
				}
			}
		}
	
	}
	case 3:{
		System.out.println("Thank you Have a nice day :)\nLogout successfully\n\t↓\n");
		log.run();
		break;
			}
				}
			}while(choice!=3);System.exit(0);
		}
	}


