package com.nsn.uwr.panio.logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.nsn.uwr.panio.logger.Logger;

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
		loggerUnderTest.logMessage("My message", ELogLevel.INFO);

	};

}
