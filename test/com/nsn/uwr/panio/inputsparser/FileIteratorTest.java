package com.nsn.uwr.panio.inputsparser;


import java.io.File;

import org.junit.After;
import org.junit.Before;

public class FileIteratorTest {

	@Before
	public void setUp() throws Exception {
		File fileTested = new File("TestFileToBeTested.txt");
		new FileIterator(fileTested);
		
	}

	@After
	public void tearDown() throws Exception {
	}

}
