package Busbooking;

import java.util.Scanner;
public class Admin {
	private static final String Adminname="Raj";
	private static final int uid=2005;
	private static final String password ="java";
	private Scanner scan = new Scanner(System.in);
	
	Ad_access adc=new  Ad_access();
	Bus bus=new Bus();

	public boolean Alogin(String name,int id,String pass) throws Exception {
		if(Adminname.equals(name) && password.equals(pass) && uid==id) {
			System.out.println("\nAdmin logged'in Successfully\n");
			adc.ad_access();
		}
		else {
			System.out.println("\nInvalid input please try again");
			Adminlogin();
		}
		
		return false;
	}
	public void Adminlogin() throws Exception {		
				System.out.println("Welcome to Admin login !\n");
				System.out.println("Enter your name : ");
				String name=scan.nextLine();
				System.out.println("Enter your id : ");
				int id=scan.nextInt();scan.nextLine();
				System.out.println("Enter your password : ");
				String pass=scan.nextLine();
				Alogin(name,id,pass);			
		}
	
	public void removeusers() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter the name :");
			String name=scan.nextLine();
			System.out.println("Enter the id :");
			int id =scan.nextInt();
			userData ud = new userData();
			ud.removeuser(id, name);
		}
	}
	public void removeBus() throws Exception {
		System.out.println("Enter the bus to remove \nAc ->1\t  Non-Ac ->2\texit -> 3");
		int choice =scan.nextInt();
		while(true) {
			switch(choice) {
			case 1:{
				bus.removerac();
				break;
			}
			case 2:{				
				bus.removebus();
				break;
			}
			case 3:{
				System.out.println("Thank you !\n");
				adc.ad_access();
				break;
				
			}
			}
		}
	}
}

