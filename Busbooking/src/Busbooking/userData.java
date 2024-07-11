package Busbooking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class userData implements Serializable {
	private String name, mail,mob,password;int id=0;
	private final static String data="User data.dat";
	static ArrayList<userData> user=new ArrayList<>();

	public userData(String name,String mail,String mob,int id,String password){
		this.password=password;
		this.name=name;
		this.mail=mail;
		this.mob=mob;
		this.id=id;
	}
	public userData(){
		password=null;
		name=null;
		mail=null;
		mob=null;
		id=0;
	}
	public void genid() {
		Random r=new Random();
		int max=9999;
		int min=1000;
		int gennumber=r.nextInt((max-min)+1)+min;
		System.out.println("The generated id is "+gennumber);
	}
	@SuppressWarnings("unchecked")
	public ArrayList<userData> aviluser(){
		if(getData().isEmpty()) {
		System.out.println("No data found ");
	}
	File file=new File(getData());
	if(file.exists()) {
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(getData()));){
			user=(ArrayList<userData>)ois.readObject();
		}catch(Exception e) {
			System.err.println("Error occurs in aviluser \n"+e.getMessage());
			}
		}
		return user;
	}
	public void adduser(String name,String mob,String mail,int id,String password)  {
		user.add(new userData(name,mob,mail,id,password));
	
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getData()));) 
		{
			oos.writeObject(user);oos.close();
		} catch (IOException e){
			System.err.println("Error occurs in adduser \n"+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("User added Successfull");
	}
	public void removeuser(int id,String name) {
        aviluser(); // Load the user data before attempting to remove a user
        boolean userFound = false;
        for (userData us : user) {
            if (us.getid() == id && us.getname().equals(name)) {
                user.remove(us);
                userFound = true;
                break;
            }
        }
        if (userFound) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getData()))) {
                oos.writeObject(user);
                System.out.println("User removed successfully");
            } catch (IOException e) {
                System.err.println("Error occurs in removeuser \n" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("User not found");
        }
	}
	public boolean login(int id,String pass) {
		if(user.isEmpty()) {
			System.out.println("No data found, Signup to continue. \n");
			return false;
			}
			for(userData us:user) {
				if(us.getpass().equals(pass)  && us.getid()==id ) {
					System.out.println("Id and Password matches : )\n\t↓\nWelcome !");	
					Bus bus=new Bus();
					bus.totbus();
					booking book=new booking();
					book.busbooking();
					return true;					
				}
			}
			System.out.println("Pass does't match ");
			login log=new login();
			log.run();
			return false;
	}
	public void displayuser(ArrayList<userData> user) {
		if(user.isEmpty()) {
			System.out.println("No users found");
		}else {
			System.out.println("-------Loaded user------- \n");
			for(userData ud:user) {
				System.out.println(
								"Name of user : "+ud.getname()
								+"\tUser id :"+ud.getid()
								+"\t User password  "+ud.getpass()
								+"\t User mob : "+ud.getmob()
								+"\t The user mail : "+ud.getmail());
				}
			}
		}
	public String getname() {
		return name;
		}
	public int getid() {
		return id;
		}
	public String getmail() {
		return mail;
		}
	public String getmob() {
		return mob;
	}
	public String getpass() {
		return password;
	}
	public static String getData() {
		return data;
	}
}

