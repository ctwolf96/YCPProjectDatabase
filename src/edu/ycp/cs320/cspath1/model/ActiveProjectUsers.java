package edu.ycp.cs320.cspath1.model;

public class ActiveProjectUsers {
	private int activeProjectID;
	private int userID;
	
	public ActiveProjectUsers(){
		
	}
	
	public int getActiveProjectID() {
		return activeProjectID;
	}
	public void setActiveProjectID(int activeProjectID) {
		this.activeProjectID = activeProjectID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
