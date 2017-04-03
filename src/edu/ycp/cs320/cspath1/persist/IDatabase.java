package edu.ycp.cs320.cspath1.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
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
	public User findUserByUserID(int UserID, Connection conn) throws IOException, SQLException;
	public User findUserByUsername(String username, Connection conn) throws IOException, SQLException;
	public User findUserByUsernameAndPassword(String username, String password, Connection conn) throws IOException, SQLException;
	public User findUserByEmail(String email, Connection conn) throws IOException, SQLException;
	public List<User> findUserByUserType(UserType usertype, Connection conn) throws IOException, SQLException; //tested
	
	public void insertProject(User creator, String title, String description, int userid);
	public void deleteProject(Project project, Connection conn);
	
	public Student findStudentByUsername(String username); //tested
	public Student findStudentByUsernameAndPassword(String password, String username); //tested
	public List<Student> findStudentByFirstname(String firstname); //tested
	public List<Student> findStudentByLastname(String lastname); //tested
	public List<Student> findStudentByMajorType(MajorType major); //tested
	public List<Student> findStudentByClassType(ClassType classtype); //tested
	
	public Faculty findFacultyByUsername(String username); //tested
	public Faculty findFacultybyUsernameAndPassword(String username, String password); //tested
	public List<Faculty> findFacultyByFirstname(String firstname); //tested
	public List<Faculty> findFacultyByLastname(String lastname); //tested
	public List<Faculty> findFacultyByMajorType(MajorType major); //tested
	
	public Business findBusinessByUsername(String username);
	public Business findBusinessByUsernameAndPassword(String username, String password);
	public Business findBusinessByAddress(String address);
	public Business findBusinessByName(String name);
	public Business findBusinessByEmail(String email);
	
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
