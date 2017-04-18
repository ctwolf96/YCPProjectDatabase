package edu.ycp.cs320.cspath1.project;

import java.sql.Date;
import java.util.ArrayList;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;

public class Proposal extends Project {
	private ArrayList<MajorType> majors;
	private ArrayList<ClassType> classes;
	private Date deadline;
	private int numStudents;
	private double cost;
	private boolean isFunded;
	
	//Constructor
	public Proposal() {
		
	}
	
	//Setters
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setIsFunded(boolean isFunded) {
		this.isFunded = isFunded;
	}
	public void setMajors(ArrayList<MajorType> majors) {
		this.majors = majors;
	}
	public void setClasses(ArrayList<ClassType> classes) {
		this.classes = classes;
	}

	//Getters
	public Date getDeadline() {
		return deadline;
	}
	public int getNumStudents() {
		return numStudents;
	}
	public double getCost() {
		return cost;
	}
	public boolean getIsFunded() {
		return isFunded;
	}
	public ArrayList<MajorType> getMajors() {
		return majors;
	}
	public ArrayList<ClassType> getClasses() {
		return classes;
	}
	
	//Methods
	public void addMajor(MajorType major) {
		majors.add(major);
	}
	public void addClass(ClassType classtype) {
		classes.add(classtype);
	}
	//Match to solicited project
	public void match() {
		
	}
	public void makeActive() {
		
	}
}
