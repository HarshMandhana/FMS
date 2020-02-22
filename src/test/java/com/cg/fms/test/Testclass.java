package com.cg.fms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.cg.fms.bean.Booking;
import com.cg.fms.bean.Flight;
import com.cg.fms.bean.User;
import com.cg.fms.dao.BookingDao;
import com.cg.fms.dao.BookingDaoImpl;
import com.cg.fms.exception.BookingException;

class Testclass {

	BookingDao bookingdao=null;
	List<Booking> list;
	
	
	@Before
	public void addBooking() 
	{/*
		User u1=new User("User",100,"saiteja","saiteja123",1254,"saiteja@gmail.com");
		Flight f1= new Flight(1001,"BUSSINESS","INS",100);
		Booking booking=new Booking(5658,u1,LocalDate.now(),5000.0,f1,2);
		list=new ArrayList<Booking>();
		bookingdao=new BookingDaoImpl();
		list.add(booking);*/
	}
		
	@Test
	public void testviewBooking(int bookingid) throws BookingException{
		List<Booking> b=bookingdao.viewBooking(5658);
		assertEquals(list, b);
	}

}
