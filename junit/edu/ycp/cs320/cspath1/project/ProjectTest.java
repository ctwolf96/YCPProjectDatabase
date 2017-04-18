package edu.ycp.cs320.cspath1.project;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProjectTest {
	Project project;
	
	@Before 
	public void setUp() {
		project = new Proposal();
	}
	
	@Test
	public void testSetProjectID() {
		project.setProjectID(1);
		assertEquals(1, project.getProjectID());
		project.setProjectID(2);
		assertEquals(2, project.getProjectID());
		project.setProjectID(3);
		assertEquals(3, project.getProjectID());
		project.setProjectID(4);
		assertEquals(4, project.getProjectID());
	}
	
	@Test
	public void testSetUserID() {
		project.setUserID(1);
		assertEquals(1, project.getUserID());
		project.setUserID(2);
		assertEquals(2, project.getUserID());
		project.setUserID(3);
		assertEquals(3, project.getUserID());
		project.setUserID(4);
		assertEquals(4, project.getUserID());
	}
	
	@Test
	public void testSetTitle() {
		project.setTitle("YCP Project Database");
		assertEquals("YCP Project Database", project.getTitle());
	}
	
	@Test
	public void testSetDescription() {
		
	}
	
	@Test
	public void testSetStart() {
		
	}
	
	@Test
	public void testSetDuration() {
		
	}
	
	@Test
	public void testSetProjectType() {
		
	}
}
