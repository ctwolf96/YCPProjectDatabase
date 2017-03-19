package edu.ycp.cs320.cspath1.model;

import java.util.ArrayList;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.user.User;

public class ProjectModel {
	private User creator;
	private ArrayList <MajorType> majors;
	private ArrayList <ClassType> classes;
	private String description;
	private String duration;
	private int numStudents;
	private boolean isFunded;
	
	public User getCreator() {
		return creator;
	}
	
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public ArrayList <MajorType> getMajors() {
		return majors;
	}
	
	public void setMajors(ArrayList <MajorType> majors) {
		this.majors = majors;
	}
	
	public ArrayList <ClassType> getClasses() {
		return classes;
	}
	
	public void setClasses(ArrayList <ClassType> classes) {
		this.classes = classes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getNumStudents() {
		return numStudents;
	}

	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}

	public boolean isFunded() {
		return isFunded;
	}

	public void setFunded(boolean isFunded) {
		this.isFunded = isFunded;
	}
	
	
}
