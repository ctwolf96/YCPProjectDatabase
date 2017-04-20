package edu.ycp.cs320.cspath1.user;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.cspath1.enums.UserType;

public class UserTest {
	User user;
	
	@Before
	public void setUp() {
		user = new Student();
	}

	@Test
	public void testSetUsername() {
		user.setUsername("cspath1");
		String username1 = user.getUsername();
		user.setUsername("jbady");
		String username2 = user.getUsername();
		user.setUsername("cwolf11");
		String username3 = user.getUsername();
		user.setUsername("jhopkins1");
		String username4 = user.getUsername();
		assertEquals(username1, "cspath1");
		assertEquals(username2, "jbady");
		assertEquals(username3, "cwolf11");
		assertEquals(username4, "jhopkins1");
	}
	
	@Test
	public void testSetPassword(){
		user.setPassword("password1");
		String password1 = user.getPassword();
		user.setPassword("password2");
		String password2 = user.getPassword();
		user.setPassword("password3");
		String password3 = user.getPassword();
		user.setPassword("password4");
		String password4 = user.getPassword();
		assertEquals(password1, "password1");
		assertEquals(password2, "password2");
		assertEquals(password3, "password3");
		assertEquals(password4, "password4");
	}

	@Test
	public void testSetEmail(){
		user.setEmail("cspath1@ycp.edu");
		String email1 = user.getEmail();
		user.setEmail("jbady@ycp.edu");
		String email2 = user.getEmail();
		user.setEmail("cwolf11@ycp.edu");
		String email3 = user.getEmail();
		user.setEmail("jhopkins1@ycp.edu");
		String email4 = user.getEmail();
		assertEquals(email1, "cspath1@ycp.edu");
		assertEquals(email2, "jbady@ycp.edu");
		assertEquals(email3, "cwolf11@ycp.edu");
		assertEquals(email4, "jhopkins1@ycp.edu");
	}
	
	@Test
	public void testSetUserType() {
		user.setUsertype(UserType.STUDENT);
		assertEquals(UserType.STUDENT, user.getUsertype());
		user.setUsertype(UserType.FACULTY);
		assertEquals(UserType.FACULTY, user.getUsertype());
		user.setUsertype(UserType.BUSINESS);
		assertEquals(UserType.BUSINESS, user.getUsertype());
		user.setUsertype(UserType.ADMIN);
		assertEquals(UserType.ADMIN, user.getUsertype());
	}
	
	@Test
	public void testSetUserID() {
		user.setUserID(1);
		assertEquals(1, user.getUserID());
		user.setUserID(2);
		assertEquals(2, user.getUserID());
		user.setUserID(3);
		assertEquals(3, user.getUserID());
		user.setUserID(4);
		assertEquals(4, user.getUserID());
	}
}
