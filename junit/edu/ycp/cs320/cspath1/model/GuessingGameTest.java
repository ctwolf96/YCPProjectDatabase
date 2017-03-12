package edu.ycp.cs320.cspath1.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.cspath1.model.GuessingGame;

public class GuessingGameTest {
	private GuessingGame model;
	
	@Before
	public void setUp() {
		model = new GuessingGame();
	}
	
	@Test
	public void testSetMin() {
		model.setMin(1);
		assertEquals(1, model.getMin());
	}
	@Test
	public void testSetMax() {
		model.setMax(100);
		assertEquals(100, model.getMax());
	}
	@Test
	public void testGetMax(){
		model.setMax(100);
		assertEquals(model.getMax(), 100);
	}
	@Test
	public void testGetMin(){
		model.setMin(0);
		assertEquals(model.getMin(), 0);
	}
	@Test
	public void testGetGuess(){
		model.setMin(0);
		model.setMax(100);
		assertEquals(model.getGuess(), 50);
	}
	@Test
	public void testIsDone(){
		model.isDone();
		assertEquals(model.getMin(), model.getMax());
	}
	@Test
	public void testSetIsGreaterThan(){
		model.setMin(0);
		model.setMax(100);
		int guess = model.getGuess();
		model.setIsGreaterThan(guess);
		assertEquals(model.getMin(), 51);
	}
	@Test
	public void testSetIsLessThan(){
		model.setMin(0);
		model.setMax(100);
		int guess = model.getGuess();
		model.setIsLessThan(guess);
		assertEquals(model.getMax(), 49);
	}
}
