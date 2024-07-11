package Busbooking;

import java.util.ArrayList;
import java.util.Scanner;
	
public class login {
	private Scanner scan;
	
	public login(){
		this.scan = new Scanner(System.in); 
	}
	public boolean run() {
			System.out.println("Welcome to User login \n\t↓");
			userData ud=new userData();
			ArrayList <userData> user=ud.aviluser();
		while(true) {
			System.out.println("Signin -> 1\tNew user Signup -> 2\texit -> 3");
			
			int choice =scan.nextInt();scan.nextLine();
			
			switch(choice) {
			case 1:{
				System.out.println("Enter the id :");
				int id=scan.nextInt();scan.nextLine();
				System.out.println("Enter the password :");
				String pass=scan.nextLine();
				userData us=new userData();
				us.login(id, pass);break;
			}
			case 2:{
				System.out.println("Enter the name :");
				String name =scan.nextLine();
				System.out.println("Enter the new password :");
				String pass=scan.nextLine();
				ud.genid();//generated unique id
				System.out.println("Enter the generated id :");
				int id=scan.nextInt();scan.nextLine();
				System.out.println("Enter the mail :");
				String mail =scan.nextLine();
				System.out.println("Enter the Mobile :");
				String mob=scan.nextLine();
				ud.adduser(name,mob,mail,id,pass);
				break;
			}
			case 3:{
				System.out.println("Thank you, Have a nice Day !...");
				System.exit(0);
			}
			case 4:{
				ud.displayuser(user);run();
				}
			}
		}
	}
}
