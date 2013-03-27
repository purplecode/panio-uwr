package com.nsn.uwr.panio.logger;

import java.text.DateFormat;


public class Logger {

	public void logMessage(String message, ELogLevel loglevel) {

		DateFormat datetimeFormatter = DateFormat.getDateTimeInstance();

		java.util.Date date = new java.util.Date();
		String dateString = datetimeFormatter.format(date);

		System.out.println("[" + dateString + "]" + " [" + loglevel + "] "
				+ message);

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
