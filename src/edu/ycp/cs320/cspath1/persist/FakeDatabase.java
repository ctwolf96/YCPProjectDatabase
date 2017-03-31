package edu.ycp.cs320.cspath1.persist;

import java.io.IOException;
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

public class FakeDatabase implements IDatabase {
	
	private List<Solicitation> solicitationList;
	private List<Student> studentList;
	private List<Faculty> facultyList;
	
	public FakeDatabase(){
		
		this.studentList = new ArrayList<Student>();
		this.facultyList = new ArrayList<Faculty>();
		this.solicitationList = new ArrayList<Solicitation>();
		
		readInitialData();
		
		System.out.println(studentList.size() + " students");
		System.out.println(facultyList.size() + " faculty");
		System.out.println(solicitationList.size() + " solicitations");
	}
	
	
	public void readInitialData() {
		try {
			studentList.addAll(InitialData.getStudents());
			facultyList.addAll(InitialData.getFaculty());
			solicitationList.addAll(InitialData.getSolicitations());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}


	@Override
	public List<Student> findStudentByLastname(String lastname) {
		List<Student> result = new ArrayList<Student>();
		for (Student student : studentList){
			if(student.getLastname().equals(lastname)) {
				result.add(student);
			}
		}
		return result;
	}


	@Override
	public List<Student> findStudentByFirstname(String firstname) {
		List<Student> result = new ArrayList<Student>();
		for (Student student : studentList){
			if(student.getFirstname().equals(firstname)) {
				result.add(student);
			}
		}
		return result;
	}


	@Override
	public Student findStudentByUsername(String username) {
		Student result = new Student();
		for (Student student : studentList){
			if(student.getUsername().equals(username)) {
				result = student;
				return result;
			}
		}
		return null;
	}

	@Override
	public List<Student> findStudentByMajorType(MajorType major) {
		List<Student> result = new ArrayList<Student>();
		for (Student student : studentList){
			if(student.getMajor().equals(major)){
				result.add(student);
			}
		}
		return result;
	}


	@Override
	public List<Student> findStudentByClassType(ClassType classtype) {
		List<Student> result = new ArrayList<Student>();
		for (Student student : studentList){
			if(student.getClassLevel().equals(classtype)){
				result.add(student);
			}
		}
		return result;
	}


	@Override
	public List<Faculty> findFacultyByLastname(String lastname) {
		List<Faculty> faculty = new ArrayList<Faculty>();
		for (Faculty facultyUser : facultyList) {
			if (facultyUser.getLastname().equals(lastname)){
				faculty.add(facultyUser);
				
			}
		}
		return faculty;
	}


	@Override
	public Student findStudentByUsernameAndPassword(String password, String username) {
		Student result = new Student();
		for (Student student : studentList){
			if (student.getPassword().equals(password) && student.getUsername().equals(username)){
				result = student;
				return result;
			}
		}
		return result;
	}


	@Override
	public List<Faculty> findFacultyByFirstname(String firstname) {
		List<Faculty> faculty = new ArrayList<Faculty>();
		for (Faculty facultyUser : facultyList) {
			if (facultyUser.getFirstname().equals(firstname)){
				faculty.add(facultyUser);
				
			}
		}
		return faculty;
	}


	@Override
	public List<Faculty> findFacultyByMajorType(MajorType major) {
		List<Faculty> faculty = new ArrayList<Faculty>();
		for (Faculty facultyUser : facultyList) {
			if (facultyUser.getMajor().equals(major)){
				faculty.add(facultyUser);
				
			}
		}
		return faculty;
	}


	@Override
	public Faculty findFacultyByUsername(String username) {
		Faculty result = new Faculty();
		for (Faculty faculty : facultyList){
			if (faculty.getUsername().equals(username)){
				result = faculty;
				return faculty;
			}
		}
		return result;
	}


	@Override
	public Faculty findFacultybyUsernameAndPassword(String username, String password) {
		Faculty result = new Faculty();
		for (Faculty faculty : facultyList) {
			if (faculty.getUsername().equals(username) && faculty.getPassword().equals(password)){
				return faculty;
			}
		}
		return result;
	}


	@Override
	public User findUserbyUserID(int UserID) {
		
		for (Faculty faculty : facultyList) {
			if (faculty.getUserID() == UserID){
				return faculty;
			}
		}
		for (Student student : studentList) {
			if (student.getUserID() == UserID){
				return student;
			}
		}
		return null;
	}


	@Override
	public List<User> findUserByUserType(UserType usertype) {
		List<User> userList = new ArrayList<User>();
		for (Faculty faculty : facultyList){
			if (faculty.getUsertype().equals(usertype)){
				userList.add(faculty);
			}
		}
		for (Student student : studentList){
			if (student.getUsertype().equals(usertype)){
				userList.add(student);
			}
		}
		return userList;
	}


	@Override
	public List<Solicitation> findSolicitationsByMajorType(MajorType majortype) {
		List<Solicitation> result = new ArrayList<Solicitation>();
		for (Solicitation solicitation : solicitationList){
			if (solicitation.getMajors().contains(majortype)){
				result.add(solicitation);
			}
		}
		return result;
	}

	//this is probably broken
	@Override
	public List<Solicitation> findSolicitationsByMajorTypes(ArrayList<MajorType> majors) {
		List<Solicitation> result = new ArrayList<Solicitation>();
		for (Solicitation solicitation : solicitationList){
			for(MajorType major : majors){
				if (solicitation.getMajors().contains(major)){
					if(!result.contains(solicitation)){
						result.add(solicitation);
					}
				}
			}
		}
		return result;
	}


	@Override
	public List<Solicitation> findSolicitationsByClassType(ClassType classtype) {
		List<Solicitation> result = new ArrayList<Solicitation>();
		for (Solicitation solicitation : solicitationList){
			if (solicitation.getClasses().contains(classtype)){
				result.add(solicitation);
			}
		}
		return result;
	}


	@Override
	public List<Solicitation> findSolicitationsByClassTypes(ArrayList<ClassType> classtypes) {
		List<Solicitation> result = new ArrayList<Solicitation>();
		for (Solicitation solicitation : solicitationList){
			for(ClassType classtype : classtypes){
				if (solicitation.getClasses().contains(classtype)){
					if(!result.contains(solicitation)){
						result.add(solicitation);
					}
				}
			}
		}
		return result;
	}


	@Override
	public List<Solicitation> findSolicitationsByStartTime(String startTime) {
		List<Solicitation> result = new ArrayList<Solicitation>();
		for (Solicitation solicitation : solicitationList){
			if (solicitation.getStartTime().equals(startTime)){
				result.add(solicitation);
			}
		}
		return result;
	}


	@Override
	public List<Solicitation> findSolicitationsByDuration(String duration) {
		List<Solicitation> result = new ArrayList<Solicitation>();
		for (Solicitation solicitation : solicitationList){
			if (solicitation.getDuration().equals(duration)){
				result.add(solicitation);
			}
		}
		return result;
	}


	@Override
	public List<Solicitation> findSolicitationsByNumStudents(int numStudents) {
		List<Solicitation> result = new ArrayList<Solicitation>();
		for (Solicitation solicitation : solicitationList){
			if (solicitation.getNumStudents() == numStudents){
				result.add(solicitation);
			}
		}
		return result;
	}


	@Override
	public List<Solicitation> findSolicitationsBySolicitationType(SolicitationType solicitationType) {
		List<Solicitation> result = new ArrayList<Solicitation>();
		for (Solicitation solicitation : solicitationList){
			if(solicitation.getSolicitationType().equals(solicitationType)){
				result.add(solicitation);
			}
		}
		return result;
	}


	@Override
	public Solicitation findSolicitationByProjectID(int projectID) {
		for (Solicitation solicitation : solicitationList){
			if (solicitation.getProjectID() == projectID){
				return solicitation;
			}
		}
		return null;
	}

	@Override
	public void insertUser(String username, String password, String email, UserType usertype) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void insertProject(User creator, String title, String description, int userid) {
		// TODO Auto-generated method stub
		
	}	
}
