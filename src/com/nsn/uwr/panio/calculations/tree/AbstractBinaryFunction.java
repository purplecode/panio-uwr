package com.nsn.uwr.panio.calculations.tree;

public abstract class AbstractBinaryFunction implements IValueElement {
	private final IValueElement arg1;
	private final IValueElement arg2;

	public AbstractBinaryFunction(IValueElement arg1, IValueElement arg2) {
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	public IValueElement getArg1() {
		return arg1;
	}

	public IValueElement getArg2() {
		return arg2;
	}
}

