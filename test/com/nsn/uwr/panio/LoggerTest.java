package com.nsn.uwr.panio;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.Assert;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest {

	private ByteArrayOutputStream byteArrayOutputStream;

	@Before
	public void setupLog() {
		byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream testStream = new PrintStream(byteArrayOutputStream);
		System.setOut(testStream);

	};

	@Test
	public void shouldPrintInfo() {
		// given
		Logger loggerUnderTest = new Logger();
		ELoggLevel loglevel = ELoggLevel.INFO;
		String message = "My message";

		// when
		loggerUnderTest.loggMessage(loglevel, message);

		// then
		String trimedlog = byteArrayOutputStream.toString().trim();
		Assertions.assertThat(trimedlog).endsWith(message);
		Assertions.assertThat(trimedlog).contains(loglevel.toString());
	};

}
