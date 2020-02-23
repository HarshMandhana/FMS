package com.cg.fms.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.fms.bean.Airport;
import com.cg.fms.bean.Booking;
import com.cg.fms.bean.DateTime;
import com.cg.fms.bean.Flight;
import com.cg.fms.bean.Passenger;
import com.cg.fms.bean.Schedule;
import com.cg.fms.bean.ScheduledFlight;
import com.cg.fms.bean.User;
import com.cg.fms.exception.BookingException;

public class BookingDaoImpl implements BookingDao{
	
	private List<Booking> bookingList;
	private List<ScheduledFlight>  listOfScheduleFlight;
	private List<Passenger> passengerlist;
	
	public BookingDaoImpl()
	{
		bookingList=new ArrayList<Booking>();
		listOfScheduleFlight=new ArrayList<ScheduledFlight>();
		passengerlist=new ArrayList<Passenger>();
		
		Flight flight1= new Flight(1001,"BUSSINESS","INS",100);
		Flight flight2= new Flight(1002,"ECONOMY","INS",80);
		Flight flight3= new Flight(1003,"FIRSTCLASS","INS",50);
		
		Airport scheduleairport1= new Airport("Rajiv Gandhi International Airport","HYD","Hyderabad");
		Airport scheduleairport2= new Airport("chathrapathi Shivaji International Airport","MUM","Mumbai");
		Airport scheduleairport3= new Airport("Kempoguda Airport","BEN","Bengaluru");
		
		Airport departureairport1= new Airport("Rajiv Gandhi International Airport","HYD","Hyderabad");
		Airport departureairport2= new Airport("chathrapathi Shivaji International Airport","MUM","Mumbai");
		Airport departureairport3= new Airport("Kempoguda Airport","BEN","Bengaluru");
		
		DateTime date1 = new DateTime("02-03-2020","13:00");
		DateTime date2 = new DateTime("03-03-2020","14:00");
		DateTime date3 = new DateTime("04-03-2020","14:00");
		DateTime date4 = new DateTime("04-03-2020","18:00");
		DateTime date5 = new DateTime("01-03-2020","01:00");
		DateTime date6 = new DateTime("01-03-2020","14:00");
		
		Schedule sch1 = new Schedule(scheduleairport1,departureairport1,date1,date2);
		Schedule sch2 = new Schedule(scheduleairport2,departureairport2,date3,date4);
		Schedule sch3 = new Schedule(scheduleairport3,departureairport3,date5,date6);
		
		ScheduledFlight schd1 = new ScheduledFlight(flight1,100,sch1);
		ScheduledFlight schd2 = new ScheduledFlight(flight2,80,sch2);
		ScheduledFlight schd3 = new ScheduledFlight(flight3,50,sch3);
		
		listOfScheduleFlight.add(schd1);
		listOfScheduleFlight.add(schd2);
		listOfScheduleFlight.add(schd3);
		
		User user1=new User("User",100,"saiteja","saiteja123",1254,"saiteja@gmail.com");
		User user2=new User("User",101,"naveen","naveen12",5469,"naveen123@gmail.com");
		User user3=new User("User",103,"harsh","harsh1",1254,"harsh@gmail.com");
		
		Passenger passenger1=new Passenger(5478,"yfr",54,9764,2.0);
		Passenger passenger2=new Passenger(5478,"hgf",45,9764,2.0);
		
		List<Passenger> list=new ArrayList<Passenger>();
		list.add(passenger1);
		list.add(passenger2);
		
		Passenger passenger3=new Passenger(5445,"fd",12,9764,2.0);
		Passenger passenger4=new Passenger(5445,"gfrs",68,9764,2.0);
		Passenger passenger5=new Passenger(5445,"hrs",45,9764,2.0);
		
		List<Passenger> list1=new ArrayList<Passenger>();
		list1.add(passenger3);
		list1.add(passenger4);
		list1.add(passenger5);
		
		Booking booking1=new Booking(5658,user1,LocalDate.now(),list,5000.0,flight1,2);
		Booking booking2=new Booking(5487,user2,LocalDate.now(),list1,7500.0,flight2,3);
		
		bookingList.add(booking1);
		bookingList.add(booking2);
		
	}

	@Override
	public Booking addBooking(Booking booking) throws BookingException{
		
		
		if(booking != null)
		{
		    boolean flag = listOfScheduleFlight.stream().anyMatch(p ->p.getFlight().getFlightNumber() == booking.getFlight().getFlightNumber() && p.getAvailableSeats() >= booking.getNoOfPassengers());
		    if( flag )
			{
				bookingList.add(booking);
				List<ScheduledFlight> list=listOfScheduleFlight.stream().filter(p ->p.getFlight().getFlightNumber() == booking.getFlight().getFlightNumber()?true:false).collect(Collectors.toList());
				for(ScheduledFlight flightlist :list)
				{
					flightlist.setAvailableSeats(flightlist.getAvailableSeats()-booking.getNoOfPassengers());
				}
			}
		}
		else
		{
			throw new BookingException("Booking details cannot be null");
		}
		return booking;
		
	}

	@Override
	public Booking modifyBooking(Booking booking,int noofpassengers) throws BookingException{
		
		Boolean flag=bookingList.stream().anyMatch(p->p.getBookingId()==booking.getBookingId());
		if(flag==true)
		{
			
			booking.setNoOfPassengers(noofpassengers);
			
		} 
		else
		{
			throw new BookingException("BookingId Not Found");
		}
		return booking;
	}

	@Override
	public List<Booking> viewBooking(int bookingid)  throws BookingException{
		
		boolean flag=bookingList.stream().anyMatch(p->p.getBookingId()==bookingid);
		if(flag==true)
		{
		List<Booking> list=bookingList.stream().filter(p->p.getBookingId()==bookingid?true:false).collect(Collectors.toList());
		return list;
		}
		else
		{
			throw new BookingException("Bookingid can't be zero");
		}
	}

	@Override
	public List<Booking> viewBooking()  throws BookingException{
		
		List<Booking> list=bookingList.stream().collect(Collectors.toList());
		if(list!=null)
		{
			return list;
		}
		else
		{
			throw new BookingException("Booking list is empty");
		}
		
	}

	@Override
	public void deleteBooking(int bookingid)  throws BookingException{
		
		boolean flag=bookingList.stream().anyMatch(p->p.getBookingId()==bookingid);
		if(flag==true)
		{
			Booking booking=bookingList.stream().filter(p->p.getBookingId()==bookingid?true:false).findFirst().get();
				bookingList.remove(booking);
		}
		else
		{
			throw new BookingException("Bookingid to be deleted not found");
		}
	}

}
