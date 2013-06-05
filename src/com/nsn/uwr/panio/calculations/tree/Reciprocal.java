package com.nsn.uwr.panio.calculations.tree;

import com.nsn.uwr.panio.calculations.Function;
import com.nsn.uwr.panio.inputsparser.EOperand;

//@Function(EOperand.)
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
