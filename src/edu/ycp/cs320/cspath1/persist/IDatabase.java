package edu.ycp.cs320.cspath1.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.ProjectType;
import edu.ycp.cs320.cspath1.enums.SolicitationType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.project.Solicitation;
import edu.ycp.cs320.cspath1.user.Business;
import edu.ycp.cs320.cspath1.user.Faculty;
import edu.ycp.cs320.cspath1.user.Student;
import edu.ycp.cs320.cspath1.user.User;

public interface IDatabase {
	public Integer insertUser(String username, String password, String email, UserType usertype) throws IOException, SQLException;
	public void deleteUserAndProjects(int user_id) throws IOException, SQLException;
	public void editPassword(int UserID, String password) throws IOException, SQLException;
	public void editEmail(int UserID, String email) throws IOException, SQLException;
	public List<User> findAllUsers() throws IOException, SQLException;
	public User findUserByUserID(int UserID) throws IOException, SQLException;
	public User findUserByUsername(String username) throws IOException, SQLException;
	public User findUserByUsernameAndPassword(String username, String password) throws IOException, SQLException;
	public User findUserByEmail(String email) throws IOException, SQLException;
	public List<User> findUserByUserType(UserType usertype) throws IOException, SQLException; 
	public List<User> findUserByFirstname(String firstname) throws IOException, SQLException;
	public List<User> findUserByLastname(String lastname) throws IOException, SQLException; 
	public List<User> findUserByMajorType(MajorType major) throws IOException, SQLException; 
	public List<User> findUserByClassType(ClassType classtype) throws IOException, SQLException;
	public User findUserByName(String name) throws IOException, SQLException;
	public User findUserByAddress(String address) throws IOException, SQLException;
	public User findUserByNumber(String number) throws IOException, SQLException;
	
	public Integer insertProject(int UserID, String title, String description, String start, int duration, ProjectType type) throws IOException, SQLException;
	public void deleteProject(int project_id) throws IOException, SQLException;
	public void editTitle(int ProjectID, String title) throws IOException, SQLException;
	public void editDescription(int ProjectID, String description) throws IOException, SQLException;
	public void editStart(int ProjectID, String start) throws IOException, SQLException;
	public void editDuration(int ProjectID, String duration) throws IOException, SQLException;
	public List<Project> findAllProjects() throws IOException, SQLException;
	public Project findProjectByProjectID(int ProjectID) throws IOException, SQLException;
	public Project findProjectByTitle(String title) throws IOException, SQLException;
	public Project findProjectByDescription(String description) throws IOException, SQLException;
	public List<Project> findProjectByStart(String start) throws IOException, SQLException;
	public List<Project> findProjectByDuration(int duration) throws IOException, SQLException;
	public List<Project> findProjectByProjectType(ProjectType type) throws IOException, SQLException;
	public List<Project> findProjectBySolicitationType(SolicitationType type) throws IOException, SQLException;
	public List<Project> findProjectByMajorType(MajorType major) throws IOException, SQLException;
	public List<Project> findProjectByClassType(ClassType classtype) throws IOException, SQLException;
	public List<Project> findProjectByNumStudents(int numStudents) throws IOException, SQLException;
	public List<Project> findProjectByCost(double cost) throws IOException, SQLException;
	public List<Project> findProjectByIsFunded(boolean funded) throws IOException, SQLException;
	public List<Project> findProjectByDeadline(String deadline) throws IOException, SQLException;
	public List<Project> findProjectByBudget(Double budget) throws IOException, SQLException;
 }
