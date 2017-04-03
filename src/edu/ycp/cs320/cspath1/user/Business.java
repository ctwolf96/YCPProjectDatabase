package edu.ycp.cs320.cspath1.user;

public class Business extends User {
	private String name;
	private String number;
	private String address;
	
	
	//Constructor
	public Business() {
		
	}
	
	//Setters
	public void setNumber(String number) {
		this.number = number;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Getters
	public String getNumber() {
		return number;
	}
	public String getAddress() {
		return address;
	}
	public String getName() {
		return name;
	}
	
	//Methods
	public void proposeProject() {
		
	}
}
