package com.nsn.uwr.panio;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class AbstractScreenCapturingTest {
	private ByteArrayOutputStream byteArrayOutputStream;

	protected void initCapture() {
		byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream testStream = new PrintStream(byteArrayOutputStream);
		System.setOut(testStream);
	}
	
	protected String getCapture() {
		if (byteArrayOutputStream == null) {
			throw new IllegalStateException("Capturer not initiated");
		}
		return byteArrayOutputStream.toString().trim();
	}

}
