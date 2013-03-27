package com.nsn.uwr.panio;


import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest extends AbstractScreenCapturingTest {


	@Before
	public void setupLog() {
		 initCapture();		
	};

	@Test
	public void shouldPrintInfo() {
		// given
		Logger loggerUnderTest = new Logger();

		ELoggLevel loglevel = ELoggLevel.INFO;
		String message = "My message";

		// when
		loggerUnderTest.loggMessage(message,loglevel);


		// then
		String trimedlog = getCapture().trim();
		Assertions.assertThat(trimedlog).endsWith(message);
		Assertions.assertThat(trimedlog).contains(loglevel.toString());
		
	};

}
