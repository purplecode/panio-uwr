package com.nsn.uwr.panio;



import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.nsn.uwr.panio.logger.ELogLevel;
import com.nsn.uwr.panio.logger.Logger;

public class LoggerTest extends AbstractScreenCapturingTest {


	@Before
	public void setupLog() {
		 initCapture();		
	};

	@Test
	public void shouldPrintInfo() {
		
		// given
		Logger loggerUnderTest = Logger.getInstance();

		ELogLevel loglevel = ELogLevel.INFO;
		String message = "My message";

		// when
		loggerUnderTest.logMessage(message,ELogLevel.INFO);


		// then
		String trimedlog = getCapture().trim();
		Assertions.assertThat(trimedlog).endsWith(message);
		Assertions.assertThat(trimedlog).contains(loglevel.toString());
		
	};

}