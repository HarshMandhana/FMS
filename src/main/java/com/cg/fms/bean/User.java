package com.cg.fms.bean;

import java.math.BigInteger;

public class User {
	
	private String userType;
	private BigInteger userId;
	private String userName;
	private String password;
	private BigInteger userPhone;
	private String userEmail;
	
	public User(String userType, BigInteger userId, String userName, String password, BigInteger userPhone,
	String userEmail) {
	super();
	this.userType = userType;
	this.userId = userId;
	this.userName = userName;
	this.password = password;
	this.userPhone = userPhone;
	this.userEmail = userEmail;
	}
	
	public User() {
	super();
	}
	public String getUserType() {
	return userType;
	}
	public void setUserType(String userType) {
	this.userType = userType;
	}
	public BigInteger getUserId() {
	return userId;
	}
	public void setUserId(BigInteger userId) {
	this.userId = userId;
	}
	public String getUserName() {
	return userName;
	}
	public void setUserName(String userName) {
	this.userName = userName;
	}
	public String getPassword() {
	return password;
	}
	public void setPassword(String password) {
	this.password = password;
	}
	public BigInteger getUserPhone() {
	return userPhone;
	}
	public void setUserPhone(BigInteger userPhone) {
	this.userPhone = userPhone;
	}
	public String getUserEmail() {
	return userEmail;
	}
	public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
	}

}
