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
		
		Scanner scanner=new Scanner(System.in);
		BookingService bookingservice=new BookingServiceImpl();
		int choice=0;
		Booking booking=null;
		//List<Booking> list=null;
		List<Passenger> listofpassenger=null;
		User user3=new User("User",103,"harsh","harsh1",1254,"harsh@gmail.com");
		Flight flight3= new Flight(1003,"FIRSTCLASS","INS",50);
		
		while(choice!=5)
		{
			
			System.out.println("1.Add Booking");
			System.out.println("2.View details of Bookingid");
			System.out.println("3.View details of all Bookings");
			System.out.println("4.Delete Booking");
			System.out.println("5.Exit");
			try
			{
			System.out.println("Enter your choice from 1-5");
			choice=scanner.nextInt();
			scanner.nextLine();
			}
			catch(Exception e)
			{
				System.err.println("Enter Valid Choice");
				scanner.nextLine();
			}
			if(choice<1 || choice>5)
			{
				System.err.println("Choice should be From 1-5");
			}
			
			switch(choice)
			{
			case 1:
				try
				{
				user3.getUserId();
				System.out.println("Enter Date for booking flight in dd-mm-yyyy format");
				String str=scanner.next();
				DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate localdate1=LocalDate.parse(str,pattern);
				System.out.println("Enter number of passengers");
				int numofpassenger=scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Passenger Details");
				List<Passenger> listofpassenger1=new ArrayList<Passenger>();
				
				System.out.println("Enter pnr number");
				int pnr=scanner.nextInt();
				for(int index=0;index<numofpassenger;index++)
				{
					Passenger passenger=new Passenger();
					System.out.println("Enter Passenger name");
					String name=scanner.next();
					System.out.println("Enter Passenger age");
					int age=scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter Passenger Unique id");
					int uid=scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter number of luggage");
					double luggage=scanner.nextDouble();
					passenger.setPassengerName(name);
					passenger.setPassengerAge(age);
					passenger.setPassengerUIN(uid);
					passenger.setLuggage(luggage);
					passenger.setPnrNumber(pnr);
					
					listofpassenger1.add(passenger);
					
				}
				double ticketcost=numofpassenger*2500.0;
				
				booking=new Booking();
				booking.setUserId(user3);
				booking.setBookingDate(localdate1);
				booking.setFlight(flight3);
				booking.setTicketCost(ticketcost);
				booking.setNoOfPassengers(numofpassenger);
				booking.setPassengerList(listofpassenger1);
				
					Booking booking1=bookingservice.addBooking(booking);
					int bookingid=booking1.getBookingId();
					System.out.println("Booking id "+bookingid);
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
				try
				{
				System.out.println("Enter bookingid to get details of that booking");
				int bookingid=scanner.nextInt();
				scanner.nextLine();
					List<Booking> list2=bookingservice.viewBooking(bookingid);
					for(Booking bookinglist: list2)
					{
						User user=bookinglist.getUserId();
						LocalDate localdate=bookinglist.getBookingDate();
						double ticketcost=bookinglist.getTicketCost();
						Flight flight=bookinglist.getFlight();
						int numofpassenger=bookinglist.getNoOfPassengers();
						System.out.println("Bookingid:"+bookingid+" ,userId:"+user+" ,Date:"+localdate+" ,Flight:"+flight+" ,Ticket cost="+ticketcost+" ,Number of Passengers"+numofpassenger);
					}
				}
				catch(BookingException e)
				{
					System.err.println("bookingid not found");
				}
				catch(InputMismatchException e)
				{
					
					System.err.println("Booking id should contain 4 digits");
					
				}
				break;
				
			case 3:
				System.out.println("Details of all the bookings");
				try
				{
					List<Booking> listall=bookingservice.viewBooking();
					for(Booking list3: listall)
					{
						int bookingid1=list3.getBookingId();
						User user=list3.getUserId();
						LocalDate localdate=list3.getBookingDate();
						double ticketcost=list3.getTicketCost();
						Flight flight=list3.getFlight();
						int numofpassenger=list3.getNoOfPassengers();
						List<Passenger> listpassenger=list3.getPassengerList();
						System.out.println("Bookingid:"+bookingid1+" ,userId:"+user+" ,Date:"+localdate+" ,Flight:"+flight+" ,Ticket Cost="+ticketcost+" ,Number of Passengers:"+numofpassenger+" ,List of Passenger"+listpassenger);
					}
				}
				catch(BookingException e)
				{
					System.err.println(e.getMessage());
				}
				break;
				
			case 4:
				try
				{
				System.out.println("Enter Bookingid whose booking is to be deleted");
				int bookingid4=scanner.nextInt();
				scanner.nextLine();
				
					bookingservice.deleteBooking(bookingid4);
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
		
}
