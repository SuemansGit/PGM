package com.pga.ro;

import com.pga.eo.AccountEO;
import com.pga.eo.RegisteredUserEO;

public class RegisteredUserRO {

	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String password;
	
	public RegisteredUserRO(RegisteredUserEO usereo){
		super();
		this.userId=usereo.getUserId();
		this.firstName=usereo.getFirstName();
		this.lastName=usereo.getLastName();
		this.email=usereo.getEmailId();
		this.mobile=usereo.getMobile();
		this.password=usereo.getPassword();
	}
	
	public RegisteredUserRO(String firstName,String lastName,String email,String mobile,String password){		
		super();
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.mobile=mobile;
		this.password=password;		
	}
	
	public RegisteredUserRO(){
		
	}
	public RegisteredUserEO getEntityObject() {
		RegisteredUserEO user = new RegisteredUserEO();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailId(email);
		user.setPassword(password);
		user.setMobile(mobile);
		return user;

	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "RegisteredUserRO [userId=" + userId + ", firstName="
				+ firstName + ", lastname=" + lastName + ", email=" + email
				+ ",password=" + password + ", mobileNo=" + mobile + "]";

	}
	
	
}
