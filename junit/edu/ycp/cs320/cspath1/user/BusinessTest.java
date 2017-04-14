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
	
	@Test
	public void testSetName() {
		business.setName("Red Lion Controls");
		assertEquals("Red Lion Controls", business.getName());
		business.setName("Dataforma");
		assertEquals("Dataforma", business.getName());
		business.setName("Johnson Controls");
		assertEquals("Johnson Controls", business.getName());
		business.setName("Becton Dickinson");
		assertEquals("Becton Dickinson", business.getName());
	}

}
