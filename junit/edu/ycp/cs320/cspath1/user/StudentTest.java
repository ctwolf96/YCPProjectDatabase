package edu.ycp.cs320.cspath1.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;

public class StudentTest {
	Student student;
	
	@Before
	public void setUp() {
		student = new Student();
	}

	@Test
	public void testSetUsername() {
		student.setUsername("cspath1");
		String username1 = student.getUsername();
		student.setUsername("jbady");
		String username2 = student.getUsername();
		student.setUsername("cwolf11");
		String username3 = student.getUsername();
		student.setUsername("jhopkins1");
		String username4 = student.getUsername();
		assertEquals(username1, "cspath1");
		assertEquals(username2, "jbady");
		assertEquals(username3, "cwolf11");
		assertEquals(username4, "jhopkins1");
	}
	
	@Test
	public void testSetPassword(){
		student.setPassword("password1");
		String password1 = student.getPassword();
		student.setPassword("password2");
		String password2 = student.getPassword();
		student.setPassword("password3");
		String password3 = student.getPassword();
		student.setPassword("password4");
		String password4 = student.getPassword();
		assertEquals(password1, "password1");
		assertEquals(password2, "password2");
		assertEquals(password3, "password3");
		assertEquals(password4, "password4");
	}

	@Test
	public void testSetEmail(){
		student.setEmail("cspath1@ycp.edu");
		String email1 = student.getEmail();
		student.setEmail("jbady@ycp.edu");
		String email2 = student.getEmail();
		student.setEmail("cwolf11@ycp.edu");
		String email3 = student.getEmail();
		student.setEmail("jhopkins1@ycp.edu");
		String email4 = student.getEmail();
		assertEquals(email1, "cspath1@ycp.edu");
		assertEquals(email2, "jbady@ycp.edu");
		assertEquals(email3, "cwolf11@ycp.edu");
		assertEquals(email4, "jhopkins1@ycp.edu");
	}
	
	@Test
	public void testSetClassLevel() {
		student.setClassLevel(ClassType.FRESHMAN);
		assertEquals(ClassType.FRESHMAN, student.getClassLevel());
		student.setClassLevel(ClassType.SOPHOMORE);
		assertEquals(ClassType.SOPHOMORE, student.getClassLevel());
		student.setClassLevel(ClassType.JUNIOR);
		assertEquals(ClassType.JUNIOR, student.getClassLevel());
		student.setClassLevel(ClassType.SENIOR);
		assertEquals(ClassType.SENIOR, student.getClassLevel());
	}
	
	@Test 
	public void testSetMajor() {
		student.setMajor(MajorType.CE);
		assertEquals(MajorType.CE, student.getMajor());
		student.setMajor(MajorType.EE);
		assertEquals(MajorType.EE, student.getMajor());
		student.setMajor(MajorType.ME);
		assertEquals(MajorType.ME, student.getMajor());
		student.setMajor(MajorType.CS);
		assertEquals(MajorType.CS, student.getMajor());
	}
}
