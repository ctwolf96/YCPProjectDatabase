package edu.ycp.cs320.cspath1.project;

import java.util.ArrayList;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;

public class Proposal extends Project {
	private ArrayList<MajorType> majors;
	private ArrayList<ClassType> classes;
	private String description;
	
	private String duration;
	private String startDate;
	private String endDate;
	private int numStudents;
	private double cost;
	private boolean isFunded;

}
