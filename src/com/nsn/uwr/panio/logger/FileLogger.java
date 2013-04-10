package com.nsn.uwr.panio.logger;


import java.io.IOException;
import java.io.PrintStream;

public class FileLogger extends Logger {

	@Override
	protected PrintStream getOutputStream() {
		try {
			PrintStream logfile = new PrintStream("Log_File.txt");
			return logfile;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
