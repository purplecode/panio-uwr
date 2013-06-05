package com.nsn.uwr.panio.calculations.tree;

import com.nsn.uwr.panio.calculations.Function;
import com.nsn.uwr.panio.inputsparser.EOperand;

@Function(EOperand.DIVIDE)
public class Division extends AbstractBinaryFunction {

	public Division(IValueElement arg1, IValueElement arg2) {
		super(arg1, arg2);
	}

	@Override
	public double getValue() {
		return getArg1().getValue() / getArg2().getValue();
	}

	@Override
	public String getString() {
		return getArg1().toString() + " / " + getArg2().toString();
	}

}
