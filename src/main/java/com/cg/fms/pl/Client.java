package com.cg.fms.pl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.cg.fms.bean.Booking;
import com.cg.fms.bean.Flight;
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
		User u3=new User("User",103,"harsh","harsh1",1254,"harsh@gmail.com");
		Flight f3= new Flight(1003,"FIRSTCLASS","INS",50);
		
		while(choice!=6)
		{
			System.out.println("1.Add Booking");
			System.out.println("2.Modify Booking");
			System.out.println("3.View details of Bookingid");
			System.out.println("4.View details of all Bookings");
			System.out.println("5.Delete Booking");
			System.out.println("6.Exit");
			System.out.println("Enter your choice");
			
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				int a=u3.getUserId();
				System.out.println("Enter Date for booking flight in yyyy-MM-dd format");
				String str=sc.next();
				LocalDate l1=LocalDate.parse(str);
				System.out.println("Enter number of passengers");
				int d1=sc.nextInt();
				sc.nextLine();
				double t1=d1*2500.0;
				
				booking=new Booking();
				booking.setUserId(u3);
				booking.setBookingDate(l1);
				booking.setFlight(f3);
				booking.setTicketCost(t1);
				booking.setNoOfPassengers(d1);
				
				try
				{
					Booking b=bookingservice.addBooking(booking);
					int id=b.getBookingId();
					System.out.println("Booking id "+id);
				}
				catch(BookingException e)
				{
					System.err.println(e.getMessage());
				}
				break;
				
			case 2:
				System.out.println("Modify Booking");
				System.out.println("New Number of passenger");
				int no=sc.nextInt();
				sc.nextLine();
				try
				{
					Booking modify=bookingservice.modifyBooking(booking, no);
				}
				catch(BookingException e)
				{
					System.err.println(e.getMessage());
				}
				break;
				
			case 3:
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
						System.out.println("Bookingid:"+id+" userId:"+user+" Date:"+l2+" Flight:"+f+" Ticket cost="+d2+" Number of Passengers"+num1);
					}
				}
				catch(BookingException e)
				{
					System.err.println(e.getMessage());
				}
				
				break;
				
			case 4:
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
						System.out.println("Bookingid:"+id1+" userId:"+user+" Date:"+l2+" Flight:"+f+" Ticket Cost="+d2+" Number of Passengers:"+num1);
					}
				}
				catch(BookingException e)
				{
					System.err.println(e.getMessage());
				}
				break;
				
			case 5:
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
			
			case 6:
				
				System.out.println("Thank you");
				return;
			}
		}

	}

}
