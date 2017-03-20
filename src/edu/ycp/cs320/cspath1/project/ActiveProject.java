package edu.ycp.cs320.cspath1.project;

import java.util.ArrayList;

import edu.ycp.cs320.cspath1.user.User;

public class ActiveProject extends Project {
	private ArrayList<User> members;
	private User mentor;
	private String deadline;
	private ArrayList<String> tasks;
	private double cost;
	private double budget;
	private ArrayList<Project> prevVersions;
	private Project original;
	
	//Constructor
	public ActiveProject() {
		
	}
	
	//Setters
	public void setMentor(User mentor) {
		this.mentor = mentor;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	//Getters
	public User getMentor() {
		return mentor;
	}
	public String getDeadline() {
		return deadline;
	}
	public double getCost() {
		return cost;
	}
	public double getBudget() {
		return budget;
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
