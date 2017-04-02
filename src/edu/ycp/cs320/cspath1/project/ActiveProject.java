package edu.ycp.cs320.cspath1.project;

import java.util.ArrayList;

import edu.ycp.cs320.cspath1.user.User;

public class ActiveProject extends Project {
	private ArrayList<User> members;
	private String deadline;
	private ArrayList<String> tasks;
	private double cost;
	private double budget;
	private ArrayList<Project> prevVersions;
	private Project original;
	private int numStudents;
	
	//Constructor
	public ActiveProject() {
		
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
	public void addMember(User user) {
		members.add(user);
	}
	public void addTask(String task) {
		tasks.add(task);
	}
	public void markComplete() {
		//move to past project
	}
}
