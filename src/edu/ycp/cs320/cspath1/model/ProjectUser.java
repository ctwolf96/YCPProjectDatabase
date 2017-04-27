package edu.ycp.cs320.cspath1.model;

public class ProjectUser {

	private int projectId;
	private int userId;
	
	public ProjectUser() {
		
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getProjectId() {
		return projectId;
	}
	
	public int getUserId() {
		return userId;
	}
}