package edu.ycp.cs320.cspath1.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.cspath1.enums.MajorType;

public class FacultyTest {
	Faculty prof;

	@Before
	public void setUp() {
		prof = new Faculty();
	}
	@Test
	public void testSetFirstname() {
		prof.setFirstname("Corey");
		assertEquals("Corey", prof.getFirstname());
		prof.setFirstname("Cody");
		assertEquals("Cody", prof.getFirstname());
		prof.setFirstname("Joe");
		assertEquals("Joe", prof.getFirstname());
		prof.setFirstname("Jason");
		assertEquals("Jason", prof.getFirstname());
	}
	
	@Test
	public void testSetLastname() {
		prof.setLastname("Wolf");
		assertEquals("Wolf", prof.getLastname());
		prof.setLastname("Spath");
		assertEquals("Spath", prof.getLastname());
		prof.setLastname("Hopkins");
		assertEquals("Hopkins", prof.getLastname());
		prof.setLastname("Bady");
		assertEquals("Bady", prof.getLastname());
	}
	
	@Test 
	public void testSetMajor() {
		prof.setMajor(MajorType.CE);
		assertEquals(MajorType.CE, prof.getMajor());
		prof.setMajor(MajorType.EE);
		assertEquals(MajorType.EE, prof.getMajor());
		prof.setMajor(MajorType.ME);
		assertEquals(MajorType.ME, prof.getMajor());
		prof.setMajor(MajorType.CS);
		assertEquals(MajorType.CS, prof.getMajor());
	}

}
