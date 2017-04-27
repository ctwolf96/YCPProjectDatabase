package edu.ycp.cs320.cspath1.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.ProjectType;
import edu.ycp.cs320.cspath1.enums.SolicitationType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.model.ActiveProjectUsers;
import edu.ycp.cs320.cspath1.model.ProjectUser;
import edu.ycp.cs320.cspath1.model.projectProject;
import edu.ycp.cs320.cspath1.project.ActiveProject;
import edu.ycp.cs320.cspath1.project.PastProject;
import edu.ycp.cs320.cspath1.project.Project;
import edu.ycp.cs320.cspath1.project.Proposal;
import edu.ycp.cs320.cspath1.project.Solicitation;
import edu.ycp.cs320.cspath1.user.Business;
import edu.ycp.cs320.cspath1.user.Faculty;
import edu.ycp.cs320.cspath1.user.Student;
import edu.ycp.cs320.cspath1.user.User;

public class InitialData {
	public static List<User> getUsers() throws IOException {
		List<User> userList = new ArrayList<User>();
		ReadCSV readUser = new ReadCSV("Users.CSV");
		try {
			Integer userID = 0;
			while (true) {
				List<String> tuple = readUser.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Student user = new Student();
				user.setUserID(userID++);
				user.setUsername(i.next());
				user.setPassword(i.next());
				user.setEmail(i.next());
				user.setUsertype(getUserTypeFromParameter(i.next()));
				if (user.getUsertype().equals(UserType.STUDENT)) {
					user.setFirstname(i.next());
					user.setLastname(i.next());
					user.setMajor(getMajorTypeFromParameter(i.next()));
					user.setClassLevel(getClassTypeFromParameter(i.next()));
					userList.add(user);
				} else if (user.getUsertype().equals(UserType.FACULTY)) {
					Faculty faculty = new Faculty();
					faculty.setUserID(user.getUserID());
					faculty.setUsername(user.getUsername());
					faculty.setPassword(user.getPassword());
					faculty.setEmail(user.getEmail());
					faculty.setUsertype(user.getUsertype());
					faculty.setFirstname(i.next());
					faculty.setLastname(i.next());
					faculty.setMajor(getMajorTypeFromParameter(i.next()));
					userList.add(faculty);
				} else if (user.getUsertype().equals(UserType.BUSINESS)) {
					Business business = new Business();
					business.setUserID(user.getUserID());
					business.setUsername(user.getUsername());
					business.setPassword(user.getPassword());
					business.setEmail(user.getEmail());
					business.setUsertype(user.getUsertype());
					business.setName(i.next());
					business.setAddress(i.next());
					business.setNumber(i.next());
					userList.add(business);
				}
			} 
			return userList;
		} finally {
				readUser.close();
		}
	}
	
