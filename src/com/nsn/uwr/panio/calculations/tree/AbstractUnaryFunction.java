package com.nsn.uwr.panio.calculations.tree;

public abstract class AbstractUnaryFunction implements IValueElement {

	private IValueElement argument;

	public AbstractUnaryFunction(IValueElement argument) {
		this.argument = argument;
	}

	protected IValueElement getArgument() {
		return argument;
	}
}
