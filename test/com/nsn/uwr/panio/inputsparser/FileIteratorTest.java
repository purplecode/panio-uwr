package com.nsn.uwr.panio.inputsparser;

import java.io.File;
import java.io.IOException;

import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileIteratorTest {

	private FileIterator fileIterator;

	@Before
	public void setUp() throws Exception {

		File fileTested = new File(
				"test/com/nsn/uwr/panio/inputsparser/TestFileToBeTested.txt");
		Assertions.assertThat(fileTested.exists()).isTrue();
		fileIterator = new FileIterator(fileTested);

	}

	@Test
	public void hasNextIsTested() throws IOException {

		Assertions.assertThat(fileIterator.hasNext()).isTrue();
		//67 26 +
		String line = fileIterator.next();
		Assertions.assertThat(line).isNotNull();
		Assertions.assertThat(line).isNotEmpty();
		Assertions.assertThat(line).isEqualTo("60 20 +");
		Assertions.assertThat(fileIterator.next()).isEqualTo("45 29 -");
		
		for(int i = 0; i<5; i++)
			{
			Assertions.assertThat(fileIterator.next()).isNotNull();
			
			}
		
		Assertions.assertThat(fileIterator.hasNext()).isFalse();
	}

	@After
	public void tearDown() throws Exception {
		fileIterator.close();
		
	}

}
