package edu.ycp.cs320.cspath1.persist;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.ProjectType;
import edu.ycp.cs320.cspath1.enums.SolicitationType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.Pair;
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.project.Solicitation;
import edu.ycp.cs320.cspath1.user.User;

public class FakeDatabase implements IDatabase {

	@Override
	public Integer insertUser(String username, String password, String email, UserType usertype)
			throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserAndProjects(int user_id) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPassword(int UserID, String password) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editEmail(int UserID, String email) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editUsername(int UserID, String email) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByUserID(int UserID) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUsername(String username) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByUserType(UserType usertype) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByFirstname(String firstname) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByLastname(String lastname) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByMajorType(MajorType major) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByClassType(ClassType classtype) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByName(String name) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByAddress(String address) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByNumber(String number) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertProject(int UserID, String title, String description, String start, int duration,
			ProjectType type) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProject(int project_id) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editTitle(int ProjectID, String title) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editDescription(int ProjectID, String description) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editStart(int ProjectID, String start) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editDuration(int ProjectID, int duration) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Project> findAllProjects() throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project findProjectByProjectID(int ProjectID) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project findProjectByTitle(String title) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project findProjectByDescription(String description) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectByStart(String start) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectByDuration(int duration) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectByProjectType(ProjectType type) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectBySolicitationType(SolicitationType type) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectByMajorType(MajorType major) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectByClassType(ClassType classtype) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectByNumStudents(int numStudents) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectByCost(double cost) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectByIsFunded(boolean funded) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectByDeadline(String deadline) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findProjectByBudget(Double budget) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;	
	}

	@Override
	public List<Pair<User, Project>> findAllUsersByProject(int ProjectID) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pair<User, Project>> findAllProjectsByUser(int UserID) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
