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
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.ProjectType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.Pair;
import edu.ycp.cs320.cspath1.persist.IDatabase;
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.user.User;

public class YCPDatabaseTests {
	private IDatabase db = null;
	
	User user = null;
	Project project = null;
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
		
		List<User> userList = db.findUserByClassType(ClassType.SOPHOMORE);
		
		
		if (userList.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
				
		}
		
		else {
			users = new ArrayList<User>();
			for (User user : userList){
				users.add(user);
				System.out.println(user.getUsername() + ", " + user.getEmail() + ", " + user.getPassword() + ", " + user.getUsertype());;
			}
		}
		
	}
	
	@Test
	public void testFindUsersByMajorType() throws IOException, SQLException {
		System.out.println("\n*** Testing findUsersByMajorType ***");
		
		List<User> userList = db.findUserByMajorType(MajorType.CS);
		
		if(userList.isEmpty()) {
			System.out.println("No users found in DB");
			fail("No users returned from DB");
		}
		
		else {
			users = new ArrayList<User>();
			for (User user : userList) {
				users.add(user);
				System.out.println(user.getEmail() + ", " + user.getUsername() + ", " + user.getUserID());
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
	
	@Test
	public void testFindUserByName() throws IOException, SQLException {
		System.out.println("\n*** Testing findUserByName");
		
		user = db.findUserByName("Business1 Inc.");
		
		if(user.getEmail() == null) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		
		else {
			System.out.println(user.getEmail() + ", " + user.getUsername());
		}
	}
	
	@Test
	public void testFindUserByAddress() throws IOException, SQLException {
		System.out.println("\n*** Testing findUserByAddress");
		
		user = db.findUserByAddress("123 Fake Address Street");
		
		if(user.getEmail() == null) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		
		else {
			System.out.println(user.getEmail() + ", " + user.getUsername());
		}
		
	}
	
	@Test
	public void testFindUserByNumber() throws IOException, SQLException {
		System.out.println("\n*** Testing findUserByNumber");
		
		user = db.findUserByNumber("717-777-7776");
		
		if(user.getPassword() == null) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		
		else {
			System.out.println(user.getEmail() + ", " + user.getUsername());
		}
	}
	
	@Test
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
		
	}
	
	@Test
	public void testEditUsername() throws IOException, SQLException {
		System.out.println("\n*** Testing editUsername");
		
		db.editUsername(17, "spathcody");
		
		user = db.findUserByUserID(17);
		
		if(user.getEmail() == null) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		
		else {
			System.out.println(user.getEmail() + ", " + user.getUsername() + ", " + user.getUserID());
		}
	}
	
	@Test
	public void testEditPassword() throws IOException, SQLException {
		System.out.println("\n*** Testing editPassword***");
		
		db.editPassword(17, "password1");
		
		user = db.findUserByUserID(17);
		
		if (user.getEmail() == null) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from db");
			
		}
		
		else {
			System.out.println(user.getEmail() + ", " + user.getPassword());
		}
	}
	
	@Test
	public void testInsertUser() throws IOException, SQLException {
		System.out.println("\n*** Testing insertUser***");
		
		Integer user_id = 0;
		user_id = db.insertUser("cspath2", "password", "cspath2@ycp.edu", UserType.STUDENT);
		
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
		System.out.println("\n*** Testing findAllUsers***");
		
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
	
	@Test
	public void testInsertProject() throws IOException, SQLException {
		System.out.println("\n*** Testing insertProject ***");
		
		int project_id = 0;
		project_id = db.insertProject(1, "Test", "description", "4/20/17", 1, ProjectType.PROPOSAL);
		
		System.out.println(project_id);
		
		if(project_id > 0) {
			project = db.findProjectByProjectID(project_id);
			
			if(project.getTitle() == null){
				System.out.println("Project was not inserted correctly");
				fail("Project does not match specified project");
			}
			else {
				System.out.println(project.getTitle() + ", " + project.getDescription());
				db.deleteProject(project_id);
			}	
		} else {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		}
	}
	

	@Test
	public void testDeleteProject() throws IOException, SQLException {
		System.out.println("\n*** Testing deleteProject ***");
		
		int project_id = db.insertProject(1, "Test", "description", "4/20/17", 1, ProjectType.PROPOSAL);
		db.deleteProject(project_id);
		project = db.findProjectByProjectID(project_id);
		
		if(project == null) {
			System.out.println("Project was deleted successfully!");
		} else {
			System.out.println("Project was not deleted");
			fail("DB did not successfully delete the project");
		}
	}

	
	@Test
	public void testFindAllProjects() throws IOException, SQLException {
		System.out.println("\n*** Testing findAllProjects ***");
		
		List<Project> projectList = db.findAllProjects();
		
		if (projectList.isEmpty()) {
			System.out.println("No projectss found in DB");
			fail("No projectss returned from DB");
			
		}
		else {
			for (Project project : projectList){
				projects.add(project);
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testFindProjectByProjectID() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByProjectID ***");
		
		int ProjectID = 1;
		
		project = db.findProjectByProjectID(ProjectID);
		
		if (project == null) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		} else {
			System.out.println(project.getProjectID() + ", " + project.getTitle());
		}
	}
}
