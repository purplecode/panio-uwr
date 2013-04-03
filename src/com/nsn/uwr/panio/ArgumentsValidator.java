package com.nsn.uwr.panio;

import com.nsn.uwr.panio.inputsparser.EOperand;

public class ArgumentsValidator {
	
	public boolean isValidNumber(String item) {
		try {
			Double.parseDouble(item);
		}
		catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean isValidOperator(String item) {
		try {
			EOperand.match(item);
		}
		catch(IllegalArgumentException e){
			return false;
		}
		return true;
	}
	
}
