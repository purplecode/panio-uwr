package com.nsn.uwr.panio.inputsparser;

public enum EOperand {
	ADD('+'), SUBTRACT('-'), DIVIDE('/'), MULTIPLY('*');

	private char operand;

	private EOperand(char operand) {
		this.operand = operand;
	}
	


}
