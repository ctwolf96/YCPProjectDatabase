package edu.ycp.cs320.cspath1.project;

import java.util.ArrayList;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.user.User;

public class PastProject extends Project {
	private int project_id_copy_5;
	private int project_id_copy_6;
	private String deadline;
	private double cost;
	private double budget;
	private int numStudents;
	private ArrayList<MajorType> majors;
	private ArrayList<ClassType> classes;
	private boolean isFunded;
	
	//Constructor
	public PastProject() {
		
	}
	
	//Setters
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	
	//Getters
	
	public String getDeadline() {
		return deadline;
	}
	public double getCost() {
		return cost;
	}
	public double getBudget() {
		return budget;
	}
	public int getNumStudents() {
		return numStudents;
	}
	
	//Methods
	
	
	public void markComplete() {
		//move to past project
	}

	public int getProject_id_copy_5() {
		return project_id_copy_5;
	}

	public void setProject_id_copy_5(int project_id_copy_5) {
		this.project_id_copy_5 = project_id_copy_5;
	}

	public int getProject_id_copy_6() {
		return project_id_copy_6;
	}

	public void setProject_id_copy_6(int project_id_copy_6) {
		this.project_id_copy_6 = project_id_copy_6;
	}

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

	public boolean isFunded() {
		return isFunded;
	}

	public void setFunded(boolean isFunded) {
		this.isFunded = isFunded;
	}

}
