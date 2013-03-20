package com.nsn.uwr.panio.inputsparser;


public class ArgumentsParser {

	private double parseNumericArgument(String arg) {
		return Double.parseDouble(arg);
	}

	public FunctionInput parse(String[] args) {
		FunctionInput fu = new FunctionInput();
		fu.setArg1(parseNumericArgument(args[0]));
		fu.setArg2(parseNumericArgument(args[1]));
		fu.setOperand(args[2].charAt(0));
		return fu;
	}

}
