package com.cg.fms.dao;

import java.util.List;

import com.cg.fms.bean.Booking;
import com.cg.fms.exception.BookingException;

public interface BookingDao {
	
	List<Booking> bookingList=null;
	
	public Booking addBooking(Booking booking) throws BookingException;
	
	public Booking modifyBooking(Booking booking) throws BookingException;
	
	public List<Booking> viewBooking(int bookingid) throws BookingException;
	
	public List<Booking> viewBooking() throws BookingException;
	
	public void deleteBooking(int bookingid) throws BookingException;
	
}
