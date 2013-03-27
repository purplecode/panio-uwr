package com.nsn.uwr.panio.inputsparser;

public enum EOperand {
	ADD('+'), SUBTRACT('-'), DIVIDE('/'), MULTIPLY('*');

	private char operand;

	private EOperand(char operand) {
		this.operand = operand;
	}
	
	public static EOperand match(char c){
		for ( EOperand operand : EOperand.values() ){
			if (c == operand.operand)
				return operand;
		}
		throw new IllegalArgumentException("no matching operand found");	
	}

}
