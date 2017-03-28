package edu.ycp.cs320.cspath1.project;

import edu.ycp.cs320.cspath1.user.User;

public class Project {
	private User creator;
	private int UserID;
	private String title;
	private String description;
	
	//Constructor
	public Project() {
		
	}
	
	//Setters
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	//Getters
	public User getCreator() {
		return creator;
	}
	
	//Methods
	public void ProjectCreation() {
		
	}
	public void edit() {
		
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
