package edu.ycp.cs320.cspath1.project;

import edu.ycp.cs320.cspath1.user.User;

public class Project {
	private User creator;
	private String title;
	private String description;
	
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
	
	//Methods
	// Add to database and check all fields are set
	public void ProjectCreation() {
		
	}
	public void edit() {
		
	}
}
