package edu.ycp.cs320.cspath1.project;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.cspath1.enums.ProjectType;

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
		project.setDescription("This project allows for businesses to propose projects as well the solicitation of projects by students");
		assertEquals("This project allows for businesses to propose projects as well the solicitation of projects by students", project.getDescription());
	}
	
	@Test
	public void testSetStart() {
		project.setStart("June 5, 2017");
		assertEquals("June 5, 2017", project.getStart());
	}
	
	@Test
	public void testSetDuration() {
		project.setDuration(1);
		assertEquals(project.getDuration(), 1);
		project.setDuration(2);
		assertEquals(project.getDuration(), 2);
		project.setDuration(3);
		assertEquals(project.getDuration(), 3);
		project.setDuration(4);
		assertEquals(project.getDuration(), 4);
	}
	
	@Test
	public void testSetProjectType() {
		project.setProjectType(ProjectType.PROPOSAL);
		assertEquals(ProjectType.PROPOSAL, project.getProjectType());
		project.setProjectType(ProjectType.SOLICITATION);
		assertEquals(ProjectType.SOLICITATION, project.getProjectType());
		project.setProjectType(ProjectType.ACTIVE);
		assertEquals(ProjectType.ACTIVE, project.getProjectType());
		project.setProjectType(ProjectType.PAST);
		assertEquals(ProjectType.PAST, project.getProjectType());
	}
}
