package edu.ycp.cs320.cspath1.controller;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.cspath1.user.User;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.persist.YCPDatabase;
import edu.ycp.cs320.cspath1.persist.DatabaseProvider;

public class SearchAllUsers {

	private IDatabase db = null;

	public SearchAllUsers() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new YCPDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public ArrayList<User> getAllUser() {
		
		// get the list of (Author, Book) pairs from DB
		List<User> userList = db.;
		ArrayList<User> users = null;
		
		if (authorList.isEmpty()) {
			System.out.println("No authors found in library");
			return null;
		}
		else {
			authors = new ArrayList<Author>();
			for (Author author : authorList) {
				authors.add(author);
				System.out.println(author.getLastname() + ", " + author.getFirstname());
			}			
		}
		
		// return authors for this title
		return authors;
	}
}

