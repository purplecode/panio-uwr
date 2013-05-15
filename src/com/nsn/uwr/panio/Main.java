package com.nsn.uwr.panio;

import java.util.Iterator;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.common.collect.Lists;
import com.nsn.uwr.panio.calculations.AlgebraicCalculations;
import com.nsn.uwr.panio.inputsparser.ArgumentsParser;
import com.nsn.uwr.panio.inputsparser.CommandLineParser;
import com.nsn.uwr.panio.inputsparser.FunctionInput;
import com.nsn.uwr.panio.logger.Logger;
import com.nsn.uwr.panio.outputhandler.OutputHandler;

public class Main {
	public static void main(String[] args) throws ParseException {
		CommandLineParser commandLineParser=new CommandLineParser();
		CommandLine cmd=commandLineParser.parseCommandLine(args);
		OutputHandler outputHandler = new OutputHandler();
		
		if(cmd.hasOption(CommandLineParser.OUTPUT_FILE_OPTION)) {
			String outputFilename = cmd.getOptionValue('o');
			// TODO file output handler creation
		}
		if(cmd.hasOption(CommandLineParser.INLINE_ARITHMETIC_OPERATION)) {
			String calculatorArgs = cmd.getOptionValue('l');
			calculate(Lists.newArrayList(calculatorArgs).iterator(), outputHandler);
		}
		if(cmd.hasOption(CommandLineParser.INPUT_FILE_OPTION)) {
			String inputFilename = cmd.getOptionValue('o');
			// TODO file output handler creation
		}
	}	
	
	private static void calculate(Iterator<String> stringIterator,OutputHandler outputHandler)
	{
		Calculator calculator=new Calculator(stringIterator, outputHandler);
		calculator.calculate();
		
	}

}
