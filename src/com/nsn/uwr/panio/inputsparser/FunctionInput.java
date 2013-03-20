package com.nsn.uwr.panio.inputsparser;

public class FunctionInput {
	private double arg1;
	private double arg2;
	private EOperand operand;

	public FunctionInput(double arg1, double arg2, EOperand operand) {
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.operand = operand;
	}

	public double getArg1() {
		return arg1;
	}

	public void setArg1(double arg1) {
		this.arg1 = arg1;
	}

	public double getArg2() {
		return arg2;
	}

	public void setArg2(double arg2) {
		this.arg2 = arg2;
	}

	public EOperand getOperand() {
		return operand;
	}

	public void setOperand(EOperand operand) {
		this.operand = operand;
	}

}
