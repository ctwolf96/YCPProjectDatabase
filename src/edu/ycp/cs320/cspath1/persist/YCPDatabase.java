package edu.ycp.cs320.cspath1.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class YCPDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;
	
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	private User loadUser(User user, ResultSet resultSet, int index) throws SQLException {
		user.setUserID(resultSet.getInt(index++));
		user.setUsername(resultSet.getString(index++));
		user.setPassword(resultSet.getString(index++));
		user.setUsertype(getUserTypeFromParameter(resultSet.getString(index++)));
		if (user.getUsertype() == UserType.STUDENT) {
			Student student = new Student();
			student.setUserID(user.getUserID());
			student.setUsername(user.getUsername());
			student.setPassword(user.getPassword());
			student.setUsertype(user.getUsertype());
			student.setFirstname(resultSet.getString(index++));
			student.setLastname(resultSet.getString(index++));
			student.setMajor(getMajorTypeFromParameter(resultSet.getString(index++)));
			student.setClassLevel(getClassTypeFromParameter(resultSet.getString(index++)));
			return student;
		}
		else if (user.getUsertype() == UserType.FACULTY){
			Faculty faculty = new Faculty();
			faculty.setUserID(user.getUserID());
			faculty.setUsername(user.getUsername());
			faculty.setPassword(user.getPassword());
			faculty.setUsertype(user.getUsertype());
			faculty.setFirstname(resultSet.getString(index++));
			faculty.setLastname(resultSet.getString(index++));
			faculty.setMajor(getMajorTypeFromParameter(resultSet.getString(index++)));
			return faculty;
		}
		return null;
		
	}
	
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				
				try {
					stmt1 = conn.prepareStatement(
						"create table user (" +
						"	user_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +									
						"	username varchar(40) not null," +
						"	password varchar(40) not null," +
						"   email varchar(60) not null," +
						"   usertype varchar(10) not null" +	
						")"
					);	
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
						"create table project (" +
						"	project_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +
						"	creator varchar(30) not null," +
						"	title varchar(30) not null," +
						"   description varchar(10) not null" +
						")"
					);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement(
							"create table relation (" +
							"	foreign key (user_id) references user(user_id)," +
							"   foreign key (project_id) references project(project_id)" +
							")"
						);
						stmt3.executeUpdate();
						
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<Student> studentList;
				List<Faculty> facultyList;
				
				try {
					studentList = InitialData.getStudents();
					facultyList = InitialData.getFaculty();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertStudent = null;
				PreparedStatement insertFaculty = null;
				

				try {
					insertStudent = conn.prepareStatement(
							"insert into user (username, password, email, usertype, other1, other2, other3, other4) values (?, ?, ?, ?. ?, ?, ?, ?)");
					for (Student student : studentList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertStudent.setString(1, student.getUsername());
						insertStudent.setString(2, student.getPassword());
						insertStudent.setString(3, student.getEmail());
						insertStudent.setString(4, student.getUsertype().toString());
						insertStudent.setString(5, student.getFirstname());
						insertStudent.setString(6, student.getLastname());
						insertStudent.setString(7, student.getMajor().toString());
						insertStudent.setString(8, student.getClassLevel().toString());
						insertStudent.addBatch();
					}
					insertStudent.executeBatch();
					
					insertFaculty = conn.prepareStatement(
							"insert into user (username, password, email, usertype, other1, other2, other3, other4) values (?, ?, ?, ?, ?, ?, ?, ?)");
					for (Faculty faculty : facultyList) { 
						insertFaculty.setString(1, faculty.getUsername());
						insertFaculty.setString(2, faculty.getPassword());
						insertFaculty.setString(3, faculty.getEmail());
						insertFaculty.setString(4, faculty.getUsertype().toString());
						insertFaculty.setString(5, faculty.getFirstname());
						insertFaculty.setString(6, faculty.getLastname());
						insertFaculty.setString(7, faculty.getMajor().toString());
						insertFaculty.setString(8, "");
					}
					insertFaculty.executeBatch();
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertStudent);
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		YCPDatabase db = new YCPDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
	}

	@Override
	public void insertUser(String username, String password, String email, UserType usertype) {
		
		
	}

	@Override
	public User findUserbyUserID(int UserID, Connection conn) throws IOException, SQLException{
		ResultSet resultSet = null;
		//Placeholder since we can't instantiate the super
		User user = new Student();
		PreparedStatement stmt = conn.prepareStatement(
				"select user" +
				"from user" +
				"where user.user_id = ?"
				);
		stmt.setInt(1, UserID);
		
		resultSet = stmt.executeQuery();
		
		Boolean found = false;
		
		while (resultSet.next()){
			found = true;
			
			user = loadUser(user, resultSet, 1);
		
		}
		
		if(!found){
			System.out.println("<" + UserID + "> was not found in the user table");
		}
		return user;
	}

	@Override
	public List<User> findUserByUserType(UserType usertype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentByUsernameAndPassword(String password, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByMajorType(MajorType major) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudentByClassType(ClassType classtype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Faculty findFacultyByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Faculty findFacultybyUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faculty> findFacultyByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faculty> findFacultyByLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faculty> findFacultyByMajorType(MajorType major) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void insertProject(User creator, String title, String description, int userid) {
		// TODO Auto-generated method stub
		
	}
	
	private static MajorType getMajorTypeFromParameter(String s){
		MajorType majortype = null;
		if (s == null || s.equals("")){
			return null;
		}
		else if (s.equals("ME")){
			majortype = MajorType.ME;
			
		}
		else if (s.equals("CE")){
			majortype = MajorType.CE;
		}
		else if(s.equals("CS")){
			majortype = MajorType.CS;
		}
		else if(s.equals("EE")){
			majortype = MajorType.EE;
		}
		else if (s.equals("UN")) {
			majortype = MajorType.UN;
		}
		else if (s.equals("CIV")){
			majortype = MajorType.CIV;
		}
		return majortype;
	}
	
	private static ClassType getClassTypeFromParameter(String s){
		ClassType classtype = null;
		if(s == null || s.equals("")){
			return null;
		}
		else if (s.equals("FRESHMAN")){
			classtype = ClassType.FRESHMAN;
		}
		else if (s.equals("SOPHOMORE")){
			classtype = ClassType.SOPHOMORE;
		}
		else if (s.equals("JUNIOR")){
			classtype = ClassType.JUNIOR;
		}
		else if (s.equals("SENIOR")){
			classtype = ClassType.SENIOR;
		}
		return classtype;
	}
	
	private static UserType getUserTypeFromParameter(String s) {
		if (s == null || s.equals("")){
			return null;
		}
		else if (s.equals("FACULTY")){
			return UserType.FACULTY;
		}
		else if (s.equals("ADMIN")){
			return UserType.ADMIN;
		}
		else if (s.equals("STUDENT")){
			return UserType.STUDENT;
		}
		else if (s.equals("BUSINESS")){
			return UserType.BUSINESS;
		}
		return null;
	}
	private static SolicitationType getSolicitationTypeFromParameter(String s){
		if (s == null || s.equals("")){
			return null;
		}
		else if (s.equals("SW_ENGINEERING")){
			return SolicitationType.SW_ENGINEERING;
		}
		else if (s.equals("CivE_CAPSTONE")){
			return SolicitationType.CivE_CAPSTONE;
		}
		else if (s.equals("ME_ECE_CAPSTONE")){
			return SolicitationType.ME_ECE_CAPSTONE;
		}
		else if (s.equals("CS_SENIOR_DESIGN_I")){
			return SolicitationType.CS_SENIOR_DESIGN_I;
		}
		else if (s.equals("CS_SENIOR_DESIGN_II")){
			return SolicitationType.CS_SENIOR_DESIGN_II;
		}
		else if (s.equals("ECE_CAPSTONE")){
			return SolicitationType.ECE_CAPSTONE;
		}
		else if (s.equals("ME_CAPSTONE")){
			return SolicitationType.ME_CAPSTONE;
		}
		else if (s.equals("CS_INTERNSHIP")){
			return SolicitationType.CS_INTERNSHIP;
		}
		else if (s.equals("INDEPENDENT_STUDY")){
			return SolicitationType.INDEPENDENT_STUDY;
		}
		else if (s.equals("ENGINEERING_COOP")){
			return SolicitationType.ENGINEERING_COOP;
		}
		else if (s.equals("CLASS_PROJECT")){
			return SolicitationType.CLASS_PROJECT;
		}
		return null;
	}

	@Override
	public User findUserbyUserID(int UserID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Business findBusinessByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Business findBusinessByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Business findBusinessByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Business findBusinessByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(String username, String password, String email, UserType usertype, Connection conn) {
		// TODO Auto-generated method stub
		
	}
}
