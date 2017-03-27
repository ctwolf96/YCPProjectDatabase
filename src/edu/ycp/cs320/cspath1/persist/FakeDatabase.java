package edu.ycp.cs320.cspath1.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.user.Faculty;
import edu.ycp.cs320.cspath1.user.Student;

public class FakeDatabase implements IDatabase {
	
	private List<Project> projectList;
	private List<Student> studentList;
	private List<Faculty> facultyList;
	
	public FakeDatabase(){
		this.projectList = new ArrayList<Project>();
		this.studentList = new ArrayList<Student>();
		this.facultyList = new ArrayList<Faculty>();
		
		readInitialData();
		
		System.out.println(studentList.size() + "students");
		System.out.println(facultyList.size() + "faculty");
	}
	
	
	public void readInitialData() {
		try {
			studentList.addAll(InitialData.getStudents());
			facultyList.addAll(InitialData.getFaculty());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
}
