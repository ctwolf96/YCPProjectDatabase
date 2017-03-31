package edu.ycp.cs320.cspath1.persist;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.UserType;
import edu.ycp.cs320.cspath1.project.Solicitation;
import edu.ycp.cs320.cspath1.user.Faculty;
import edu.ycp.cs320.cspath1.user.Student;
import edu.ycp.cs320.cspath1.user.User;

public class FakeDatabaseTest {
	private FakeDatabase fake = new FakeDatabase();
	

	
	
	@Test
	public void testFindStudentByLastname(){
		List<Student> students = new ArrayList<Student>();
		students = fake.findStudentByLastname("Spath");
		assertEquals(students.size(), 1);
		students = fake.findStudentByLastname("Bady");
		assertEquals(students.size(), 1);
		students = fake.findStudentByLastname("Wolf");
		assertEquals(students.size(), 1);
		students = fake.findStudentByLastname("Hopkins");
		assertEquals(students.size(), 1);
		students = fake.findStudentByLastname("Jones");
		assertEquals(students.size(), 2);
		
	}
	
	@Test
	public void testFindStudentByFirstname(){
		List<Student> students = new ArrayList<Student>();
		students = fake.findStudentByFirstname("Cody");
		assertEquals(students.size(), 1);
		students = fake.findStudentByFirstname("Joseph");
		assertEquals(students.size(), 1);
		students = fake.findStudentByFirstname("Jason");
		assertEquals(students.size(), 2);
		students = fake.findStudentByFirstname("Corey");
		assertEquals(students.size(), 1);
	}
	
	@Test
	public void testFindStudentsByMajorType(){
		List<Student> students = new ArrayList<Student>();
		students = fake.findStudentByMajorType(MajorType.CS);
		assertEquals(students.size(), 26);
		students = fake.findStudentByMajorType(MajorType.CE);
		assertEquals(students.size(), 6);
		students = fake.findStudentByMajorType(MajorType.EE);
		assertEquals(students.size(), 4);
		students = fake.findStudentByMajorType(MajorType.ME);
		assertEquals(students.size(), 0);
		students = fake.findStudentByMajorType(MajorType.UN);
		assertEquals(students.size(), 1);
	}
	
	@Test
	public void testFindStudentsByClassType(){
		List<Student> students = new ArrayList<Student>();
		students = fake.findStudentByClassType(ClassType.FRESHMAN);
		assertEquals(students.size(), 0);
		students = fake.findStudentByClassType(ClassType.SOPHOMORE);
		assertEquals(students.size(), 21);
		students = fake.findStudentByClassType(ClassType.JUNIOR);
		assertEquals(students.size(), 9);
		students = fake.findStudentByClassType(ClassType.SENIOR);
		assertEquals(students.size(), 7);
	} 
	
	@Test
	public void testFindStudentByUsername(){
		Student student = new Student();
		student = fake.findStudentByUsername("cspath1");
		assertEquals(student.getUsername(), "cspath1");
		student = fake.findStudentByUsername("jbady");
		assertEquals(student.getUsername(), "jbady");
		student = fake.findStudentByUsername("cwolf11");
		assertEquals(student.getUsername(), "cwolf11");
		student = fake.findStudentByUsername("jhopkins1");
		assertEquals(student.getUsername(), "jhopkins1");
	}
	
	@Test
	public void testFindStudentByUsernameAndPassword(){
		Student student = new Student();
		String password = "password";
		student = fake.findStudentByUsernameAndPassword(password, "cspath1");
		assertEquals(student.getFirstname(), "Cody");
		student = fake.findStudentByUsernameAndPassword(password, "jbady");
		assertEquals(student.getLastname(), "Bady");
		student = fake.findStudentByUsernameAndPassword(password, "jamoros");
		assertEquals(student.getUserID(), 18);
		student = fake.findStudentByUsernameAndPassword(password, "dmcclellan");
		assertEquals(student.getMajor(), MajorType.CS);
		
	}
	
