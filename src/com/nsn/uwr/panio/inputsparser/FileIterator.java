package com.nsn.uwr.panio.inputsparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import com.google.common.base.Throwables;

public class FileIterator implements Iterator<String> {

	private BufferedReader inputReader;

	public FileIterator(File inputfile) throws FileNotFoundException {

		inputReader = new BufferedReader(new FileReader(inputfile));

	}

	public String next()  {
		try {
			return hasNext() ? inputReader.readLine() : null;
		} catch (IOException e) {
				throw Throwables.propagate(e);
		}

	}
	
	public void close() throws IOException{
		inputReader.close();
	}
	
	public boolean hasNext()  {
		try {
			return inputReader.ready();
		} catch (IOException e) {
			throw Throwables.propagate(e);
		}
	}

	@Override
	public void remove() {
		// Nothing to do
		
	}

}
