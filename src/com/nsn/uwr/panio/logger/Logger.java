package com.nsn.uwr.panio.logger;

import java.text.DateFormat;
import java.io.PrintStream;

public class Logger {

	
	private PrintStream loggerOutputStream=System.out;
	
	public void logMessage(String message, ELogLevel loglevel) {

		DateFormat datetimeFormatter = DateFormat.getDateTimeInstance();

		java.util.Date date = new java.util.Date();
		String dateString = datetimeFormatter.format(date);
		loggerOutputStream.println("[" + dateString + "]" + " [" + loglevel + "] "
				+ message);
		//System.out.println("[" + dateString + "]" + " [" + loglevel + "] "
			//	+ message);

	};
	

	public void logWarning(String message) {

		logMessage(message, ELogLevel.WARNING);

	};

	public void logInfo(String message) {

		logMessage(message, ELogLevel.INFO);

	};

	public void logError(String message) {

		logMessage(message, ELogLevel.ERROR);

	};

}
