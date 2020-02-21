package com.cg.fms.bean;

public class User {
	
	private String userType;
	private int userId;
	private String userName;
	private String password;
	private int userPhone;
	private String userEmail;
	
	public User(String userType, int userId, String userName, String password, int userPhone,
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
	public int getUserId() {
	return userId;
	}
	public void setUserId(int userId) {
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
	public int getUserPhone() {
	return userPhone;
	}
	public void setUserPhone(int userPhone) {
	this.userPhone = userPhone;
	}
	public String getUserEmail() {
	return userEmail;
	}
	public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "User [userType=" + userType + ", userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", userPhone=" + userPhone + ", userEmail=" + userEmail + "]";
	}

}
