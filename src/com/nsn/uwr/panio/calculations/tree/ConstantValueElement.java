package com.nsn.uwr.panio.calculations.tree;

public class ConstantValueElement implements IValueElement {

	private double value;
	@Override
	public double getValue() {
		return value;
	}

	public ConstantValueElement(double value) {
		this.value = value;		
	}

	@Override
	public String getString() {
		return Double.toString(value);
	}
}