	public static List<Project> getProjects() throws IOException {
		List<Project> projectList = new ArrayList<Project>();
		ReadCSV readProject = new ReadCSV("projects.csv");
		try {
			Integer projectID = 0;
			while (true) {
				List<String> tuple = readProject.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Proposal project = new Proposal();
				project.setProjectID(projectID++);
				project.setUserID(Integer.parseInt(i.next()));
				project.setTitle(i.next());
				project.setDescription(i.next());
				project.setStart(i.next());
				project.setDuration(Integer.parseInt(i.next()));
				project.setProjectType(getProjectTypeFromParameter(i.next()));
				if (project.getProjectType().equals(ProjectType.PROPOSAL)) {
					Proposal proposal = new Proposal();
					proposal.setProjectID(project.getProjectID());
					proposal.setUserID(project.getUserID());
					proposal.setTitle(project.getTitle());
					proposal.setDescription(project.getDescription());
					proposal.setStart(project.getStart());
					proposal.setDuration(project.getDuration());
					proposal.setProjectType(project.getProjectType());
					proposal.setMajors(getMajorListFromString(i.next()));
					proposal.setClasses(getClassListFromString(i.next()));
					proposal.setNumStudents(Integer.parseInt(i.next()));
					proposal.setCost((double) Integer.parseInt(i.next()));
					proposal.setIsFunded(getBoolFromString(i.next()));
					proposal.setDeadline(i.next());
					projectList.add(proposal);
				} else if (project.getProjectType().equals(ProjectType.SOLICITATION)) {
					Solicitation solicitation = new Solicitation();
					solicitation.setProjectID(project.getProjectID());
					solicitation.setUserID(project.getUserID());
					solicitation.setTitle(project.getTitle());
					solicitation.setDescription(project.getDescription());
					solicitation.setStart(project.getStart());
					solicitation.setDuration(project.getDuration());
					solicitation.setProjectType(project.getProjectType());
					solicitation.setSolicitationType(getSolicitationTypeFromParameter(i.next()));
					solicitation.setMajors(getMajorListFromString(i.next()));
					solicitation.setClasses(getClassListFromString(i.next()));
					solicitation.setNumStudents(Integer.parseInt(i.next()));
					solicitation.setCost((double) Integer.parseInt(i.next()));
					projectList.add(solicitation);
				} else {
					ActiveProject active = new ActiveProject();
					active.setProjectID(project.getProjectID());
					active.setUserID(project.getUserID());
					active.setTitle(project.getTitle());
					active.setDescription(project.getDescription());
					active.setStart(project.getStart());
					active.setDuration(project.getDuration());
					active.setProjectType(project.getProjectType());
					active.setNumStudents(Integer.parseInt(i.next()));
					active.setCost((double) Integer.parseInt(i.next()));
					active.setDeadline(i.next());
					active.setBudget((double) Integer.parseInt(i.next()));
					projectList.add(active);
				}
			}
			return projectList;
		} finally {
				readProject.close();
		}
	}
	
	public static List<ProjectUser> getProjectUsers() throws IOException {
		List<ProjectUser> projectUserList = new ArrayList<ProjectUser>();
		ReadCSV readProjectUsers = new ReadCSV("projectUsers.CSV");
		try {
			while (true) {
				List<String> tuple = readProjectUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				ProjectUser projectUser = new ProjectUser();
				projectUser.setUserId(Integer.parseInt(i.next()));				
				projectUser.setProjectId(Integer.parseInt(i.next()));
				projectUserList.add(projectUser);
			}
			System.out.println("projectUserList loaded from CSV file");			
			return projectUserList;
		} finally {
			readProjectUsers.close();
		}
	}
	
	public static List<projectProject> getProjectProject() throws IOException {
		List<projectProject> projectProjectList = new ArrayList<projectProject>();
		ReadCSV readProjectProject = new ReadCSV("projectProject.csv");
		try {
			while (true) {
				List<String> tuple = readProjectProject.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				projectProject projectRelation = new projectProject();
				projectRelation.setProject_id_1(Integer.parseInt(i.next()));
				projectRelation.setProject_id_2(Integer.parseInt(i.next()));
				projectProjectList.add(projectRelation);
			}
			System.out.println("projectProject loaded from CSV file");	
			return projectProjectList;
		} finally {
			readProjectProject.close();
		}
	}
	
	public static List<ActiveProjectUsers> getActiveProjectUsers() throws IOException {
		List<ActiveProjectUsers> activeProjectUserList = new ArrayList<ActiveProjectUsers>();
		ReadCSV readActiveProjectUsers = new ReadCSV("activeProjectUsers.csv");
		try {
			while (true) {
				List<String> tuple = readActiveProjectUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				ActiveProjectUsers activeProjectUser = new ActiveProjectUsers();
				activeProjectUser.setActiveProjectID(Integer.parseInt(i.next()));
				activeProjectUser.setUserID(Integer.parseInt(i.next()));
				activeProjectUserList.add(activeProjectUser);
			}
			System.out.println("activeProjectUsers loaded from CSV file");
			return activeProjectUserList;
		} finally {
			readActiveProjectUsers.close();
		}
	}
	
