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
						"	username varchar(40)," +
						"	password varchar(40)" +
						"   email varchar(60)" +
						"   usertype varchar(10)" +	
						")"
					);	
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
						"create table project (" +
						"	student_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +
						"	user_id integer constraint user_id references user, " +
						"	creator varchar(30)," +
						"	title varchar(30)" +
						"   description varchar(10)" +
						"   userid varchar(10)" +
						")"
					);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement(
							"create table relation (" +
							"	faculty_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	user_id integer constraint user_id references user, " +
							"	firstname varchar(30)," +
							"	lastname varchar(30)" +
							"   major varchar(10)" +
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
				PreparedStatement insertGuest = null;

				try {
					insertStudent = conn.prepareStatement(
							"insert into user (username, password, email, usertype) values (?, ?, ?, ?)");
					for (Student student : studentList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertStudent.setString(1, student.getUsername());
						insertStudent.setString(2, student.getPassword());
						insertStudent.setString(3, student.getEmail());
						insertStudent.setString(4, student.getUsertype().toString());
						insertStudent.addBatch();
					}
					insertStudent.executeBatch();
					
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserbyUserID(int UserID) {
		// TODO Auto-generated method stub
		return null;
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
}
