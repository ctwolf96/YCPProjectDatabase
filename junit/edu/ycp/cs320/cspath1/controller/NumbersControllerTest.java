package edu.ycp.cs320.cspath1.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.cspath1.model.Numbers;

public class NumbersControllerTest {
	private Numbers model;
	private NumbersController controller;
	public static final double DELTA  = .00001;
	
	@Before
	public void setUp(){
		model = new Numbers();
		controller = new NumbersController();
		
		model.setFirst(55.0);
		model.setSecond(45.0);
		model.setThird(44.0);
		
		
		controller.setModel(model);
	}
	
	@Test
	public void testAdd(){
		double result = controller.add(model.getFirst(), model.getSecond(), model.getThird());
		assertEquals(144, result, DELTA);
		
	}
	
	@Test
	public void testMultiply(){
		double result = controller.multiply(model.getFirst(), model.getSecond(), model.getThird());
		assertEquals(108900.0, result, DELTA);
	}
}


