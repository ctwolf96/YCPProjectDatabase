package edu.ycp.cs320.cspath1.project;

import java.util.ArrayList;

public class PastProject extends Project {
	private String deadline;
	private ArrayList<String> tasks;
	private double cost;
	private double budget;
	private ArrayList<Project> prevVersions;
	private Project original;
	private int numStudents;
	
	//Constructor
	public PastProject() {
		
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public ArrayList<String> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<String> tasks) {
		this.tasks = tasks;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public ArrayList<Project> getPrevVersions() {
		return prevVersions;
	}

	public void setPrevVersions(ArrayList<Project> prevVersions) {
		this.prevVersions = prevVersions;
	}

	public Project getOriginal() {
		return original;
	}

	public void setOriginal(Project original) {
		this.original = original;
	}

	public int getNumStudents() {
		return numStudents;
	}

	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}

}
