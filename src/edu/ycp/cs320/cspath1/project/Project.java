package edu.ycp.cs320.cspath1.project;

import edu.ycp.cs320.cspath1.user.User;
import java.util.ArrayList;

public class Project {
	// How are we linking a project with a user? At first I was thinking of using an arraylist of user id's but that only applies
	// to active projects who have members. A proposal/solicitation will only have one user (creator) to link a project and user together
	// I guess what I'm getting at is should we link a project and user by creator and then worry about linking the members of an active
	// project later
	private User creator;
	private String title;
	private String description;
	private int ProjectID;
	
	//Constructor
	public Project() {
		
	}
	
	//Setters
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
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
