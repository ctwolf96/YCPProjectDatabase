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
	public void testSetUsername() {
		prof.setUsername("cspath1");
		String username1 = prof.getUsername();
		prof.setUsername("jbady");
		String username2 = prof.getUsername();
		prof.setUsername("cwolf11");
		String username3 = prof.getUsername();
		prof.setUsername("jhopkins1");
		String username4 = prof.getUsername();
		assertEquals(username1, "cspath1");
		assertEquals(username2, "jbady");
		assertEquals(username3, "cwolf11");
		assertEquals(username4, "jhopkins1");
	}
	
	@Test
	public void testSetPassword(){
		prof.setPassword("password1");
		String password1 = prof.getPassword();
		prof.setPassword("password2");
		String password2 = prof.getPassword();
		prof.setPassword("password3");
		String password3 = prof.getPassword();
		prof.setPassword("password4");
		String password4 = prof.getPassword();
		assertEquals(password1, "password1");
		assertEquals(password2, "password2");
		assertEquals(password3, "password3");
		assertEquals(password4, "password4");
	}

	@Test
	public void testSetEmail(){
		prof.setEmail("cspath1@ycp.edu");
		String email1 = prof.getEmail();
		prof.setEmail("jbady@ycp.edu");
		String email2 = prof.getEmail();
		prof.setEmail("cwolf11@ycp.edu");
		String email3 = prof.getEmail();
		prof.setEmail("jhopkins1@ycp.edu");
		String email4 = prof.getEmail();
		assertEquals(email1, "cspath1@ycp.edu");
		assertEquals(email2, "jbady@ycp.edu");
		assertEquals(email3, "cwolf11@ycp.edu");
		assertEquals(email4, "jhopkins1@ycp.edu");
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
