package com.cg.fms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import com.cg.fms.bean.Booking;
import com.cg.fms.bean.Passenger;
import com.cg.fms.bean.User;
import com.cg.fms.dao.BookingDao;
import com.cg.fms.dao.BookingDaoImpl;
import com.cg.fms.exception.BookingException;

public class BookingServiceImpl implements BookingService{
	
	private BookingDao bookingdao;
	
	public BookingServiceImpl()
	{
		bookingdao=new BookingDaoImpl();
	}

	@Override
	public Booking addBooking(Booking booking)  throws BookingException{
		
		boolean flag=false,flag1=false;
		String num=String.valueOf(booking.getNoOfPassengers());
		flag=num.matches("[1-6]");
		
		if(flag==false)
		{
			throw new BookingException("passengers should not be zero and not more than six");
		}
		
		Random random=new Random();
		int id=random.nextInt(8999)+1000;
		booking.setBookingId(id);
		
		return bookingdao.addBooking(booking);
	}

	@Override
	public Booking modifyBooking(Booking booking,int noofpassengers)  throws BookingException{

		boolean flag=false;
		String num=String.valueOf(booking.getNoOfPassengers());
		
		flag=num.matches("[1-6]");
		
		if(flag==false)
		{
			throw new BookingException("Number of passengers should be not be zero and not more than 6");
		}
		
		return bookingdao.modifyBooking(booking,noofpassengers);
	}

	@Override
	public List<Booking> viewBooking(int bookingid)  throws BookingException{

		boolean flag=false;
		String num=String.valueOf(bookingid);
		flag=num.matches("[1-9][0-9]{3}");
		if(flag==false)
		{
			throw new BookingException("Invalid booking id");
		}
		
		return bookingdao.viewBooking(bookingid);
	}

	@Override
	public List<Booking> viewBooking()  throws BookingException{
		
		return bookingdao.viewBooking();
	}

	@Override
	public void deleteBooking(int bookingid)  throws BookingException{
		
		boolean flag=false;
		String num=String.valueOf(bookingid);
		flag=num.matches("[1-9][0-9]{3}");
		if(flag==false)
		{
			throw new BookingException("Invalid booking id");
		}
		else
		{
			bookingdao.deleteBooking(bookingid);
		}
	}

	@Override
	public void validateBooking(Booking booking)  throws BookingException{

		boolean flag=false;
		String id=String.valueOf(booking.getBookingId());
		flag=id.matches("[1-9](0-9){3}");
		if(flag==false)
		{
			throw new BookingException("Invalid booking id");
		}
		
	}

	@Override
	public void validatePassenger(Passenger passenger)  throws BookingException{
		
		boolean flag=false;
		String pnrnum=String.valueOf(passenger.getPnrNumber());
		flag=pnrnum.matches("[1-9](0-9){3}");
		if(flag==false)
		{
			throw new BookingException("Invalid Passenger pnrNumber");
		}
		
	}
	
}
