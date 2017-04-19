package edu.ycp.cs320.cspath1.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
					user.setFirstname(i.next());
					user.setLastname(i.next());
					user.setMajor(getMajorTypeFromParameter(i.next()));
					userList.add(user);
				} else if (user.getUsertype().equals(UserType.BUSINESS)) {
					Business business = new Business();
					business.setUserID(user.getUserID());
					business.setUsername(user.getUsername());
					business.setPassword(user.getPassword());
					business.setEmail(user.getPassword());
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
	
	public static List<User> getProjects() throws IOException {
		List<Project> projectList = new ArrayList<Project>();
		ReadCSV readUser = new ReadCSV("Projects.CSV");
		try {
			Integer projectID = 0;
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
					user.setFirstname(i.next());
					user.setLastname(i.next());
					user.setMajor(getMajorTypeFromParameter(i.next()));
					userList.add(user);
				} else if (user.getUsertype().equals(UserType.BUSINESS)) {
					Business business = new Business();
					business.setUserID(user.getUserID());
					business.setUsername(user.getUsername());
					business.setPassword(user.getPassword());
					business.setEmail(user.getPassword());
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
	
	public static List<Solicitation> getSolicitations() throws IOException {
		List<Solicitation> solicitationList = new ArrayList<Solicitation>();
		ReadCSV readSolicitations = new ReadCSV("Solicitations.CSV");
		try {
			Integer projectID = 1;
			while (true) {
				List<String> tuple = readSolicitations.next();
				ArrayList<MajorType> majors = new ArrayList<MajorType>();
				ArrayList<ClassType> classes = new ArrayList<ClassType>();
				if (tuple == null){
					break;
				}
				
				Iterator<String> i = tuple.iterator();
				Solicitation solicitation = new Solicitation();
				solicitation.setProjectID(projectID++);
				Integer userID = Integer.parseInt(i.next());
//				solicitation.setUserID(userID);
				MajorType CS = getMajorTypeFromParameter(i.next());
				if (CS != null) {
					majors.add(CS);
				}
				MajorType CE = getMajorTypeFromParameter(i.next());
				if (CE != null) {
					majors.add(CE);
				}
				MajorType EE = getMajorTypeFromParameter(i.next());
				if (EE != null){
					majors.add(EE);
				}
				MajorType ME = getMajorTypeFromParameter(i.next());
				if (ME != null){
					majors.add(ME);
				}
				MajorType CIV = getMajorTypeFromParameter(i.next());
				if (CIV != null){
					majors.add(CIV);
				}
				solicitation.setMajors(majors);
				ClassType FR = getClassTypeFromParameter(i.next());
				if (FR != null){
					classes.add(FR);
				}
				ClassType SO = getClassTypeFromParameter(i.next());
				if (SO != null) {
					classes.add(SO);
				}
				ClassType JR = getClassTypeFromParameter(i.next());
				if (JR != null){
					classes.add(JR);
				}
				ClassType SR = getClassTypeFromParameter(i.next());
				if (SR != null){
					classes.add(SR);
				}
				solicitation.setClasses(classes);
				solicitation.setDuration(i.next());
				solicitation.setNumStudents(Integer.parseInt(i.next()));
				SolicitationType solicitationType = getSolicitationTypeFromParameter(i.next());
				solicitation.setSolicitationType(solicitationType);
				solicitationList.add(solicitation);
			} 
			return solicitationList;
		}
		finally {
			readSolicitations.close();
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
	
}
