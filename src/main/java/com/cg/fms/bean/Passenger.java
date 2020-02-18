package com.cg.fms.bean;

import java.math.BigInteger;

public class Passenger {
	
	private BigInteger pnrNumber;
	private String passengerName;
	private Integer passengerAge;
	private BigInteger passengerUIN;
	private double luggage;
	public Passenger(BigInteger pnrNumber, String passengerName, Integer passengerAge, BigInteger passengerUIN,
	double luggage) {
	super();
	this.pnrNumber = pnrNumber;
	this.passengerName = passengerName;
	this.passengerAge = passengerAge;
	this.passengerUIN = passengerUIN;
	this.luggage = luggage;
	}
	public Passenger() {
	super();
	}
	public BigInteger getPnrNumber() {
	return pnrNumber;
	}
	public void setPnrNumber(BigInteger pnrNumber) {
	this.pnrNumber = pnrNumber;
	}
	public String getPassengerName() {
	return passengerName;
	}
	public void setPassengerName(String passengerName) {
	this.passengerName = passengerName;
	}
	public Integer getPassengerAge() {
	return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
	this.passengerAge = passengerAge;
	}
	public BigInteger getPassengerUIN() {
	return passengerUIN;
	}
	public void setPassengerUIN(BigInteger passengerUIN) {
	this.passengerUIN = passengerUIN;
	}
	public double getLuggage() {
	return luggage;
	}
	public void setLuggage(double luggage) {
	this.luggage = luggage;
	}

}
