package edu.ycp.cs320.cspath1.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;

public class ProjectModelTest {
	private ProjectModel model;
	
	@Before
	public void setUp(){
		model = new ProjectModel();
	}
	
	@Test
	public void testSetMajors(){
		ArrayList <MajorType> majors = new ArrayList <MajorType>();
		for (int i = 0; i < 4; i++){
			majors.add(MajorType.values()[i]);
		}
		model.setMajors(majors);
		assertEquals(majors, model.getMajors());
	}
	
	@Test
	public void testSetClasses(){
		ArrayList <ClassType> classes = new ArrayList <ClassType>();
		for (int i = 0; i < 4; i++){
			classes.add(ClassType.values()[i]);
		}
		model.setClasses(classes);
		assertEquals(classes, model.getClasses());
	}
	
	@Test 
	public void testSetDescription(){
		String description = "This project plans on........";
		model.setDescription(description);
		assertEquals(description, model.getDescription());
	}
	
	@Test
	public void testSetDuration(){
		String duration = "1/22/17-/5/9/17";
		model.setDuration(duration);
		assertEquals(duration, model.getDuration());
	}
	
	@Test
	public void testSetNumStudents(){
		model.setNumStudents("8");
		assertEquals("8", model.getNumStudents());
		model.setNumStudents("4");
		assertEquals("4", model.getNumStudents());
	}
	
	@Test
	public void testIsFunded(){
		model.setFunded(true);
		assertEquals(model.isFunded(), true);
		model.setFunded(false);
		assertEquals(model.isFunded(), false);
	}
	
	@Test
	public void testIsHardware(){
		model.setHardware(true);
		assertEquals(model.isHardware(), true);
		model.setHardware(false);
		assertEquals(model.isHardware(), false);
	}
	
	@Test
	public void testIsSoftware(){
		model.setSoftware(true);
		assertEquals(model.isSoftware(), true);
		model.setSoftware(false);
		assertEquals(model.isSoftware(), false);
	}
	
	@Test
	public void testSetStartTime(){
		model.setStartTime("1/17/17");
		assertEquals("1/17/17", model.getStartTime());
	}
	
	@Test
	public void testSetTitle(){
		model.setTitle("PROJECT TITLE");
		assertEquals("PROJECT TITLE", model.getTitle());
	}
}
