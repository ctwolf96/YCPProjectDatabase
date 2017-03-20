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
	private String title;
	private String startTime;
	private String numStudents;
	private boolean isFunded;
	private boolean hardware;
	private boolean software;
	
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

	public String getNumStudents() {
		return numStudents;
	}

	public void setNumStudents(String numStudents) {
		this.numStudents = numStudents;
	}

	public boolean isFunded() {
		return isFunded;
	}

	public void setFunded(boolean isFunded) {
		this.isFunded = isFunded;
	}

	public boolean isHardware() {
		return hardware;
	}

	public void setHardware(boolean hardware) {
		this.hardware = hardware;
	}

	public boolean isSoftware() {
		return software;
	}

	public void setSoftware(boolean software) {
		this.software = software;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