	@Test
	public void testFindFacultyByLastname(){
		List<Faculty> faculty = new ArrayList<Faculty>();
		faculty = fake.findFacultyByLastname("Hake");
		assertEquals(faculty.size(), 1);
		faculty = fake.findFacultyByLastname("Garrison");
		assertEquals(faculty.size(), 2);
		faculty = fake.findFacultyByLastname("Babcock");
		assertEquals(faculty.size(), 1);
	}
	
	@Test
	public void testFindFacultyByFirstname(){
		List<Faculty> faculty = new ArrayList<Faculty>();
		faculty = fake.findFacultyByFirstname("Don");
		assertEquals(faculty.size(), 1);
		faculty = fake.findFacultyByFirstname("David");
		assertEquals(faculty.size(), 2);
		faculty = fake.findFacultyByFirstname("Tristan");
		assertEquals(faculty.size(), 1);
	}
	
	@Test
	public void testFindFacultyByUsername(){
		Faculty faculty = new Faculty();
		faculty = fake.findFacultyByUsername("djhake2");
		assertEquals(faculty.getUsername(), "djhake2");
		faculty = fake.findFacultyByUsername("shamilton");
		assertEquals(faculty.getLastname(), "Hamilton");
		faculty = fake.findFacultyByUsername("jmoscola");
		assertEquals(faculty.getFirstname(), "James");
		
	}
	
	@Test
	public void testFindFacultyByMajorType(){
		List<Faculty> result = new ArrayList<Faculty>();
		result = fake.findFacultyByMajorType(MajorType.CE);
		assertEquals(result.size(), 2);
		result = fake.findFacultyByMajorType(MajorType.CS);
		assertEquals(result.size(), 5);
		result = fake.findFacultyByMajorType(MajorType.EE);
		assertEquals(result.size(), 2);
		result = fake.findFacultyByMajorType(MajorType.ME);
		assertEquals(result.size(), 7);
		result = fake.findFacultyByMajorType(MajorType.CIV);
		assertEquals(result.size(), 1);
		
	}
	
	@Test
	public void testFacultyByUsernameAndPassword(){
		Faculty faculty = new Faculty();
		String password = "password";
		faculty = fake.findFacultybyUsernameAndPassword("djhake2", password);
		assertEquals(faculty.getUserID(), 8);
		faculty = fake.findFacultybyUsernameAndPassword("jmoscola", password);
		assertEquals(faculty.getMajor(), MajorType.CS);
		faculty = fake.findFacultybyUsernameAndPassword("dhovemey", password);
		assertEquals(faculty.getFirstname(), "David");
		faculty = fake.findFacultybyUsernameAndPassword("swilkerson", password);
		assertEquals(faculty.getLastname(), "Wilkerson");
	}
	
	@Test
	public void testFindUserByUserID(){
		User user = fake.findUserbyUserID(3);
		assertEquals(user.getUsername(), "ecelik");
		user = fake.findUserbyUserID(6);
		assertEquals(user.getUsername(), "lgarriso");
		user = fake.findUserbyUserID(8);
		assertEquals(user.getUsername(), "djhake2");
		user = fake.findUserbyUserID(15);
		assertEquals(user.getUsername(), "jmoscola");
		user = fake.findUserbyUserID(23);
		assertEquals(user.getUsername(), "dglispy");
		user = fake.findUserbyUserID(34);
		assertEquals(user.getUsername(), "dmcclellan");
		user = fake.findUserbyUserID(55);
		assertEquals(user.getUsername(), "guest1");
	}
	
	@Test
	public void testFindUserByUserType(){
		List <User> users = fake.findUserByUserType(UserType.GUEST);
		assertEquals(users.size(), 10);
		users = fake.findUserByUserType(UserType.FACULTY);
		assertEquals(users.size(), 17);
		users = fake.findUserByUserType(UserType.STUDENT);
		assertEquals(users.size(), 37);
		
	}
	
