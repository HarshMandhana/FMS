package com.cg.fms.pl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.fms.bean.Booking;
import com.cg.fms.bean.Flight;
import com.cg.fms.bean.Passenger;
import com.cg.fms.bean.User;
import com.cg.fms.exception.BookingException;
import com.cg.fms.service.BookingService;
import com.cg.fms.service.BookingServiceImpl;

public class Client {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		BookingService bookingservice=new BookingServiceImpl();
		int choice=0;
		Booking booking=null;
		List<Booking> list=null;
		List<Passenger> listofpassenger=null;
		User u3=new User("User",103,"harsh","harsh1",1254,"harsh@gmail.com");
		Flight f3= new Flight(1003,"FIRSTCLASS","INS",50);
		try
		{
		while(choice!=5)
		{
			
			System.out.println("1.Add Booking");
			System.out.println("2.View details of Bookingid");
			System.out.println("3.View details of all Bookings");
			System.out.println("4.Delete Booking");
			System.out.println("5.Exit");
			System.out.println("Enter your choice from 1-5");
			choice=sc.nextInt();
			
			if(choice<1 || choice>5)
			{
				System.err.println("Enter Valid Choice from 1-5");
			}
			
			switch(choice)
			{
			case 1:
				try
				{
				int a=u3.getUserId();
				System.out.println("Enter Date for booking flight in dd-mm-yyyy format");
				String str=sc.next();
				DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate l1=LocalDate.parse(str,pattern);
				System.out.println("Enter number of passengers");
				int d1=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Passenger Details");
				List<Passenger> list1=new ArrayList<Passenger>();
				
				System.out.println("Enter pnr number");
				int pnr=sc.nextInt();
				for(int i=0;i<d1;i++)
				{
					Passenger p=new Passenger();
					System.out.println("Enter Passenger name");
					String name=sc.next();
					System.out.println("Enter Passenger age");
					int age=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Passenger Unique id");
					int uin=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter number of luggage");
					double luggage=sc.nextDouble();
					p.setPassengerName(name);
					p.setPassengerAge(age);
					p.setPassengerUIN(uin);
					p.setLuggage(luggage);
					p.setPnrNumber(pnr);
					
					list1.add(p);
					
				}
				double t1=d1*2500.0;
				
				booking=new Booking();
				booking.setUserId(u3);
				booking.setBookingDate(l1);
				booking.setFlight(f3);
				booking.setTicketCost(t1);
				booking.setNoOfPassengers(d1);
				
				
					Booking b=bookingservice.addBooking(booking);
					int id=b.getBookingId();
					System.out.println("Booking id "+id);
				}
				catch(BookingException e)
				{
					System.err.println(e.getMessage());
				}
				catch(DateTimeParseException e)
				{
					System.err.println("Date should be in dd-MM-yyyy format");
				}
				break;
				
				
			case 2:
				System.out.println("Enter bookingid to get details of that booking");
				int id=sc.nextInt();
				sc.nextLine();
				try
				{
					List<Booking> li=bookingservice.viewBooking(id);
					for(Booking c: li)
					{
						User user=c.getUserId();
						LocalDate l2=c.getBookingDate();
						double d2=c.getTicketCost();
						Flight f=c.getFlight();
						int num1=c.getNoOfPassengers();
						System.out.println("Bookingid:"+id+" ,userId:"+user+" ,Date:"+l2+" ,Flight:"+f+" ,Ticket cost="+d2+" ,Number of Passengers"+num1);
					}
				}
				catch(BookingException e)
				{
					System.err.println("bookingid not found");
				}
				
				break;
				
			case 3:
				System.out.println("Details of all the bookings");
				try
				{
					List<Booking> listall=bookingservice.viewBooking();
					for(Booking c: listall)
					{
						int id1=c.getBookingId();
						User user=c.getUserId();
						LocalDate l2=c.getBookingDate();
						double d2=c.getTicketCost();
						Flight f=c.getFlight();
						int num1=c.getNoOfPassengers();
						List<Passenger> li=c.getPassengerList();
						System.out.println("Bookingid:"+id1+" ,userId:"+user+" ,Date:"+l2+" ,Flight:"+f+" ,Ticket Cost="+d2+" ,Number of Passengers:"+num1+" ,List of Passenger"+li);
					}
				}
				catch(BookingException e)
				{
					System.err.println(e.getMessage());
				}
				break;
				
			case 4:
				System.out.println("Enter Bookingid whose booking is to be deleted");
				int d=sc.nextInt();
				sc.nextLine();
				try
				{
					bookingservice.deleteBooking(d);
					System.out.println("Delete successful");
				}
				catch(BookingException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			
			case 5:
				
				System.out.println("Thank you");
				return;
			}
		}
		
		}
		
		catch(InputMismatchException e)
		{
			
			System.err.println("Enter Valid Choice From 1-5");
			
		}
		
	}
		
}
