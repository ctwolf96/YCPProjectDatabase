package edu.ycp.cs320.cspath1.controller;

import edu.ycp.cs320.cspath1.user.User;
import edu.ycp.cs320.cspath1.email.EmailValidator;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;

import java.io.IOException;
import java.sql.SQLException;

public class UserController {
	private User user;
	private IDatabase db = new YCPDatabase();
	private EmailValidator emailvalidator;
	
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
	public void createAcct(String username, String password, String email, UserType usertype) throws IOException, SQLException {
		//will need to add queries to check if username and password already exist
		boolean check = emailvalidator.validate(email);
		if (check == true) {
			db.insertUser(username, password, email, usertype);
		}
	}
	public void proposeProject() {
		//create a new proposal a send to admin/faculty
		
	}
}