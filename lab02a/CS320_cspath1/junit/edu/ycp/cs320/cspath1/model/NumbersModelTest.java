package edu.ycp.cs320.cspath1.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumbersModelTest {
	private Numbers model;
	public static final double DELTA = .00001;
	
	@Before
	public void setUp(){
		model = new Numbers();
	}
	
	@Test
	public void testSetFirst(){
		model.setFirst(4.0);
		assertEquals(4.0, model.getFirst(), DELTA);
	}
	
	@Test
	public void testSetSecond(){
		model.setSecond(45.0);
		assertEquals(45.0, model.getSecond(), DELTA);
	}
	
	@Test
	public void testSetThird(){
		model.setThird(65.0);
		assertEquals(65.0, model.getThird(), DELTA);
	}
	
	@Test
	public void testSetResult(){
		model.setResult(657.0);
		assertEquals(657.0, model.getResult(), DELTA);
	}
}

