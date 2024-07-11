package Busbooking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Bus  implements Serializable {
	private int num,capacity;
	private String name;
	private final static String data="Bus data.dat";
	private static final long serialVersionUID = 1L;
	private ArrayList<Bus> buses=new ArrayList<>();
	private ArrayList<Bus>nbuses=new ArrayList<>();
	
	public Bus(String name,int num,int capacity) {
	this.name=name;
	this.num=num;
	this.capacity=capacity;
	}
	
	public Bus(){num=0;capacity=0;name=null;}
	
	public static Scanner scan=new Scanner(System.in);
	
	public void totbus() {
		buses=new ArrayList<>();
		buses.add(new Bus("A",1,10));
		buses.add(new Bus("B",2,20));
		buses.add(new Bus("C",3,30));
		
	}
	
	public void disp() {
		System.out.println("\n--------Loaded AC Buses--------");
		for(Bus b:buses) {	
		System.out.println("Bus name :"+b.name+" capacity :"+b.capacity+" Bus number "+b.num);
		
		}
	}
	@SuppressWarnings("unchecked")
	public void display() {	//admin display
		try(ObjectInputStream ois =new ObjectInputStream(new FileInputStream(data));){
			nbuses=(ArrayList<Bus>)ois.readObject();
		} catch (Exception e) {
			System.err.println("Error occurs on reading file "+e.getMessage());
		}
		if(nbuses.isEmpty()) {
			System.out.println("No new Buses found ");
		}else {
			System.out.println("\n-----Loaded NON-AC Buses-----");
			for(Bus us:nbuses) {
				System.out.println("Name of bus :"+us.getbusname()
				+"\tBus number : "+us.getbusnumber()
				+"\tBus capacity :"+us.getbuscapacity());
			}
		}
	}	
	@SuppressWarnings("unchecked")
	public void addbus() throws Exception{
		try(ObjectInputStream ois =new ObjectInputStream(new FileInputStream(data));){
			nbuses=(ArrayList<Bus>)ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Error occurs on reading file "+e.getMessage());
		}
		
		System.out.println("Enter the new bus name : ");
			String nbusname=scan.nextLine();
		System.out.println("Enter the new bus number : ");
			int nbusnumber =scan.nextInt();scan.nextLine();
		System.out.println("Enter the new bus capacity : ");
			int nbuscapacity =scan.nextInt();scan.nextLine();
			
		nbuses.add(new Bus(nbusname,nbusnumber,nbuscapacity));
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(data))) {
			oos.writeObject(nbuses);
			System.out.println("Bus added Successfully");
			Ad_access adc=new  Ad_access();
			adc.ad_access();
		}catch(IOException e) {
			System.err.println("Error occurs on addingbus  "+e.getMessage());
		}		
	}
	@SuppressWarnings("unchecked")
	public void removebus() throws IOException {
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(data))){
			nbuses=(ArrayList<Bus>)ois.readObject();
			System.out.println("Enter the bus name :");
			String busname=scan.nextLine();
			System.out.println("Enter the bus number :");
			int busnumber =scan.nextInt();scan.nextLine();
			
			boolean busfound=false;
			Iterator<Bus>iterator=nbuses.iterator();
			while(iterator.hasNext()) {
				Bus b=iterator.next();
				if(busnumber==b.num && busname.equals(b.name)) {			
					iterator.remove();
					busfound=true;
					System.out.println("Non-AC Bus removed Successfully");
					System.exit(0);
					}			
				}
			if(!busfound) {
					System.out.println("Bus not found");
					Admin admin=new Admin();
					admin.removeBus();
				}
			}
		catch(Exception e) {
			System.err.println("Error occurs on removing bus "+e.getMessage());
		}
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(data))) {
			oos.writeObject(nbuses);
			
		}catch(IOException e) {
			System.err.println("Error occurs while saving bus  "+e.getMessage());
		}
	}
	public boolean removerac() {
		totbus();
		System.out.println("Enter the bus name :");
		String busname=scan.nextLine();
		System.out.println("Enter the bus number :");
		int busnumber =scan.nextInt();scan.nextLine();
		
		Iterator<Bus> iterator =buses.iterator();
		while(iterator.hasNext()) {
			Bus b=iterator.next();
			if(b.name.equals(busname) || b.num==busnumber) {
				iterator.remove();
				System.out.println("Bus removed successfully");
				Ad_access adc=new  Ad_access();
				try {
					adc.ad_access();
				} catch (Exception e) {
					System.out.println("Admin redirect"+e.getMessage());
				}
				System.exit(0);
			}
		}
		System.out.println("No bus found");
		return false;
		
	}
	public boolean available(String busname,int busnumber){
		for(Bus b:buses) { 
			if(b.num==busnumber && b.name.equals(busname)){
			 System.out.println("Bus number :" + busnumber);
			 System.out.println("Bus name :"+busname);
			 System.out.println("Bus name and number matches.");
			 System.out.println("Bus capacity :"+b.capacity);
			 return true;
			}
		}
		System.out.println("NO match found");
		return false;
	}
	
	
	public String getbusname() {
		return name;
		}
	public void setbusname(String name) {
		this.name=name;
		}
	public int getbuscapacity() {
		return capacity;
		}
	public void setbuscapacity(int capacity) {
		this.capacity=capacity;
		}
	public int getbusnumber() {
		return num;
		}
	public void setbusnumber(int busnumber) 
		{
		num=busnumber;
		}
	public ArrayList<Bus> getbuses() {
		return buses;
	}

}

