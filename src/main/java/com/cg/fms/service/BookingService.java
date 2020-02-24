package com.cg.fms.service;

import java.util.List;
import com.cg.fms.bean.Booking;
import com.cg.fms.bean.Passenger;
import com.cg.fms.exception.BookingException;

public interface BookingService {
	
	public Booking addBooking(Booking booking) throws BookingException;
	
	public Booking modifyBooking(Booking booking,int noofpassengers) throws BookingException;
	
	public List<Booking> viewBooking(int bookingid) throws BookingException;
	
	public List<Booking> viewBooking() throws BookingException;
	
	public void deleteBooking(int bookingid) throws BookingException;
	
	public void validateBooking(Booking booking) throws BookingException;
	
	public void validatePassenger(Passenger passenger) throws BookingException;
	
	public void validateBookingId(int bookingid) throws BookingException;
	
	public void validatepnrnumber(int pnrnumber) throws BookingException;

}
