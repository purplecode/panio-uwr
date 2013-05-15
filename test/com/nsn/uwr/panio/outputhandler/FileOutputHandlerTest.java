package com.nsn.uwr.panio.outputhandler;

import java.io.File;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;


public class FileOutputHandlerTest {
	
	//private FileOutputHandler outputHandlerInstance;
	
	@Test(expected=RuntimeException.class)
	public void shouldThrowExceptionWhenFileCouldNotBeOpened() {
		//given
			String wickedNotAccessibleFilePath = "Ó:\\folder\\test_file.txt"; 
		//when
			new FileOutputHandler(wickedNotAccessibleFilePath);
		//than
		//should throw exception when file
		//after
			File testFile = new File(wickedNotAccessibleFilePath);
			testFile.delete();
	}
	
	@Test
	public void shouldWriteToFile() {
		//given
			File testFile = new File("test_file");
			FileOutputHandler fileOutputHandler = new FileOutputHandler(testFile.getPath());
		//when
			fileOutputHandler.output("a", 1.3);
		//than
			try {
				List<String> lines = Files.readLines(testFile, Charsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//after
			testFile.delete();
			
	}
	
	
	
}

