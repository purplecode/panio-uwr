package com.nsn.uwr.panio.inputsparser;

public enum EOperand {
	ADD("+"), SUBTRACT("-"), DIVIDE("/"), MULTIPLY("*");

	private String operandSymbol;

	private EOperand(String operand) {
		this.operandSymbol = operand;
	}
	
	public String getOperand() {
		return operandSymbol;
	}
	
	public static EOperand match(String c){
		for ( EOperand operand : EOperand.values() ){
			if (c == operand.operandSymbol)
				return operand;
		}
		throw new IllegalArgumentException("no matching operand found");
	}

}
