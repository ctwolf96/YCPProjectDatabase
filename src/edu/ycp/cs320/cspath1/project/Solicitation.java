package edu.ycp.cs320.cspath1.project;

import java.util.ArrayList;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;

public class Solicitation extends Project {
	private ArrayList<MajorType> majors;
	private ArrayList<ClassType> classes;
	private String duration;
	private String startTime;
	private String endTime;
	private int numStudents;
	private double cost;
	
	//Constructor
	public Solicitation() {
		
	}
	
	//Setters
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	//Getters
	public String getDuration() {
		return duration;
	}
	public String getStartTime() {
		return startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public int getNumStudents() {
		return numStudents;
	}
	public double getCost() {
		return cost;
	}
	
	//Methods
	public void addMajor(MajorType major) {
		majors.add(major);
	}
	public void addClass(ClassType classtype) {
		classes.add(classtype);
	}
	//Match to proposed project
	public void match() {
		
	}
	public void makeActive() {
		
	}

}
