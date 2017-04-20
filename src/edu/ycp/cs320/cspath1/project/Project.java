package edu.ycp.cs320.cspath1.project;

import edu.ycp.cs320.cspath1.enums.ProjectType;

public class Project {
	// How are we linking a project with a user? At first I was thinking of using an arraylist of user id's but that only applies
		// to active projects who have members. A proposal/solicitation will only have one user (creator) to link a project and user together
		// I guess what I'm getting at is should we link a project and user by creator and then worry about linking the members of an active
		// project later
	private String title;
	private String description;
	private String start;
	private int duration; //units have yet to be determined (semesters, months, days)
	private int userID; //Creator as well as mentor
	private int projectID;
	private ProjectType projectType;
	
	//Setters
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}
	
	//Getters
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getStart() {
		return start;
	}
	public int getDuration() {
		return duration;
	}
	public int getUserID() {
		return userID;
	}
	public int getProjectID() {
		return projectID;
	}
	public ProjectType getProjectType() {
		return projectType;
	}
	
	//Methods
	// Add to database and check all fields are set
	public void projectCreation() {
		
	}
	public void edit() {
	}
}

