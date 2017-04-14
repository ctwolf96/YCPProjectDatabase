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


import edu.ycp.cs320.cspath1.model.Pair;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.user.User;

public class YCPDatabaseTests {
	private IDatabase db = null;
	
	User user = null;
	ArrayList<Project> projects = null;
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
			System.out.println(user.getEmail() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getUsertype());
		}
	}
	
}
