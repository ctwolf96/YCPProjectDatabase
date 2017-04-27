package edu.ycp.cs320.cspath1.controller;

import edu.ycp.cs320.cspath1.user.Student;
import edu.ycp.cs320.cspath1.user.User;
import edu.ycp.cs320.cspath1.email.EmailValidator;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.AccountCreationModel;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;

import java.io.IOException;
import java.sql.SQLException;

public class UserController {
	private User user;
	private IDatabase db = new YCPDatabase();
	private EmailValidator emailValidator;
	private AccountCreationModel model;
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void login(String username, String password) throws IOException, SQLException {
		user = db.findUserByUsernameAndPassword(username, password);
		if (user.getUsername() == username && user.getPassword() == password) {
			//login
		}
		else {
			//no login
		}
	}
	public void logout() {
		//logout
	}
	public void editInfo() {
		//call specific edit method based on what they want to edit
	}
	public void verifyCred() {
		//
	}
	//should be good just need to implement
	public User createAcct() throws IOException, SQLException {
		emailValidator = new EmailValidator();
		User user = new Student();
		boolean check = emailValidator.validate(model.getEmail());
		if (check == true) {
			Integer user_id = db.insertUser(model.getUsername(), model.getPassword(), model.getEmail(), model.getUsertype());
			user = db.findUserByUserID(user_id);
			return user;
		}
		else {
			System.out.println("That username is already in use.");
			return null;
		}
	}
		
		
		
	
	public void proposeProject() {
		//create a new proposal a send to admin/faculty
	}

	public AccountCreationModel getModel() {
		return model;
	}

	public void setModel(AccountCreationModel model) {
		this.model = model;
	}
}