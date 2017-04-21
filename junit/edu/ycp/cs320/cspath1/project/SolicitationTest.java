package edu.ycp.cs320.cspath1.project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.cspath1.enums.SolicitationType;

public class SolicitationTest {
	private Solicitation solicitation;
	private static final double DELTA = .00001;
	
	@Before
	public void setUp(){
		solicitation = new Solicitation();
	}
	
	@Test
	public void testSetNumStudents(){
		solicitation.setNumStudents(5);
		assertEquals(solicitation.getNumStudents(), 5);
		solicitation.setNumStudents(8);
		assertEquals(solicitation.getNumStudents(), 8);
	}
	
	@Test
	public void testSetCost(){
		solicitation.setCost(12000);
		assertEquals(solicitation.getCost(), 12000, DELTA);
		solicitation.setCost(150.75);
		assertEquals(solicitation.getCost(), 150.75, DELTA);
	}
	
	@Test
	public void testSetSolicitationType(){
		solicitation.setSolicitationType(SolicitationType.CivE_CAPSTONE);
		assertEquals(SolicitationType.CivE_CAPSTONE, solicitation.getSolicitationType());
		solicitation.setSolicitationType(SolicitationType.SW_ENGINEERING);
		assertEquals(SolicitationType.SW_ENGINEERING, solicitation.getSolicitationType());
	}
}

