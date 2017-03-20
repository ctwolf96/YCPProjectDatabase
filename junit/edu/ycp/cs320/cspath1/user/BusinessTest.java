package edu.ycp.cs320.cspath1.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BusinessTest {
	Business business;

	@Before
	public void setUp() {
		business = new Business();
	}

	@Test
	public void testSetUsername() {
		business.setUsername("cspath1");
		String username1 = business.getUsername();
		business.setUsername("jbady");
		String username2 = business.getUsername();
		business.setUsername("cwolf11");
		String username3 = business.getUsername();
		business.setUsername("jhopkins1");
		String username4 = business.getUsername();
		assertEquals(username1, "cspath1");
		assertEquals(username2, "jbady");
		assertEquals(username3, "cwolf11");
		assertEquals(username4, "jhopkins1");
	}
	
	@Test
	public void testSetPassword(){
		business.setPassword("password1");
		String password1 = business.getPassword();
		business.setPassword("password2");
		String password2 = business.getPassword();
		business.setPassword("password3");
		String password3 = business.getPassword();
		business.setPassword("password4");
		String password4 = business.getPassword();
		assertEquals(password1, "password1");
		assertEquals(password2, "password2");
		assertEquals(password3, "password3");
		assertEquals(password4, "password4");
	}

	@Test
	public void testSetEmail(){
		business.setEmail("cspath1@ycp.edu");
		String email1 = business.getEmail();
		business.setEmail("jbady@ycp.edu");
		String email2 = business.getEmail();
		business.setEmail("cwolf11@ycp.edu");
		String email3 = business.getEmail();
		business.setEmail("jhopkins1@ycp.edu");
		String email4 = business.getEmail();
		assertEquals(email1, "cspath1@ycp.edu");
		assertEquals(email2, "jbady@ycp.edu");
		assertEquals(email3, "cwolf11@ycp.edu");
		assertEquals(email4, "jhopkins1@ycp.edu");
	}
	
	@Test
	public void testSetNumber() {
		business.setNumber("717-589-7416");
		assertEquals("717-589-7416", business.getNumber());
		business.setNumber("7174593614");
		assertEquals("7174593614", business.getNumber());
		business.setNumber("+18184762348");
		assertEquals("+18184762348", business.getNumber());
		business.setNumber("446-231-7843");
		assertEquals("446-231-7843", business.getNumber());
	}
	
	@Test 
	public void testSetAddress() {
		business.setAddress("35 Main Street, York, PA");
		assertEquals("35 Main Street, York, PA", business.getAddress());
		business.setAddress("4715 N Queen St, Gettysburg, PA");
		assertEquals("4715 N Queen St, Gettysburg, PA", business.getAddress());
		business.setAddress("833 Broadway Rd, Seven Valleys, PA");
		assertEquals("833 Broadway Rd, Seven Valleys, PA", business.getAddress());
		business.setAddress("15 John Street, Railroad, PA");
		assertEquals("15 John Street, Railroad, PA", business.getAddress());
	}

}
