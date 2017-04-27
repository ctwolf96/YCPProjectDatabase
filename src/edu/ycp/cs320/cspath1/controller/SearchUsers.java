package edu.ycp.cs320.cspath1.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.cspath1.user.User;
import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;
import edu.ycp.cs320.cspath1.persist.DatabaseProvider;

public class SearchUsers {

	private IDatabase db = null;

	public SearchUsers() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new YCPDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public ArrayList<User> getAllUser() throws IOException, SQLException {
		
		// get the list of users from DB
		List<User> userList = db.findAllUsers();
		ArrayList<User> users = null;
		
		if (userList.isEmpty()) {
			System.out.println("No Users found in library");
			return null;
		}
		else {
			users = new ArrayList<User>();
			for (User user : userList) {
				users.add(user);
				System.out.println(user.getUsername());
			}			
		}
		
		// return users
		return users;
	}
	public ArrayList<User> getUserByName(String Firstname, String Lastname) throws IOException, SQLException{
		List<User> userList = null;
		ArrayList<User> users = null;
		
		if((Firstname == null || Firstname == "")&&(Lastname != null || Lastname != "")){
			userList = db.findUserByLastname(Lastname);
		}
		else if((Firstname != null || Firstname != "")&&(Lastname == null || Lastname == "")){
			userList = db.findUserByFirstname(Firstname);
		}
		else if((Lastname != null || Firstname != "")&&(Firstname != null || Firstname != "")){
			userList.add(db.findUserByName(Firstname + " " + Lastname));
		}
		
		
		if (userList.isEmpty()) {
			System.out.println("No Users found in library");
			return null;
		}
		else {
			users = new ArrayList<User>();
			for (User user : userList) {
				users.add(user);
				System.out.println(user.getUsername());
			}			
		}
		return users;
	}
	public ArrayList<User> getUserByUsername(String username) throws IOException, SQLException{
		//List<User> userList = db.findAllUsers();
		ArrayList<User> users = null;
		users.add(db.findUserByUsername(username));
		if (users.isEmpty()) {
			System.out.println("No Users found in library");
			return null;
		}
		else {
			return users;
			}
	}
	public ArrayList<User> getUsersByMajor(MajorType major) throws IOException, SQLException {
		
		// get the list of users from DB
		List<User> userList = db.findUserByMajorType(major);
		ArrayList<User> users = null;
		
		if (userList.isEmpty()) {
			System.out.println("No Users found in library");
			return null;
		}
		else {
			users = new ArrayList<User>();
			for (User user : userList) {
				users.add(user);
				System.out.println(user.getUsername());
			}			
		}
		
		// return return users for his major
		return users;
	}
	public ArrayList<User> getUsersByUserType(UserType usertype) throws IOException, SQLException {
	
	// get the list of users from DB
	List<User> userList = db.findUserByUserType(usertype);
	ArrayList<User> users = null;
	
	if (userList.isEmpty()) {
		System.out.println("No Users found in library");
		return null;
	}
	else {
		users = new ArrayList<User>();
		for (User user : userList) {
			users.add(user);
			System.out.println(user.getUsername());
		}			
	}
	
	// return return users for his major
	return users;
	}
	public ArrayList<User> getUsersByClassType(ClassType classtype) throws IOException, SQLException {
		
		// get the list of users from DB
		List<User> userList = db.findUserByClassType(classtype);
		ArrayList<User> users = null;
		
		if (userList.isEmpty()) {
			System.out.println("No Users found in library");
			return null;
		}
		else {
			users = new ArrayList<User>();
			for (User user : userList) {
				users.add(user);
				System.out.println(user.getUsername());
			}			
		}
		
		// return return users for his major
		return users;
		}
}
