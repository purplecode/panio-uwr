package com.nsn.uwr.panio.calculations.tree;

public class Subtraction extends AbstractBinaryFunction {

	public Subtraction(IValueElement arg1, IValueElement arg2) {
		super(arg1, arg2);
	}

	@Override
	public double getValue() {
		return getArg1().getValue() - getArg2().getValue();
	}

	public String getString() {
		return getArg1().toString() + " - " + getArg2().toString();
	}
}
