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
	public void insertUser(String username, String password, String email, UserType usertype, Connection conn) throws IOException, SQLException;
	public void deleteUser(User user, Connection conn) throws IOException, SQLException;
	public void editPassword(int UserID, String password, Connection conn) throws IOException, SQLException;
	public void editEmail(int UserID, String email, Connection conn) throws IOException, SQLException;
	public User findUserByUserID(int UserID, Connection conn) throws IOException, SQLException;
	public User findUserByUsername(String username, Connection conn) throws IOException, SQLException;
	public User findUserByUsernameAndPassword(String username, String password, Connection conn) throws IOException, SQLException;
	public User findUserByEmail(String email, Connection conn) throws IOException, SQLException;
	public List<User> findUserByUserType(UserType usertype, Connection conn) throws IOException, SQLException; //tested
	public List<User> findUserByFirstname(String firstname, Connection conn) throws IOException, SQLException;
	public List<User> findUserByLastname(String lastname, Connection conn) throws IOException, SQLException; 
	public List<User> findUserByMajorType(MajorType major, Connection conn) throws IOException, SQLException; 
	public List<User> findUserByClassType(ClassType classtype, Connection conn) throws IOException, SQLException;
	public User findUserByName(String name, Connection conn) throws IOException, SQLException;
	public User findUserByAddress(String address, Connection conn) throws IOException, SQLException;
	public User findUserByNumber(String number, Connection conn) throws IOException, SQLException;
	
	public void insertProject(int UserID, String title, String description, String start, String duration, ProjectType type, Connection conn) throws IOException, SQLException;
	public void deleteProject(Project project, Connection conn) throws IOException, SQLException;
	
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
