package edu.ycp.cs320.cspath1.project;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PastProjectTest {
	private PastProject past;
	private static final double DELTA = .00001;

	@Before
	public void setUp(){
		past = new PastProject();
	}
	@Test
	public void testSetDeadline(){
		past.setDeadline("5/16/17");
		assertEquals(past.getDeadline(), "5/16/17");
		
	}
	@Test
	public void testSetCost(){
		past.setCost(10000.00);
		assertEquals(past.getCost(), 10000, DELTA);
		
	}
	
	@Test
	public void testSetBudget(){
		past.setBudget(12000.00);
		assertEquals(past.getBudget(), 12000, DELTA);
		
	}
	
	@Test
	public void testSetNumStudents(){
		past.setNumStudents(5);
		assertEquals(past.getNumStudents(), 5);
	}
}
