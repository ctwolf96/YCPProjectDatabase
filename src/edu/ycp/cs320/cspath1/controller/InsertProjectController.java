package edu.ycp.cs320.cspath1.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.ProjectType;
import edu.ycp.cs320.cspath1.enums.SolicitationType;
import edu.ycp.cs320.cspath1.persist.DatabaseProvider;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;
import edu.ycp.cs320.cspath1.persist.IDatabase;

public class InsertProjectController {

	private IDatabase db = null;

	public InsertProjectController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new YCPDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public boolean insertProjectIntoDatabase(int UserID, String title, String description, String start, int duration, ProjectType type, SolicitationType solicitationType,
			ArrayList<MajorType> majors, ArrayList<ClassType>classes, int numStudents, double cost, boolean isFunded, String deadline) throws IOException, SQLException {
		
		// insert new book (and possibly new author) into DB
		Integer project_id = db.insertProject(UserID, title, description, start, duration, type,
				solicitationType, majors, classes, numStudents, cost, isFunded, deadline);

		// check if the insertion succeeded
		if (project_id > 0)
		{
			System.out.println("New project (ID: " + project_id + ") successfully added to database: <" + title + ">");
			
			return true;
		}
		else
		{
			System.out.println("Failed to insert new project (ID: " + project_id + ") into database: <" + title + ">");
			
			return false;
		}
	}
}
