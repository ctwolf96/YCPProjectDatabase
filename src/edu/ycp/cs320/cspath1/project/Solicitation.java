package edu.ycp.cs320.cspath1.project;

import java.util.ArrayList;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;

public class Solicitation extends Project {
	private ArrayList<MajorType> majors;
	private ArrayList<ClassType> classes;
	private String duration;
	private String startTime;
	private int numStudents;
	private double cost;
	
	public ArrayList<MajorType> getMajors() {
		return majors;
	}
	public void setMajors(ArrayList<MajorType> majors) {
		this.majors = majors;
	}
	
	public ArrayList<ClassType> getClasses() {
		return classes;
	}
	
	public void setClasses(ArrayList<ClassType> classes) {
		this.classes = classes;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public int getNumStudents() {
		return numStudents;
	}
	
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}

}
