package edu.ycp.cs320.cspath1.project;

import edu.ycp.cs320.cspath1.user.User;

public class Project {
	private User creator;
	private String title;
	private String description;
	private int UserID;
	private int ProjectID;
	
	//Constructor
	public Project() {

	}
	
	//Setters
	public void setUserID(int userID) {
		UserID = userID;
	}
	public void setProjectID(int projectID) {
		ProjectID = projectID;
	}
	
	//Getters

	public User getCreator() {
		return creator;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}

	public int getUserID() {
		return UserID;
	}
	public int getProjectID() {
		return ProjectID;
	}
	
	//Methods
	// Add to database and check all fields are set
	public void projectCreation() {
		
	}
	public void edit() {


	}

	
	}

