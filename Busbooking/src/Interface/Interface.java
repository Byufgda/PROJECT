package Interface;
import java.util.Scanner;
import Busbooking.Admin;
import Busbooking.Bus;
import Busbooking.login;
public class Interface {
public static void main(String [] args)throws Exception {
	
	System.out.println("  ********************************************");
	System.out.println("  **        Welcome to HAPPY JOURNEY !      **");
	System.out.println("  ********************************************");
	System.out.println("  ** [1] User login                         **");
	System.out.println("  ** [2] Admin login                        **");
	System.out.println("  ** [3] View all buses                     **");
	System.out.println("  ** [4] Exit                               **");
	System.out.println("  ********************************************");
	System.out.println("  ********************************************\n");
	
	Scanner scan=new Scanner(System.in);
	int UA=scan.nextInt();
	
	if(UA==1) {
		login Login =new login();
		Login.run();
	}
	else if(UA==2) {
		Admin admin =new Admin();
		admin.Adminlogin();
	}
	else if(UA==3) {
		Bus bus=new Bus();
		bus.totbus();
		bus.disp();
		bus.display();
	}
	else if(UA==4) {
		System.out.println("Thank you !\nHave a nice day :)");
		System.exit(0);
	}
	else  {
		System.out.println("Invalid input please try again ");
	}
	scan.close();

}
}
