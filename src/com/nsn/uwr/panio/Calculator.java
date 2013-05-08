package com.nsn.uwr.panio;

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

/**
 * main class for calculator 
 * @author jacob71
 *
 */
public class Calculator {

	private static final char INLINE_ARITHMETIC_OPERATION = 'l';
	private static final char OUTPUT_FILE_OPTION = 'o';
	private static final char INPUT_FILE_OPTION = 'f';

	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Options cmdOptions = new Options();
		CommandLineParser parser = new BasicParser();
		Option lOption = OptionBuilder.hasArg(true).withArgName(String.valueOf(INLINE_ARITHMETIC_OPERATION)).withDescription("wyrazenie arytmetyczne").create();
		Option fOption = OptionBuilder.hasArg(true).withArgName(String.valueOf(INPUT_FILE_OPTION)).withDescription("plik wejsciowy do przetwarzania wsadowego").create();
		Option oOption = OptionBuilder.hasArg(true).withArgName(String.valueOf(OUTPUT_FILE_OPTION)).withDescription("nazwa pliku wyjsciowego").create();
		
		OptionGroup mutuallyExclusiveOptions = new OptionGroup();

		mutuallyExclusiveOptions.addOption(lOption).addOption(fOption).setRequired(true);
		
		cmdOptions.addOptionGroup(mutuallyExclusiveOptions).addOption(oOption);
		CommandLine cmd;
		try {
			cmd = parser.parse(cmdOptions, args);
		} catch (ParseException e) {
			Logger.getInstance().logError(e.getMessage());
			return;
		}
		
		if(cmd.hasOption(OUTPUT_FILE_OPTION)) {
			String outputFilename = cmd.getOptionValue('o');
			// TODO file output handler creation
		}
		if(cmd.hasOption(INLINE_ARITHMETIC_OPERATION)) {
			ArgumentsValidator argumentsValidator = new ArgumentsValidator();
			argumentsValidator.validateArguments(cmd.getOptionValue('l').split(" "));
			
			ArgumentsParser argumentsParser = new ArgumentsParser();
			FunctionInput functionInput = argumentsParser.parse(args);
			AlgebraicCalculations algebraicCalculations = new AlgebraicCalculations();
			double result = algebraicCalculations.invoke(functionInput);
			OutputHandler outputHandler = new OutputHandler();
			outputHandler.resultToStdOut( result );
		}
		if(cmd.hasOption(INPUT_FILE_OPTION)) {
			String inputFilename = cmd.getOptionValue('o');
			// TODO file output handler creation
		}
		
	}

}
