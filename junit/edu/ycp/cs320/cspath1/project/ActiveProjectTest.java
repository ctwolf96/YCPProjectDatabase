package edu.ycp.cs320.cspath1.project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ActiveProjectTest {
	private ActiveProject active;
	private static final double DELTA = .00001;
	
	@Before
	public void setUp(){
		active = new ActiveProject();
	}
	@Test
	public void testSetDeadline(){
		active.setDeadline("5/16/17");
		assertEquals(active.getDeadline(), "5/16/17");
		
	}
	@Test
	public void testSetCost(){
		active.setCost(10000.00);
		assertEquals(active.getCost(), 10000, DELTA);
		
	}
	
	@Test
	public void testSetBudget(){
		active.setBudget(12000.00);
		assertEquals(active.getBudget(), 12000, DELTA);
		
	}
	
	@Test
	public void testSetNumStudents(){
		active.setNumStudents(5);
		assertEquals(active.getNumStudents(), 5);
	}
}
