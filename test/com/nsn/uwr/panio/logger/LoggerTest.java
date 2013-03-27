package com.nsn.uwr.panio.logger;


import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.nsn.uwr.panio.AbstractScreenCapturingTest;

public class LoggerTest extends AbstractScreenCapturingTest {


	@Before
	public void setupLog() {
		 initCapture();		
	};

	@Test
	public void shouldPrintInfo() {
		// given
		Logger loggerUnderTest = new Logger();

		ELogLevel loglevel = ELogLevel.INFO;
		String message = "My message";

		// when
		loggerUnderTest.logMessage(message,loglevel);


		// then
		String trimedlog = getCapture().trim();
		Assertions.assertThat(trimedlog).endsWith(message);
		Assertions.assertThat(trimedlog).contains(loglevel.toString());
		
	};
	@Test
	public void shouldPrintWarning() {
		// given
		Logger loggerUnderTest = new Logger();

		ELogLevel loglevel = ELogLevel.WARNING;
		String message = "My warning";

		// when
		loggerUnderTest.logMessage(message,loglevel);


		// then
		String trimedlog = getCapture().trim();
		Assertions.assertThat(trimedlog).endsWith(message);
		Assertions.assertThat(trimedlog).contains(loglevel.toString());
		
	};
	@Test
	public void shouldPrintError() {
		// given
		Logger loggerUnderTest = new Logger();

		ELogLevel loglevel = ELogLevel.ERROR;
		String message = "My error";

		// when
		loggerUnderTest.logMessage(message,loglevel);


		// then
		String trimedlog = getCapture().trim();
		Assertions.assertThat(trimedlog).endsWith(message);
		Assertions.assertThat(trimedlog).contains(loglevel.toString());
		
	};

}
