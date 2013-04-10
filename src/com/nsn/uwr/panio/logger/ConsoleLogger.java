package com.nsn.uwr.panio.logger;

import java.io.PrintStream;

public class ConsoleLogger extends Logger{

	@Override
	protected PrintStream getOutputStream() {
		return System.out;
	}

}
