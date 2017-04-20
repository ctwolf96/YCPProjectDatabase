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
	//tested
	public Integer insertUser(String username, String password, String email, UserType usertype) throws IOException, SQLException;
	//tested
	public void deleteUserAndProjects(int user_id) throws IOException, SQLException;
	//tested
	public void editPassword(int UserID, String password) throws IOException, SQLException;
	//tested
	public void editEmail(int UserID, String email) throws IOException, SQLException;
	//tested
	public void editUsername(int UserID, String email) throws IOException, SQLException;
	//tested
	public User findUserByUserID(int UserID) throws IOException, SQLException;
	//tested
	public User findUserByUsername(String username) throws IOException, SQLException;
	//tested
	public User findUserByUsernameAndPassword(String username, String password) throws IOException, SQLException;
	//tested
	public User findUserByEmail(String email) throws IOException, SQLException;
	//tested
	public List<User> findUserByUserType(UserType usertype) throws IOException, SQLException; 
	//tested
	public List<User> findUserByFirstname(String firstname) throws IOException, SQLException;
	//tested
	public List<User> findUserByLastname(String lastname) throws IOException, SQLException; 
	//tested
	public List<User> findUserByMajorType(MajorType major) throws IOException, SQLException; 
	//tested
	public List<User> findUserByClassType(ClassType classtype) throws IOException, SQLException;
	//tested
	public List<User> findAllUsers() throws IOException, SQLException;
	//tested
	public User findUserByName(String name) throws IOException, SQLException;
	//tested
	public User findUserByAddress(String address) throws IOException, SQLException;
	
	public User findUserByNumber(String number) throws IOException, SQLException;
	
	public void insertProject(int UserID, String title, String description, String start, String duration, ProjectType type) throws IOException, SQLException;
	public void deleteProject(Project project) throws IOException, SQLException;
	
	public Solicitation findSolicitationByProjectID(int projectID);
	public List<Solicitation> findSolicitationsByMajorType(MajorType majortype);
	public List<Solicitation> findSolicitationsByMajorTypes(ArrayList<MajorType> majors);
	public List<Solicitation> findSolicitationsByClassType(ClassType classtype);
	public List<Solicitation> findSolicitationsByClassTypes(ArrayList<ClassType> classtypes);
	public List<Solicitation> findSolicitationsByStartTime(String startTime);
	public List<Solicitation> findSolicitationsByDuration(String duration);
	public List<Solicitation> findSolicitationsByNumStudents(int numStudents);
	public List<Solicitation> findSolicitationsBySolicitationType(SolicitationType solicitationType);
 }
