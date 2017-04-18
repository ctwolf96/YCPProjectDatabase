package edu.ycp.cs320.cspath1.persist;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.Pair;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.user.User;

public class YCPDatabaseTests {
	private IDatabase db = null;
	
	User user = null;
	ArrayList<Project> projects = null;
	List<User> users = null;
	List<Pair<User, Project>> userProjectList = null;
	List<Pair<User, Project>> projectUserList = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
	@Before 
	public void setUp() throws Exception {
		DatabaseProvider.setInstance(new YCPDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testFindUserByUsernameAndPassword() throws IOException, SQLException {
		System.out.println("\n*** Testing findUserByUsernameAndPassword ***");
		
		String username = "cspath1";
		String password = "password";
		
		user = db.findUserByUsernameAndPassword(username, password);
		
		if(user.getUsername() == null){
			System.out.println("No user found in database with username <" + username + "> and password <" + password + ">");
			fail("No user with username <" + username + "> and password <" + password + "> returned from DB");
		}
		
		else {
			System.out.println(user.getEmail() + ", " + user.getUsername() + ", " + user.getPassword() + ", " + user.getUsertype());
		}
	}
	
	@Test
	public void testFindUserByClassType() throws IOException, SQLException {
		System.out.println("\n*** Testing findUserByClassType ***");
		
		ClassType classtype = ClassType.SOPHOMORE;
		
		users = db.findUserByClassType(classtype);
		
		
		if (users.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
				
		}
		
		else {
			for (User user : users){
				System.out.println(user.getUsername() + ", " + user.getEmail() + ", " + user.getPassword() + ", " + user.getUsertype());;
			}
		}
		
	}
	
	@Test
	public void testFindUserByUserID() throws IOException, SQLException{
		System.out.println("\n*** Testing findUserByUserID***");
		
		int userID = 4;
		
		user = db.findUserByUserID(userID);
		
		if (user.getEmail() == null){
			System.out.println("No users found in database");
			fail("No users returned from DB");
		}
		else {
			System.out.println(user.getEmail() + ", " + user.getPassword() + ", " + user.getUsername());
		}
		
	}
	
	@Test
	public void testFindUserByUsername() throws IOException, SQLException {
		System.out.println("\n*** Testing findUserByUsername***");
		
		String username = "jhopkins1";
		
		user = db.findUserByUsername(username);
		
		if (user.getPassword() == null) {
			System.out.println("No users found in database");
			fail("No users returned from DB");
		}
		
		else {
			System.out.println(user.getEmail() + ", " + user.getPassword() + ", " + user.getUsername());
		}
	}
	
	@Test
	public void testFindUserByEmail() throws IOException, SQLException {
		System.out.println("\n*** Testing findUserByEmail***");
		
		String email = "jhopkins1@ycp.edu";
		
		user = db.findUserByEmail(email);
		
		if (user.getUsername() == null){
			System.out.println("No users found in database");
			fail("No users returned from DB");
		}
		
		else {
			System.out.println(user.getEmail() + ", " + user.getPassword() + ", " + user.getUsername());
		}
	}
	
	@Test
	public void testFindUserByUsertype() throws IOException, SQLException {
		System.out.println("\n*** Testing findUserByUsertype");
		
		UserType usertype = UserType.STUDENT;
		
		users = db.findUserByUserType(usertype);
		
		if (users.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		
		else {
			for (User user : users) {
				System.out.println(user.getEmail() + ", " + user.getPassword() + ", " + user.getUsername());
			}
		}
	}
	
	/*@Test
	public void testEditEmail() throws IOException, SQLException { 
		System.out.println("\n*** Testing editEmail***");
		
		db.editEmail(17, "cspath@ycp.edu");
		
		user = db.findUserByEmail("cspath@ycp.edu");
		
		if(user.getPassword() == null){
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		
		else {
			System.out.println(user.getEmail() + ", " + user.getPassword() + ", " + user.getUsername());
		}
		
	}*/
	
	@Test
	public void testInsertUser() throws IOException, SQLException {
		System.out.println("\n*** Testing insertUser***");
		
		Integer user_id = db.insertUser("cspath2", "password", "cspath2@ycp.edu", UserType.STUDENT);
		
		System.out.println(user_id);
		
		if(user_id > 0){
			user = db.findUserByUserID(user_id);
			
			if(user.getEmail() == null){
				System.out.println("Something has gone horribly wrong...");
				fail("No users returned from DB");
			}
			else {
				System.out.println(user.getEmail() + ", " + user.getUsername() + ", " + user.getPassword());
				db.deleteUserAndProjects(user.getUserID());
			}
			
				
		}
		else {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
	}
	
	@Test
	public void testFindAllUsers() throws IOException, SQLException {
		System.out.println("\n*** Testing findAllUsers");
		
		List<User> userList = db.findAllUsers();
		
		if (userList.isEmpty()) {
			System.out.println("No users found in DB");
			fail("No users returned from DB");
			
		}
		else {
			users = new ArrayList<User>();
			for (User user : userList){
				users.add(user);
				System.out.println(user.getUsername() + ", " + user.getUserID());
			}
		}
	}
	
	
}
