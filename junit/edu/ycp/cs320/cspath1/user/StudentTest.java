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
	public void testSetFirstname() {
		student.setFirstname("Corey");
		assertEquals("Corey", student.getFirstname());
		student.setFirstname("Cody");
		assertEquals("Cody", student.getFirstname());
		student.setFirstname("Joe");
		assertEquals("Joe", student.getFirstname());
		student.setFirstname("Jason");
		assertEquals("Jason", student.getFirstname());
	}
	
	@Test
	public void testSetLastname() {
		student.setLastname("Wolf");
		assertEquals("Wolf", student.getLastname());
		student.setLastname("Spath");
		assertEquals("Spath", student.getLastname());
		student.setLastname("Hopkins");
		assertEquals("Hopkins", student.getLastname());
		student.setLastname("Bady");
		assertEquals("Bady", student.getLastname());
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
