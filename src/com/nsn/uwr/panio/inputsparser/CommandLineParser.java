package com.nsn.uwr.panio.inputsparser;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

public class CommandLineParser {
	
	public static final char INLINE_ARITHMETIC_OPERATION = 'l';
	public static final char OUTPUT_FILE_OPTION = 'o';
	public static final char INPUT_FILE_OPTION = 'f';
	
	@SuppressWarnings("static-access")
	public CommandLine parseCommandLine(String[] args) throws ParseException
	{
	Options cmdOptions = new Options();
	BasicParser parser = new BasicParser();
	Option lOption = OptionBuilder.hasArg(true).withArgName(String.valueOf(INLINE_ARITHMETIC_OPERATION)).withDescription("wyrazenie arytmetyczne").create();
	Option fOption = OptionBuilder.hasArg(true).withArgName(String.valueOf(INPUT_FILE_OPTION)).withDescription("plik wejsciowy do przetwarzania wsadowego").create();
	Option oOption = OptionBuilder.hasArg(true).withArgName(String.valueOf(OUTPUT_FILE_OPTION)).withDescription("nazwa pliku wyjsciowego").create();
	OptionGroup mutuallyExclusiveOptions = new OptionGroup();
	mutuallyExclusiveOptions.addOption(lOption).addOption(fOption).setRequired(true);
	cmdOptions.addOptionGroup(mutuallyExclusiveOptions).addOption(oOption);
	return parser.parse(cmdOptions,args);
	}

}
