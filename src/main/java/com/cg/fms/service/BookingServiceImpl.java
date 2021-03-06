package com.cg.fms.service;

import java.util.List;
import java.util.Random;

import com.cg.fms.bean.Booking;
import com.cg.fms.bean.Passenger;
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
		
		boolean flag=false;
		String numberofpassengers=String.valueOf(booking.getNoOfPassengers());
		flag=numberofpassengers.matches("[1-6]");
		
		if(flag==false)
		{
			throw new BookingException("passengers should not be zero and not more than six");
		}
		
		Random random=new Random();
		int bookingid=random.nextInt(8999)+1000;
		booking.setBookingId(bookingid);
		
		return bookingdao.addBooking(booking);
	}
	
	@Override
	public void validateBookingId(int bookingid) throws BookingException
	{
		boolean flag=false;
		String bookingid1=String.valueOf(bookingid);
		flag=bookingid1.matches("[1-9][0-9]{3}");
		if(flag==false)
		{
			throw new BookingException("Booking Id not Found");
		}
	}
	
	public void validatepnrnumber(int pnrnumber) throws BookingException
	{
		boolean flag=false;
		String pnrNumber=String.valueOf(pnrnumber);
		flag=pnrNumber.matches("[1-9][0-9]{3}");
		if(flag==false)
		{
			throw new BookingException("Booking Id not Found");
		}
	}

	@Override
	public Booking modifyBooking(Booking booking,int noofpassengers)  throws BookingException{
		
		return bookingdao.modifyBooking(booking,noofpassengers);
	}

	@Override
	public List<Booking> viewBooking(int bookingid)  throws BookingException{

		boolean flag=false;
		String bookingid1=String.valueOf(bookingid);
		flag=bookingid1.matches("[1-9][0-9]{3}");
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
		String bookingid2=String.valueOf(bookingid);
		flag=bookingid2.matches("[1-9][0-9]{3}");
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
		String bookingid3=String.valueOf(booking.getBookingId());
		flag=bookingid3.matches("[1-9](0-9){3}");
		if(flag==false)
		{
			throw new BookingException("Invalid booking id");
		}
		
	}

	@Override
	public void validatePassenger(Passenger passenger)  throws BookingException{
		
		boolean flag=false;
		String pnrnumber=String.valueOf(passenger.getPnrNumber());
		flag=pnrnumber.matches("[1-9](0-9){3}");
		if(flag==false)
		{
			throw new BookingException("Invalid Passenger pnrNumber");
		}
		
	}
	
}
