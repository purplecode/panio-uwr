package com.nsn.uwr.panio.outputhandler;

import com.nsn.uwr.panio.calculations.AlgebraicCalculations;
import com.nsn.uwr.panio.inputsparser.FunctionInput;

public class OutputHandler {

	private AlgebraicCalculations algebraicCalculations = new AlgebraicCalculations();

	public void resultToStdOut(FunctionInput fi) {
		System.out.printf(" = %f", algebraicCalculations.invoke(fi));
	}
}
