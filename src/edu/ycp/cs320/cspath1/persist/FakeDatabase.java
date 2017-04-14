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
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.project.Solicitation;
import edu.ycp.cs320.cspath1.user.User;

public class FakeDatabase implements IDatabase {

	@Override
	public void insertUser(String username, String password, String email, UserType usertype)
			throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) throws IOException, SQLException {
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
	public void insertProject(int UserID, String title, String description, String start, String duration,
			ProjectType type) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProject(Project project) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Solicitation findSolicitationByProjectID(int projectID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Solicitation> findSolicitationsByMajorType(MajorType majortype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Solicitation> findSolicitationsByMajorTypes(ArrayList<MajorType> majors) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Solicitation> findSolicitationsByClassType(ClassType classtype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Solicitation> findSolicitationsByClassTypes(ArrayList<ClassType> classtypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Solicitation> findSolicitationsByStartTime(String startTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Solicitation> findSolicitationsByDuration(String duration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Solicitation> findSolicitationsByNumStudents(int numStudents) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Solicitation> findSolicitationsBySolicitationType(SolicitationType solicitationType) {
		// TODO Auto-generated method stub
		return null;
	}

}
