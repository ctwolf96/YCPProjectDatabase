package edu.ycp.cs320.cspath1.user;

import java.util.ArrayList;

import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.project.Project;

public class Faculty extends User{
	//Should make just one arraylist of majortype for disciplines unless we want to get specific such as classes taught
	private MajorType major;
	private ArrayList<String> disciplines;
	private ArrayList<Project> activeProjects;
	private ArrayList<Project> pastProjects;

	//Constructor
	public Faculty() {
		
	}
	
	//Setters
	public void setMajor(MajorType major) {
		this.major = major;
	}
	
	//Getters
	public MajorType getMajor() {
		return major;
	}
	
	//Methods
	public void addDiscipline(String discipline) {
		disciplines.add(discipline);
	}
	public void addActiveProject(Project project) {
		activeProjects.add(project);
	}
	public void moveActiveToPast(int project) {
		pastProjects.add(activeProjects.remove(project));
	}
	public void proposeProject() {
		
	}
	public void approveProject() {
			
	}
}
