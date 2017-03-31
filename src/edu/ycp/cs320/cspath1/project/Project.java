package edu.ycp.cs320.cspath1.project;

public class Project {
	
	private int UserID;
	private int ProjectID;

	
	//Constructor
	public Project() {
		
	}
	
	//Setters
	public void setUserID(int userID) {
		UserID = userID;
	}
	
	//Getters
	
	public int getUserID() {
		return UserID;
	}
	
	//Methods
	// Add to database and check all fields are set
	public void projectCreation() {
		
	}
	public void edit() {

	}

	public int getProjectID() {
		return ProjectID;
	}

	public void setProjectID(int projectID) {
		ProjectID = projectID;

	}
}
