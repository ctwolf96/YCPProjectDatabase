package edu.ycp.cs320.cspath1.user;

import edu.ycp.cs320.cspath1.enums.UserType;

public abstract class User {
	private String name;
	private String username;
	private String password;
	private String email;
	private UserType usertype;
	private int userID;
	
	//Setters
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	//Getters
	public String getUsername() {
		return username;
	}
	public String getPassword() { 
		return password;
	}
	public String getEmail() {
		return email;
	}
	public UserType getUsertype() {
		return usertype;
	}
	public int getUserID() {
		return userID;
	}
	
	//Methods
	public void login() {
		
	}
	public void logout() {
		
	}
	public void editInfo() {
		
	}
	public void verifyCred() {
		
	}
	public void createAcct() {
		
	}
	public abstract void proposeProject();

}