	@Test
	public void testFindSolicitationsByMajorType() {
		List<Solicitation> solicitations = fake.findSolicitationsByMajorType(MajorType.CE);
		assertEquals(solicitations.size(), 5);
		solicitations = fake.findSolicitationsByMajorType(MajorType.CS);
		assertEquals(solicitations.size(), 6);
		solicitations = fake.findSolicitationsByMajorType(MajorType.EE);
		assertEquals(solicitations.size(), 2);
		solicitations = fake.findSolicitationsByMajorType(MajorType.ME);
		assertEquals(solicitations.size(), 3);
		solicitations = fake.findSolicitationsByMajorType(MajorType.CIV);
		assertEquals(solicitations.size(), 2);
		
	}
	
	@Test
	public void testFindSolicitationsByMajorTypes(){
		ArrayList<MajorType> majors = new ArrayList<MajorType>();
		majors.add(MajorType.CE);
		majors.add(MajorType.CS);
		List<Solicitation> solicitations = fake.findSolicitationsByMajorTypes(majors);
		assertEquals(solicitations.size(), 10);
		majors.remove(MajorType.CE);
		majors.add(MajorType.EE);
		solicitations = fake.findSolicitationsByMajorTypes(majors);
		assertEquals(solicitations.size(), 7);
	}
	
	@Test
	public void testFindSolicitationsByClassType(){
		List<Solicitation> solicitations = new ArrayList<Solicitation>();
		solicitations = fake.findSolicitationsByClassType(ClassType.FRESHMAN);
		assertEquals(solicitations.size(), 0);
		solicitations = fake.findSolicitationsByClassType(ClassType.SOPHOMORE);
		assertEquals(solicitations.size(), 2);
		solicitations = fake.findSolicitationsByClassType(ClassType.JUNIOR);
		assertEquals(solicitations.size(), 8);
		solicitations = fake.findSolicitationsByClassType(ClassType.SENIOR);
		assertEquals(solicitations.size(), 12);
	}
	
	@Test
	public void testFindSolicitationsByClassTypes(){
		ArrayList<ClassType> classes = new ArrayList<ClassType>();
		classes.add(ClassType.FRESHMAN);
		classes.add(ClassType.SOPHOMORE);
		List<Solicitation> solicitations = fake.findSolicitationsByClassTypes(classes);
		assertEquals(solicitations.size(), 2);
		classes.add(ClassType.SENIOR);
		solicitations = fake.findSolicitationsByClassTypes(classes);
		assertEquals(solicitations.size(), 12);
	}
	
	@Test
	public void testFindSolicitationsByStartTime(){
		List<Solicitation> solicitations = new ArrayList<Solicitation>();
		solicitations = fake.findSolicitationsByStartTime("3/21/17");
		assertEquals(solicitations.size(), 12);
		solicitations = fake.findSolicitationsByStartTime("2/22/17");
		assertEquals(solicitations.size(), 0);
		
	}
	
	@Test
	public void testFindSolicitationsByDuration(){
		List<Solicitation> solicitations = new ArrayList<Solicitation>();
		solicitations = fake.findSolicitationsByDuration("1 semester");
		assertEquals(solicitations.size(), 7);
		solicitations = fake.findSolicitationsByDuration("2 semesters");
		assertEquals(solicitations.size(), 5);
	}
	
	@Test 
	public void testFindSolicitationsByNumStudents(){
		List<Solicitation> solicitations = new ArrayList<Solicitation>();
		solicitations = fake.findSolicitationsByNumStudents(3);
		assertEquals(solicitations.size(), 1);
		solicitations = fake.findSolicitationsByNumStudents(4);
		assertEquals(solicitations.size(), 5);
		solicitations = fake.findSolicitationsByNumStudents(1);
		assertEquals(solicitations.size(), 3);
		solicitations = fake.findSolicitationsByNumStudents(6);
		assertEquals(solicitations.size(), 3);
		
		
	}
	

}
