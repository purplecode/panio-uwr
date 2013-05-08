package com.nsn.uwr.panio.inputsparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIterator {

	private BufferedReader inputReader;

	public FileIterator(File inputfile) throws FileNotFoundException {

		inputReader = new BufferedReader(new FileReader(inputfile));

	}

	public String next() throws IOException {
		return hasNext() ? inputReader.readLine() : null;

	}
	
	public void close() throws IOException{
		inputReader.close();
	}
	
	public boolean hasNext() throws IOException {
		return inputReader.ready();
	}

}
