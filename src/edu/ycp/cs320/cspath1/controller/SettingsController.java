package edu.ycp.cs320.cspath1.controller;

import java.io.IOException;
import java.sql.SQLException;

import edu.ycp.cs320.cspath1.model.AccountCreationModel;
import edu.ycp.cs320.cspath1.persist.DatabaseProvider;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;

public class SettingsController {
	private IDatabase db = null;
	private AccountCreationModel model;

	public SettingsController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new YCPDatabase());
		db = DatabaseProvider.getInstance();		
	}
	
	public void editUsername() throws IOException, SQLException {
		db.editUsername(model.getUser_id(), model.getUsername());
	}
	
	public void editPassword() throws IOException, SQLException {
		db.editPassword(model.getUser_id(), model.getPassword());
	}
	
	public void editClassType() throws IOException, SQLException {
		db.editClassType(model.getUser_id(), model.getClasstype());
	}
	public void editMajorType() throws IOException, SQLException {
		db.editMajorType(model.getUser_id(), model.getMajortype());
	}
	
	
	public AccountCreationModel getModel() {
		return model;
	}

	public void setModel(AccountCreationModel model) {
		this.model = model;
	}
	
}
