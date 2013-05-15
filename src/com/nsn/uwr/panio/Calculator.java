package com.nsn.uwr.panio;

import com.google.common.annotations.VisibleForTesting;
import com.nsn.uwr.panio.calculations.AlgebraicCalculations;
import com.nsn.uwr.panio.inputsparser.ArgumentsParser;
import com.nsn.uwr.panio.inputsparser.FunctionInput;
import com.nsn.uwr.panio.outputhandler.OutputHandler;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * main class for calculator 
 * @author jacob71
 *
 */
public class Calculator {

	private ArgumentsValidator argumentsValidator;
	private ArgumentsParser argumentsParser;
	private OutputHandler outputHandler;
	private Iterator<String> inputsIterator;
	/**
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		
		 
		
		
		ArgumentsValidator argumentsValidator = new ArgumentsValidator();
		argumentsValidator.validateArguments(args);
		ArgumentsParser argumentsParser = new ArgumentsParser();
		
		
		OutputHandler outputHandler = new OutputHandler();
		outputHandler.resultToStdOut( result );
	} */
	private AlgebraicCalculations algebraicCalculations;
	
	public Calculator(Iterator<String> inputsIterator,  OutputHandler outputHandler){
		this.inputsIterator = inputsIterator;
		this.outputHandler = outputHandler;
		argumentsValidator = new ArgumentsValidator();
		argumentsParser = new ArgumentsParser();
		algebraicCalculations = new AlgebraicCalculations();
		
	}

	@VisibleForTesting
		protected void calculate() {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		while(inputsIterator.hasNext()) {
			threadPool.execute(new SingleCalculation(inputsIterator.next()));
		}
			
		
	}
	private class SingleCalculation implements Runnable {
		
		private String input;

		public SingleCalculation(String input) {
			this.input = input;
		}
		
		@Override
		public void run() {
			String[] args = input.split(" ");
			argumentsValidator.validateArguments(args);
			FunctionInput parse = argumentsParser.parse(args);
			double result = algebraicCalculations.invoke(parse);
			outputHandler.resultToStdOut(result);	
			
			
			
		}

	}

}



