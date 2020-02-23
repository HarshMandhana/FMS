package com.cg.fms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.fms.bean.Booking;
import com.cg.fms.bean.Flight;
import com.cg.fms.bean.Passenger;
import com.cg.fms.bean.User;
import com.cg.fms.dao.BookingDao;
import com.cg.fms.dao.BookingDaoImpl;
import com.cg.fms.exception.BookingException;

class test {
	
	BookingDao bookingdao= new BookingDaoImpl();
	

	@Test
	public void viewBooking()  throws BookingException
	{

		bookingdao =new BookingDaoImpl();
		List<Booking> bookinglist=new ArrayList<Booking>();
		User user=new User("User",103,"harsh","harsh1",1254,"harsh@gmail.com");
		Passenger passenger1=new Passenger(5478,"yfr",54,9764,2.0);
		Passenger passenger2=new Passenger(5478,"hgf",45,9764,2.0);
		
		List<Passenger> list=new ArrayList<Passenger>();
		list.add(passenger1);
		list.add(passenger2);
		
		Flight flight= new Flight(1001,"BUSSINESS","INS",100);
		
		Booking booking=new Booking(5256,user,LocalDate.now(),list,5000.0,flight,2);
		bookingdao.addBooking(booking);
		
		
		bookinglist=bookingdao.viewBooking(5256);
		int numofpassengers=bookinglist.stream().map(p->p.getNoOfPassengers()).findFirst().get();
		assertEquals(2,numofpassengers);

	}
	
	@Test
	public void deleteBooking()  throws BookingException{
		
		bookingdao =new BookingDaoImpl();
		List<Booking> bookinglist=new ArrayList<Booking>();
		User user=new User("User",103,"harsh","harsh1",1254,"harsh@gmail.com");
		Passenger passenger1=new Passenger(5478,"yfr",54,9764,2.0);
		Passenger passenger2=new Passenger(5478,"hgf",45,9764,2.0);
		
		List<Passenger> list=new ArrayList<Passenger>();
		list.add(passenger1);
		list.add(passenger2);
		Flight flight= new Flight(1001,"BUSSINESS","INS",100);
		
		Booking booking=new Booking(5256,user,LocalDate.now(),list,5000.0,flight,2);
		bookingdao.addBooking(booking);
		
		bookingdao.deleteBooking(5256);
		
		boolean flag=bookinglist.stream().anyMatch(p->p.getBookingId()==5256);
		
		assertEquals(false,flag);
		
	}
	 
	
}