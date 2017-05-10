package edu.ycp.cs320.cspath1.model;

import java.util.ArrayList;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.SolicitationType;
import edu.ycp.cs320.cspath1.user.User;

public class ProjectModel {
	private User creator;
	private int project_id;
	private ArrayList <MajorType> majors;
	private ArrayList <ClassType> classes;
	private String description;
	private int duration;
	private String title;
	private double cost;
	private String startTime;
	private int numStudents;
	private boolean isFunded;
	private SolicitationType solicitationType;
	
	
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
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

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public SolicitationType getSolicitationType() {
		return solicitationType;
	}

	public void setSolicitationType(SolicitationType solicitationType) {
		this.solicitationType = solicitationType;
	}
	
	
}
