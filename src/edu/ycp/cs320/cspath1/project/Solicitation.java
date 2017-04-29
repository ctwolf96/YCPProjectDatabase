 package edu.ycp.cs320.cspath1.project;

import java.util.ArrayList;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.SolicitationType;

public class Solicitation extends Project {
	private ArrayList<MajorType> majors;
	private ArrayList<ClassType> classes;
	private int numStudents;
	private double cost;
	private SolicitationType solicitationType;

	public Solicitation() {
		
	}
	
	//Setters
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setMajors(ArrayList<MajorType> majors) {
		this.majors = majors;
	}
	public void setClasses(ArrayList<ClassType> classes) {
		this.classes = classes;
	}
	public void setSolicitationType(SolicitationType solicitationType) {
		this.solicitationType = solicitationType;
	}

	//Getters
	public int getNumStudents() {
		return numStudents;
	}
	public double getCost() {
		return cost;
	}
	public ArrayList<MajorType> getMajors() {
		return majors;
	}
	public ArrayList<ClassType> getClasses() {
		return classes;
	}
	public SolicitationType getSolicitationType() {
		return solicitationType;
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
