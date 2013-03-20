package com.nsn.uwr.panio;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
	public void shouldPrintSomething() {
		Logger loggerUnderTest = new Logger();
		loggerUnderTest.loggMessage(ELoggLevel.INFO, "My message");

	};

}
