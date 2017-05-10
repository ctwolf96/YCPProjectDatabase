package edu.ycp.cs320.cspath1.controller;

import java.io.IOException;
import java.sql.SQLException;

import edu.ycp.cs320.cspath1.model.ProjectModel;
import edu.ycp.cs320.cspath1.persist.DatabaseProvider;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;

public class ProjectSettingsController {
	private IDatabase db = null;
	private ProjectModel model;
	
	public ProjectSettingsController() {
		DatabaseProvider.setInstance(new YCPDatabase());
		db = DatabaseProvider.getInstance();
		
	}
	
	public void editTitle() throws IOException, SQLException {
		db.editTitle(model.getProject_id(), model.getTitle());
	}
	
	public void editDescription() throws IOException, SQLException {
		db.editDescription(model.getProject_id(), model.getDescription());
	}
	
	public void editStart() throws IOException, SQLException {
		db.editStart(model.getProject_id(), model.getStartTime());
	}
	
	public void editNumStudents() throws IOException, SQLException {
		db.editNumStudents(model.getProject_id(), model.getNumStudents());
	}
	
	public void editCost() throws IOException, SQLException {
		db.editCost(model.getProject_id(), model.getCost());
	}
	
	public void editDuration() throws IOException, SQLException {
		db.editDuration(model.getProject_id(), model.getDuration());
	}
	
	public void editMajors() throws IOException, SQLException {
		db.editMajorTypes(model.getProject_id(), model.getMajors());
	}
	
	public void editClasses() throws IOException, SQLException {
		db.editClassTypes(model.getProject_id(), model.getClasses());
	}

	public ProjectModel getModel() {
		return model;
	}

	public void setModel(ProjectModel model) {
		this.model = model;
	}
}
