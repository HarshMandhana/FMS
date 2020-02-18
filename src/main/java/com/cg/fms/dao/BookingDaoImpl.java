package com.cg.fms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.fms.bean.Booking;
import com.cg.fms.exception.BookingException;

public class BookingDaoImpl implements BookingDao{
	
	private List<Booking> bookingList;
	
	public BookingDaoImpl()
	{
		bookingList=new ArrayList<Booking>();
	}

	@Override
	public Booking addBooking(Booking booking) throws BookingException{
		
		if(booking != null)
		{
		bookingList.add(booking);
		}
		else
		{
			throw new BookingException("Booking details cannot be null");
		}
		return booking;
		
	}

	@Override
	public Booking modifyBooking(Booking booking) throws BookingException{
		
		boolean flag=bookingList.contains(booking.getBookingId());
		if(flag==true)
		{
			
			booking.setNoOfPassengers(booking.getNoOfPassengers());
			/*booking.setBookingDate(booking.getBookingDate());
			booking.setFlight(booking.getFlight());
			booking.setUserId(booking.getUserId());
			booking.setTicketCost(booking.getTicketCost());*/
			
		} 
		else
		{
			throw new BookingException("BookingId Not Found");
		}
		return null;
	}

	@Override
	public List<Booking> viewBooking(int bookingid)  throws BookingException{
		List<Booking> list=new ArrayList<Booking>();
		Booking b=null;
		boolean flag=bookingList.contains(bookingid);
		if(flag==true)
		{
			int id=bookingList.indexOf(bookingid);
			b=bookingList.get(id);
			
		}
		else
		{
			throw new BookingException("BookingId does not exist");
		}
		list.add(b);
		return list;
	}

	@Override
	public List<Booking> viewBooking()  throws BookingException{
		
		for(int i=0;i<bookingList.size();i++)
		{
			
		}
		
		return null;
	}

	@Override
	public void deleteBooking(int bookingid)  throws BookingException{
		// TODO Auto-generated method stub
		
	}
	
	

}
