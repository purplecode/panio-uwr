package com.nsn.uwr.panio.logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
		Logger logerUnderTest = new Logger();

		ELogLevel loglevel = ELogLevel.INFO;
		String message = "My message";

		// when
		logerUnderTest.logMessage(message,loglevel);


		// then
		String trimedlog = byteArrayOutputStream.toString().trim();
		Assertions.assertThat(trimedlog).endsWith(message);
		Assertions.assertThat(trimedlog).contains(loglevel.toString());
	};

}
