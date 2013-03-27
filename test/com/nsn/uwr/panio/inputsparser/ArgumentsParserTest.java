package com.nsn.uwr.panio.inputsparser;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ArgumentsParserTest {

	private ArgumentsParser argumentsParser;

	@Before
	public void setUp() {
		argumentsParser = new ArgumentsParser();
	}

	@Test
	public void testSimpleArgumentsParsing() {
		// given
		String[] input = { "1.5", "2.5", "+" };

		// when
		FunctionInput result = argumentsParser.parse(input);

		// then
		Assert.assertEquals(1.5, result.getArg1());
		Assert.assertEquals(2.5, result.getArg2());
		Assert.assertEquals(EOperand.ADD, result.getOperand());
	}

}
