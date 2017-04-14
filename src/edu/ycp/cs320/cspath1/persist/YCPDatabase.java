
package edu.ycp.cs320.cspath1.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.ProjectType;
import edu.ycp.cs320.cspath1.enums.SolicitationType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.project.ActiveProject;
import edu.ycp.cs320.cspath1.project.PastProject;
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.project.Proposal;
import edu.ycp.cs320.cspath1.project.Solicitation;
import edu.ycp.cs320.cspath1.user.Business;
import edu.ycp.cs320.cspath1.user.Faculty;
import edu.ycp.cs320.cspath1.user.Student;
import edu.ycp.cs320.cspath1.user.User;
import edu.ycp.cs320.cspath1.persist.DBUtil;

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
		Connection conn = DriverManager.getConnection("jdbc:derby:YCP.db;create=true");
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(true);
		
		return conn;
	}
	
	//Methods to return enums from strings
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
	
	private static ProjectType getProjectTypeFromParameter(String s){
		if (s == null || s.equals("")){
			return null;
		}
		else if (s.equals("PROPOSAL")) {
			return ProjectType.PROPOSAL;
		}
		else if (s.equals("SOLICITATION")) {
			return ProjectType.SOLICITATION;
		}
		else if (s.equals("ACTIVE")) {
			return ProjectType.ACTIVE;
		}
		else if (s.equals("PAST")) {
			return ProjectType.PAST;
		}
		return null;
	}
	
	//Method to create a user from database
	private User loadUser(User user, ResultSet resultSet) throws SQLException {
		user.setUserID(resultSet.getInt(1));
		user.setUsername(resultSet.getString(2));
		user.setPassword(resultSet.getString(3));
		user.setEmail(resultSet.getString(4));
		user.setUsertype(getUserTypeFromParameter(resultSet.getString(5)));
		if (user.getUsertype() == UserType.STUDENT) {
			Student student = new Student();
			student.setUserID(user.getUserID());
			student.setUsername(user.getUsername());
			student.setPassword(user.getPassword());
			student.setUsertype(user.getUsertype());
			student.setFirstname(resultSet.getString(6));
			student.setLastname(resultSet.getString(7));
			student.setMajor(getMajorTypeFromParameter(resultSet.getString(8)));
			student.setClassLevel(getClassTypeFromParameter(resultSet.getString(9)));
			return student;
		}
		else if (user.getUsertype() == UserType.FACULTY){
			Faculty faculty = new Faculty();
			faculty.setUserID(user.getUserID());
			faculty.setUsername(user.getUsername());
			faculty.setPassword(user.getPassword());
			faculty.setEmail(user.getEmail());
			faculty.setUsertype(user.getUsertype());
			faculty.setFirstname(resultSet.getString(6));
			faculty.setLastname(resultSet.getString(7));
			faculty.setMajor(getMajorTypeFromParameter(resultSet.getString(8)));
			return faculty;
		}
		else if (user.getUsertype() == UserType.BUSINESS) {
			Business business = new Business();
			business.setUserID(user.getUserID());
			business.setUsername(user.getUsername());
			business.setPassword(user.getPassword());
			business.setEmail(user.getPassword());
			business.setUsertype(user.getUsertype());
			business.setName(resultSet.getString(10));
			business.setAddress(resultSet.getString(11));
			business.setNumber(resultSet.getString(12));
			return business;
		}
		return null;
		
	}
	
	//Method to create a project from database
	private Project loadProject(Project project, ResultSet resultSet) throws SQLException {
		project.setProjectID(resultSet.getInt(1));
		project.setUserID(resultSet.getInt(2));
		project.setTitle(resultSet.getString(3));
		project.setDescription(resultSet.getString(4));
		project.setStart(resultSet.getString(5));
		project.setDuration(resultSet.getString(6));
		project.setProjectType(getProjectTypeFromParameter(resultSet.getString(7)));
		if (project.getProjectType() == ProjectType.SOLICITATION) {
			Solicitation solicitation = new Solicitation();
			solicitation.setProjectID(project.getProjectID());
			solicitation.setUserID(project.getUserID());
			solicitation.setTitle(project.getTitle());
			solicitation.setDescription(project.getDescription());
			solicitation.setStart(project.getStart());
			solicitation.setDuration(project.getDuration());
			solicitation.setProjectType(project.getProjectType());
			solicitation.setSolicitationType(getSolicitationTypeFromParameter(resultSet.getString(7)));
			solicitation.setMajors(getMajorListFromString(resultSet.getString(8)));
			solicitation.setClasses(getClassListFromString(resultSet.getString(9)));
			solicitation.setNumStudents(resultSet.getInt(10));
			solicitation.setCost(resultSet.getInt(11));
			return solicitation;
		}
		else if (project.getProjectType() == ProjectType.PROPOSAL) {
			Proposal proposal = new Proposal();
			proposal.setProjectID(project.getProjectID());
			proposal.setUserID(project.getUserID());
			proposal.setTitle(project.getTitle());
			proposal.setDescription(project.getDescription());
			proposal.setStart(project.getStart());
			proposal.setDuration(project.getDuration());
			proposal.setProjectType(project.getProjectType());
			proposal.setMajors(getMajorListFromString(resultSet.getString(9)));
			proposal.setClasses(getClassListFromString(resultSet.getString(10)));
			proposal.setNumStudents(resultSet.getInt(11));
			proposal.setCost(resultSet.getInt(12));
			proposal.setIsFunded(getBoolFromString(resultSet.getString(13)));
			proposal.setDeadline(resultSet.getString(14));
			return proposal;
		}
		else if (project.getProjectType() == ProjectType.ACTIVE) {
			ActiveProject active = new ActiveProject();
			active.setProjectID(project.getProjectID());
			active.setUserID(project.getUserID());
			active.setTitle(project.getTitle());
			active.setDescription(project.getDescription());
			active.setStart(project.getStart());
			active.setDuration(project.getDuration());
			active.setProjectType(project.getProjectType());
			active.setNumStudents(resultSet.getInt(11));
			active.setCost(resultSet.getInt(12));
			active.setDeadline(resultSet.getString(14));
			active.setBudget(resultSet.getInt(15));
			return active;
		}
		else if (project.getProjectType() == ProjectType.PAST) {
			PastProject past = new PastProject();
			past.setProjectID(project.getProjectID());
			past.setUserID(project.getUserID());
			past.setTitle(project.getTitle());
			past.setDescription(project.getDescription());
			past.setStart(project.getStart());
			past.setDuration(project.getDuration());
			past.setProjectType(project.getProjectType());
			return past;
		}
		return null;
	}
	
	//Methods to convert to and from strings when dealing with the database
	private String getStringFromMajorList(List<MajorType> list) {
		String majors = null;
		int index = 0;
		for (MajorType major: list) {
			major = list.get(index);
			majors = "" + major.toString() + ", ";
			index++;
		}
		return majors;
	}
	
	private ArrayList<MajorType> getMajorListFromString(String s) {
		ArrayList<MajorType> majors = new ArrayList<MajorType>();
		StringTokenizer st = new StringTokenizer(s);
	     while (st.hasMoreTokens()) {
	         majors.add(getMajorTypeFromParameter(st.nextToken()));
	     }
	     return majors;
	}
	
	private String getStringFromClassList(List<ClassType> list) {
		String classes = null;
		int index = 0;
		for (ClassType classtype: list) {
			classtype = list.get(index);
			classes = "" + classtype.toString() + " ";
			index++;
		}
		return classes;
	}
	
	private ArrayList<ClassType> getClassListFromString(String s) {
		ArrayList<ClassType> classes = new ArrayList<ClassType>();
		StringTokenizer st = new StringTokenizer(s);
	     while (st.hasMoreTokens()) {
	         classes.add(getClassTypeFromParameter(st.nextToken()));
	     }
	     return classes;
	}
	
	private String getStringFromBool(Boolean bool) {
		String s = null;
		if (bool.TRUE) {
			s = "true";
		} else if (bool.FALSE) {
			s = "false";
		}
		return s;
	}
	
	private Boolean getBoolFromString(String s) {
		if (s.equals("true")) {
			return true;
		} else {
			return false;
		}
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
						"user_id integer primary key " +
						"generated always as identity (start with 1, increment by 1), " +									
						"username varchar(40) not null," +
						"password varchar(40) not null," +
						"email varchar(60) not null," +
						"usertype varchar(10) not null," +
						"firstname varchar(25)," +
						"lastname varchar(25)," +
						"major varchar(2)," +
						"class varchar(10)," +
						"name varchar(40)," +
						"address varchar(100)" +
						"number varchar(20)" +
						")"
					);	
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
						"create table project (" +
						"project_id integer primary key " +
						"generated always as identity (start with 1, increment by 1), " +
						"user_id integer constraint user_id references user, " +
						"title varchar(30) not null," +
						"description varchar(200) not null," +
						"start varchar(20) not null," +
						"duration varchar(20) not null," +
						"projectType varchar(20) not null," +
						"solicitationType varchar(20)" +
						"majors varchar(20)" +
						"classes varchar(30)" +
						"numStudents integer" +
						"cost integer" +
						"isFunded varchar(5)" +
						"deadline varchar(20)" +
						"budget integer" +
						"members varchar(1000)" +
						"tasks varchar(1000)" +
						")"
					);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement(
							"create table relation (" +
							"foreign key (user_id) references user(user_id)," +
							"foreign key (project_id) references project(project_id)" +
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
				List<User> userList;
				
				try {
					userList = InitialData.getUsers();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}
				PreparedStatement insertUser = null;
				try {
					insertUser = conn.prepareStatement(
							"insert into user" +
							"(username, password, email, usertype, firstname, lastname, major, class, name, address, number)" +
							"values (?, ?, ?, ?. ?, ?, ?, ?, ?, ?, ?)" 
							);
					for (User user : userList) {
						insertUser.setString(1, user.getUsername());
						insertUser.setString(2, user.getPassword());
						insertUser.setString(3, user.getEmail());
						insertUser.setString(4, user.getUsertype().toString());
						insertUser.setString(5, ((Student) user).getFirstname());
						insertUser.setString(6, ((Student) user).getLastname());
						insertUser.setString(7, ((Student) user).getMajor().toString());
						insertUser.setString(8, ((Student) user).getClassLevel().toString());
						insertUser.setString(9, ((Business) user).getName());
						insertUser.setString(10, ((Business) user).getAddress());
						insertUser.setString(11, ((Business) user).getNumber());
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					return true;
				} finally {
					DBUtil.closeQuietly(insertUser);
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
	public void insertUser(String username, String password, String email, UserType usertype) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement  stmt = null;
		try {
			stmt = conn.prepareStatement(
					"select user_id" +
					"from user" +
					"where username = ? and " +
					"password = ?"
					);
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			resultSet = stmt.executeQuery();
			
			if(!resultSet.next()) {
				DBUtil.closeQuietly(stmt);
				
				stmt = conn.prepareStatement(
						"insert into user " +
						"(username, password, email, usertype)" +
						" values (?, ?, ?, ?"
						);
				stmt.setString(1, username);
				stmt.setString(2, password);
				stmt.setString(3, email);
				stmt.setString(4, usertype.toString());
				
				stmt.execute();
			}
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public void deleteUser(User user) throws IOException, SQLException {
		Connection conn = connect();
		PreparedStatement  stmt = null;
		try {
			stmt = conn.prepareStatement(
					"delete from user" +
					"where user_id = ?"
					);
			
			stmt.setInt(1, user.getUserID());
			
			stmt.executeQuery();
		} finally {
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}
	
	@Override
	public void editPassword(int UserID, String password) throws IOException, SQLException {
		Connection conn = connect();
		PreparedStatement  stmt = null;
		try {
			stmt = conn.prepareStatement(
					"update user" +
					"set password = ?" +
					"where user_id = ?"
					);
			
			stmt.setString(1, password);
			stmt.setInt(2, UserID);
			
			stmt.executeQuery();
		} finally {
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}
	
	@Override
	public void editEmail(int UserID, String email) throws IOException, SQLException {
		Connection conn = connect();
		PreparedStatement  stmt = null;
		try {
			stmt = conn.prepareStatement(
					"update user" +
					"set email = ?" +
					"where user_id = ?"
					);
			
			stmt.setString(1, email);
			stmt.setInt(2, UserID);
			
			stmt.executeQuery();
		} finally {
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}
	
	@Override
	public User findUserByUserID(int UserID) throws IOException, SQLException{
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement  stmt = null;
		//Placeholder since we can't instantiate the super
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where user_id = ?"
					);
			stmt.setInt(1, UserID);
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
			
			}
			
			if(!found){
				System.out.println("user_id <" + UserID + "> was not found in the user table");
			}
			return user;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public User findUserByUsername(String username) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Placeholder since we can't instantiate the super
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where username = ?"
					);
			stmt.setString(1, username);
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
			
			}
			
			if(!found){
				System.out.println("<" + username + "> was not found in the user table");
			}
			return user;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Placeholder since we can't instantiate the super
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where username = ? and password = ?"
					);
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
			
			}
			
			if(!found){
				System.out.println("<" + username + "> and <" + password + "> were not found in the user table");
			}
			return user;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public User findUserByEmail(String email) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Placeholder since we can't instantiate the super
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where email = ?"
					);
			stmt.setString(1, email);
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
			
			}
			
			if(!found){
				System.out.println("<" + email + "> was not found in the user table");
			}
			return user;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public List<User> findUserByUserType(UserType usertype) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Placeholder since we can't instantiate the super
		ArrayList<User> users = new ArrayList<User>();
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where usertype = ?"
					);
			stmt.setString(1, usertype.toString());
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
				users.add(user);
			
			}
			
			if(!found){
				System.out.println("No users of type <" + usertype.toString() + "> were found in the user table");
			}
			return users;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public List<User> findUserByFirstname(String firstname) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Placeholder since we can't instantiate the super
		ArrayList<User> users = new ArrayList<User>();
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where firstname = ?"
					);
			stmt.setString(1, firstname);
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
				users.add(user);
			
			}
			
			if(!found){
				System.out.println("No user with the firstname <" + firstname + "> was found in the user table");
			}
			return users;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public List<User> findUserByLastname(String lastname) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Placeholder since we can't instantiate the super
		ArrayList<User> users = new ArrayList<User>();
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where lastname = ?"
					);
			stmt.setString(1, lastname);
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
				users.add(user);
			
			}
			
			if(!found){
				System.out.println("No user with the lastname <" + lastname + "> was found in the user table");
			}
			return users;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public List<User> findUserByMajorType(MajorType major) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Placeholder since we can't instantiate the super
		ArrayList<User> users = new ArrayList<User>();
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where major = ?"
					);
			stmt.setString(1, major.toString());
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
				users.add(user);
			
			}
			
			if(!found){
				System.out.println("No user with the major <" + major + "> was found in the user table");
			}
			return users;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public List<User> findUserByClassType(ClassType classtype) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Placeholder since we can't instantiate the super
		ArrayList<User> users = new ArrayList<User>();
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where classe = ?"
					);
			stmt.setString(1, classtype.toString());
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
				users.add(user);
			
			}
			
			if(!found){
				System.out.println("No user with the class <" + classtype + "> was found in the user table");
			}
			return users;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public User findUserByName(String name) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Placeholder since we can't instantiate the super
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where name = ?"
					);
			stmt.setString(1, name);
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
			
			}
			
			if(!found){
				System.out.println("No business with the name <" + name + "> was found in the user table");
			}
			return user;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public User findUserByAddress(String address) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Placeholder since we can't instantiate the super
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where address = ?"
					);
			stmt.setString(1, address);
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
			
			}
			
			if(!found){
				System.out.println("No business with the address <" + address + "> was found in the user table");
			}
			return user;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public User findUserByNumber(String number) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		//Placeholder since we can't instantiate the super
		User user = new Student();
		try {
			stmt = conn.prepareStatement(
					"select user" +
					"from user" +
					"where number = ?"
					);
			stmt.setString(1, number);
			
			resultSet = stmt.executeQuery();
			
			Boolean found = false;
			
			while (resultSet.next()){
				found = true;
				
				user = loadUser(user, resultSet);
			
			}
			
			if(!found){
				System.out.println("No business with the number <" + number + "> was found in the user table");
			}
			return user;
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
	}

	@Override
	public void insertProject(int UserID, String title, String description, String start, String duration,
			ProjectType type) throws IOException, SQLException {
		Connection conn = connect();
		ResultSet resultSet = null;
		PreparedStatement  stmt = null;
		try {
			stmt = conn.prepareStatement(
					"select project_id" +
					"from user" +
					"where user_id = ? and " +
					"title = ?"
					);
			stmt.setInt(1, UserID);
			stmt.setString(2, title);
			
			resultSet = stmt.executeQuery();
			
			if(!resultSet.next()) {
				DBUtil.closeQuietly(stmt);
				
				stmt = conn.prepareStatement(
						"insert into project " +
						"(user_id, title, description, start, duration, projectType)" +
						" values (?, ?, ?, ?, ?, ?)"
						);
				stmt.setInt(1, UserID);
				stmt.setString(2, title);
				stmt.setString(3, description);
				stmt.setString(4, start);
				stmt.setString(5, duration);
				stmt.setString(6, type.toString());
				
				stmt.execute();
			}
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
		
	}

	@Override
	public void deleteProject(Project project) throws IOException, SQLException {
		Connection conn = connect();
		PreparedStatement  stmt = null;
		try {
			stmt = conn.prepareStatement(
					"delete from project" +
					"where project_id = ?"
					);
			
			stmt.setInt(1, project.getProjectID());
			
			stmt.executeQuery();
		} finally {
			DBUtil.closeQuietly(stmt);
			DBUtil.closeQuietly(conn);
		}
		
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
