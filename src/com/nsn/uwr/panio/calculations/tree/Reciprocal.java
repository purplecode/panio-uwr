package com.nsn.uwr.panio.calculations.tree;

public class Reciprocal extends AbstractUnaryFunction {

	public Reciprocal(IValueElement argument) {
		super(argument);
	}

	@Override
	public double getValue() {
		return (1.0 / getArgument().getValue());
	}

	@Override
	public String getString() {
		return  " 1 / " + getArgument().toString();
	}

}
