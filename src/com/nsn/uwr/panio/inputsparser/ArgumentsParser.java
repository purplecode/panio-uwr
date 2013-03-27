package com.nsn.uwr.panio.inputsparser;


public class ArgumentsParser {

	private double parseNumericArgument(String arg) {
		return Double.parseDouble(arg);
	}

	public FunctionInput parse(String[] args) {
		double arg1 = parseNumericArgument(args[0]);
		double arg2 = parseNumericArgument(args[1]);
		EOperand operand = EOperand.match(args[2].charAt(0));
		return new FunctionInput(arg1, arg2, operand);
	}
}
