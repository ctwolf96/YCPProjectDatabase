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
import edu.ycp.cs320.cspath1.enums.ProjectType;
import edu.ycp.cs320.cspath1.enums.SolicitationType;
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
	List<Project> projects = null;
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
	public void testFindUserByFirstname() throws IOException, SQLException {
		System.out.println("\n*** Testing findUserByFirstname");
		
		String firstname = "Jason";
		
		users = db.findUserByFirstname(firstname);
		
		if(users.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		
		else {
			for (User user : users){
				System.out.println(user.getUsername() + ", " + user.getEmail());
			}
		}
	}
	
	@Test
	public void testFindUserByLastname() throws IOException, SQLException{
		System.out.println("\n*** Testing findUserByLastname");
		
		String lastname = "Spath";
		
		users = db.findUserByLastname(lastname);
		
		if(users.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		else {
			for (User user : users) {
				System.out.println(user.getEmail() + ", " + user.getUsername());
			}
		}
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
		
		if(project.getDescription() == null) {
			System.out.println("Project was deleted successfully!");
		} else {
			System.out.println(project.getTitle());
			System.out.println("Project was not deleted");
			fail("DB did not successfully delete the project");
		}
	}

	@Test
	public void testFindAllProjects() throws IOException, SQLException {
		System.out.println("\n*** Testing findAllProjects ***");
		
		List<Project> projectList = db.findAllProjects();
		projects = new ArrayList<Project>();
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
			fail("No projects returned from DB");
		} else {
			System.out.println(project.getProjectID() + ", " + project.getTitle());
		}
	}
	
	@Test
	public void testFindProjectByTitle() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByTitle ***");
		
		String title = "YCP Project Database";
		
		project = db.findProjectByTitle(title);
		
		if (project == null) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			System.out.println(project.getProjectID() + ", " + project.getTitle());
		}
	}
	
	@Test
	public void testFindProjectByDescription() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByDescription ***");
		
		String description = "Allows for insight on specific classes";
		
		project = db.findProjectByDescription(description);
		
		if (project == null) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			System.out.println(project.getProjectID() + ", " + project.getTitle());
		}
	}
	
	@Test
	public void testFindProjectByStart() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByStart ***");
		
		String start = "1/27/17";
		
		projects = db.findProjectByStart(start);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			for (Project project: projects) {
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testFindProjectByDuration() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByDuration ***");
		
		int duration = 1;
		
		projects = db.findProjectByDuration(duration);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			for (Project project: projects) {
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testFindProjectByProjectType() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByProjectType ***");
		
		ProjectType type = ProjectType.PROPOSAL;
		
		projects = db.findProjectByProjectType(type);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			for (Project project: projects) {
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testFindProjectBySolicitationType() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectBySolicitationType ***");
		
		SolicitationType type = SolicitationType.CLASS_PROJECT;
		
		projects = db.findProjectBySolicitationType(type);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			for (Project project: projects) {
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testFindProjectByMajorType() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByMajorType ***");
		
		MajorType major = MajorType.CE;
		
		projects = db.findProjectByMajorType(major);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			for (Project project: projects) {
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testFindProjectByClassType() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByClassType ***");
		
		ClassType type = ClassType.SOPHOMORE;
		
		projects = db.findProjectByClassType(type);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			for (Project project: projects) {
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testFindProjectByNumStudents() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByNumStudents ***");
		
		int numStudents = 3;
		
		projects = db.findProjectByNumStudents(numStudents);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			for (Project project: projects) {
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testFindProjectByCost() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByCost ***");
		
		double cost = 0;
		
		projects = db.findProjectByCost(cost);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			for (Project project: projects) {
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testFindProjectByIsFunded() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByIsFunded ***");
		
		Boolean isFunded = true;
		
		projects = db.findProjectByIsFunded(isFunded);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			for (Project project: projects) {
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testFindProjectByDeadline() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByDeadline ***");
		
		String deadline = "5/7/17";
		
		projects = db.findProjectByDeadline(deadline);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			for (Project project: projects) {
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testFindProjectByBudget() throws IOException, SQLException {
		System.out.println("\n*** Testing findProjectByBudget ***");
		
		double budget = 10000;
		
		projects = db.findProjectByBudget(budget);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No projects returned from DB");
		} else {
			for (Project project: projects) {
				System.out.println(project.getProjectID() + ", " + project.getTitle());
			}
		}
	}
	
	@Test
	public void testEditDescription() throws IOException, SQLException {
		System.out.println("\n*** Testing editDescription");
		
		Integer project_id = 3;
		String description = "I would like to change the description to this project...";
		
		db.editDescription(project_id, description);
		
		project = db.findProjectByDescription(description);
		
		if(project == null) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		
		else {
			System.out.println(project.getTitle() + ", " + project.getProjectID());
		}
	}
	
	@Test
	public void testEditTitle() throws IOException, SQLException {
		System.out.println("\n*** Testing editTitle");
		
		Integer project_id = 2;
		String title = "NEW PROJECT TITLE";
		
		db.editTitle(project_id, title);
		
		project = db.findProjectByTitle(title);
		
		if (project == null) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		else {
			System.out.println(project.getStart() + ", " + project.getProjectID());
		}
	}
	
	@Test
	public void testEditStart() throws IOException, SQLException {
		System.out.println("\n*** Testing editStart");
		
		Integer project_id = 4;
		String start = "3/14/17";
		
		db.editStart(project_id, start);
		
		projects = db.findProjectByStart(start);
		
		if (projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		
		else {
			System.out.println(projects.get(0).getProjectID());
		}
	}
	
	@Test
	public void testEditDuration() throws IOException, SQLException {
		System.out.println("\n ***Testing editDuration");
		
		Integer project_id = 1;
		Integer duration = 8;
		db.editDuration(project_id, duration);
		
		projects = db.findProjectByDuration(duration);
		
		if(projects.isEmpty()) {
			System.out.println("Something has gone horribly wrong...");
			fail("No users returned from DB");
		}
		
		else {
			System.out.println(projects.get(0).getDescription() + ", " + projects.get(0).getProjectID());
		}
		
	}
}
