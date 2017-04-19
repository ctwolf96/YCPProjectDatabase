package edu.ycp.cs320.cspath1.project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProposalTest {
	private Proposal proposal;
	private static final double DELTA = .00001;
	
	@Before
	public void setUp(){
		proposal = new Proposal();
	}
	
	@Test
	public void testSetNumStudents() {
		proposal.setNumStudents(5);
		assertEquals(proposal.getNumStudents(), 5);
		proposal.setNumStudents(8);
		assertEquals(proposal.getNumStudents(), 8);
	}
	
	@Test
	public void testSetCost() {
		proposal.setCost(12000);
		assertEquals(proposal.getCost(), 12000, DELTA);
		proposal.setCost(150.75);
		assertEquals(proposal.getCost(), 150.75, DELTA);
	}
	
	@Test
	public void testSetDeadline() {
		proposal.setDeadline("May 7, 2017");
		assertEquals(proposal.getDeadline(), "May 7, 2017");
		proposal.setDeadline("August 30, 2017");
		assertEquals(proposal.getDeadline(), "August 30, 2017");
	}
	
	@Test
	public void testSetIsFunded() {
		proposal.setIsFunded(true);
		assertEquals(proposal.getIsFunded(), true);
		proposal.setIsFunded(false);
		assertEquals(proposal.getIsFunded(), false);
	}
}

