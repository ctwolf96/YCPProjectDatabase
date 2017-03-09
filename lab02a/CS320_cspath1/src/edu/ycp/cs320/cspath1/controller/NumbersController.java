package edu.ycp.cs320.cspath1.controller;

import edu.ycp.cs320.cspath1.model.Numbers;

public class NumbersController {
	private Numbers model;
	
	public void setModel(Numbers model){
		this.model = model;
	}
	public Double add(Double first, Double second, Double third) {
		return model.getFirst() + model.getSecond() + model.getThird();
	}
	public Double multiply(double first, double second, double third){
		return model.getFirst() * model.getSecond() * model.getThird();
	}
}
