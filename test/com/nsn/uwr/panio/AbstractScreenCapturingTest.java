package com.nsn.uwr.panio;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;

public abstract class AbstractScreenCapturingTest {

	private static ByteArrayOutputStream byteArrayOutputStream;

	@BeforeClass
	public static void initCapture() {
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
