package com.nsn.uwr.panio;

import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.nsn.uwr.panio.calculations.AlgebraicCalculations;
import com.nsn.uwr.panio.inputsparser.ArgumentsParser;
import com.nsn.uwr.panio.inputsparser.FunctionInput;
import com.nsn.uwr.panio.logger.Logger;
import com.nsn.uwr.panio.outputhandler.OutputHandler;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Calculator {

	private ArgumentsValidator argumentsValidator;
	private ArgumentsParser argumentsParser;
	private OutputHandler outputHandler;
	private Iterator<String> inputsIterator;
	
	
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



