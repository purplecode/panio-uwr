package com.nsn.uwr.panio;

import com.nsn.uwr.panio.calculations.AlgebraicCalculations;
import com.nsn.uwr.panio.inputsparser.ArgumentsParser;
import com.nsn.uwr.panio.inputsparser.FunctionInput;
import com.nsn.uwr.panio.outputhandler.OutputHandler;

/**
 * main class for calculator 
 * @author jacob71
 *
 */
public class Calculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArgumentsValidator argumentsValidator = new ArgumentsValidator();
		argumentsValidator.validateArguments(args);
		
		ArgumentsParser argumentsParser = new ArgumentsParser();
		FunctionInput functionInput = argumentsParser.parse(args);
		AlgebraicCalculations algebraicCalculations = new AlgebraicCalculations();
		double result = algebraicCalculations.invoke(functionInput);
		OutputHandler outputHandler = new OutputHandler();
		outputHandler.resultToStdOut( result );
	}

}