	public static List<ActiveProject> getActiveProjects() throws IOException {
		List<ActiveProject> activeProjectList = new ArrayList<ActiveProject>();
		ReadCSV readActiveProjects = new ReadCSV("activeProjects.csv");
		try {
			while (true) {
				List<String> tuple = readActiveProjects.next();
				if (tuple == null) {
					break;
				}
				Iterator <String> i = tuple.iterator();
				ActiveProject activeProject = new ActiveProject();
				activeProject.setProject_id_copy_1(Integer.parseInt(i.next()));
				activeProject.setProject_id_copy_2(Integer.parseInt(i.next()));
				activeProject.setUserID(Integer.parseInt(i.next()));
				activeProject.setTitle(i.next());
				activeProject.setDescription(i.next());
				activeProject.setStart(i.next());
				activeProject.setDuration(Integer.parseInt(i.next()));
				activeProject.setProjectType(getProjectTypeFromParameter(i.next()));
				activeProject.setMajors(getMajorListFromString(i.next()));
				activeProject.setClasses(getClassListFromString(i.next()));
				activeProject.setNumStudents(Integer.parseInt(i.next()));
				activeProject.setCost(Double.parseDouble(i.next()));
				activeProject.setFunded(Boolean.parseBoolean(i.next()));
				activeProject.setDeadline(i.next());
				activeProject.setBudget(Integer.parseInt(i.next()));
				activeProjectList.add(activeProject);
			}
			System.out.println("activeProjects loaded from CSV file");
			return activeProjectList;
		} finally {
			readActiveProjects.close();
		}
	}
	
	public static List<PastProject> getPastProjects() throws IOException {
		List<PastProject> pastProjectList = new ArrayList<PastProject>();
		ReadCSV readPastProjects = new ReadCSV("pastProjects.csv");
		try {
			while (true) {
				List<String> tuple = readPastProjects.next();
				if (tuple == null) {
					break;
				}
				Iterator <String> i = tuple.iterator();
				PastProject pastProject = new PastProject();
				pastProject.setProject_id_copy_5(Integer.parseInt(i.next()));
				pastProject.setProject_id_copy_6(Integer.parseInt(i.next()));
				pastProject.setUserID(Integer.parseInt(i.next()));
				pastProject.setTitle(i.next());
				pastProject.setDescription(i.next());
				pastProject.setStart(i.next());
				pastProject.setDuration(Integer.parseInt(i.next()));
				pastProject.setProjectType(getProjectTypeFromParameter(i.next()));
				pastProject.setMajors(getMajorListFromString(i.next()));
				pastProject.setClasses(getClassListFromString(i.next()));
				pastProject.setNumStudents(Integer.parseInt(i.next()));
				pastProject.setCost(Double.parseDouble(i.next()));
				pastProject.setFunded(Boolean.parseBoolean(i.next()));
				pastProject.setDeadline(i.next());
				pastProject.setBudget(Integer.parseInt(i.next()));
				pastProjectList.add(pastProject);
			}
			System.out.println("pastProjects loaded from CSV file");
			return pastProjectList;
		} finally {
			readPastProjects.close();
		}
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
	
	private static ArrayList<MajorType> getMajorListFromString(String s) {
		ArrayList<MajorType> majors = new ArrayList<MajorType>();
		StringTokenizer st = new StringTokenizer(s);
	     while (st.hasMoreTokens()) {
	         majors.add(getMajorTypeFromParameter(st.nextToken()));
	     }
	     return majors;
	}
	
	private static ArrayList<ClassType> getClassListFromString(String s) {
		ArrayList<ClassType> classes = new ArrayList<ClassType>();
		StringTokenizer st = new StringTokenizer(s);
	     while (st.hasMoreTokens()) {
	         classes.add(getClassTypeFromParameter(st.nextToken()));
	     }
	     return classes;
	}
	
	private static Boolean getBoolFromString(String s) {
		if (s.equals("true")) {
			return true;
		} else {
			return false;
		}
	}
}
