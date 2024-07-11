package Busbooking;
import java.util.ArrayList;
import java.util.Scanner;
public class Ad_access {
	
	public void ad_access() throws Exception {
	
		System.out.println("\n[1] Add New Bus\n[2] Remove Bus\n[3] View Customers\n[4] Remove customer\n[5] View all bus\n[6] Logout");
		Scanner scan=new Scanner(System.in);
		int choice =scan.nextInt();  	
		Bus bus=new Bus();
		userData ud=new userData();
		Admin admin=new Admin();
		
		if(choice ==1) {
			bus.addbus();
		}else if(choice ==2) {
			admin.removeBus();
		}else if(choice==3) {
			ArrayList <userData> user=ud.aviluser();
			ud.displayuser(user);
		}else if(choice==4) {
			admin.removeusers();
		}
		else if(choice ==5) {
			bus.totbus();
			bus.disp();
			bus.display();
			ad_access();
			
		}
		else if(choice ==6) {
			System.out.println("Logout Successfully");
			System.exit(choice);
		}
	scan.close();
	}
	public static void main(String[] args) throws Exception {
		Ad_access ad=new Ad_access();
		ad.ad_access();
		
		}
}
