package com.cg.fms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.cg.fms.bean.Booking;
import com.cg.fms.bean.Flight;
import com.cg.fms.bean.Passenger;
import com.cg.fms.bean.User;
import com.cg.fms.dao.BookingDao;
import com.cg.fms.dao.BookingDaoImpl;
import com.cg.fms.exception.BookingException;

class test {
	BookingDao bookingdao=null;
	List<Booking> bookinglist=new ArrayList<Booking>();
	Booking booking=new Booking();

	public void viewBooking(int bookingid)  throws BookingException{
		
		bookingdao= new BookingDaoImpl();
	}

	@Test
	void test() {

		/*User u1=null;
		Flight f1=null;
		Passenger passenger1=new Passenger(5478,"yfr",54,9764,2.0);
		Passenger passenger2=new Passenger(5478,"hgf",45,9764,2.0);
		List<Passenger> list=new ArrayList<Passenger>();
		list.add(passenger1);
		list.add(passenger2);
		Booking b1=new Booking(5658,u1,LocalDate.now(),list,5000.0,f1,2);
		assertTrue(b1.getBookingId()>0);*/

}
	
}