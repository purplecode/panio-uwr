package com.nsn.uwr.panio.outputhandler;


public class ConsoleOutputHandler implements OutputHandler {

	public void output(String expression, double result) {
		System.out.printf("%s = %f", expression, result);
	}
}
