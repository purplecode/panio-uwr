package com.nsn.uwr.panio.outputhandler;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.google.common.base.Throwables;
import com.nsn.uwr.panio.logger.*;


public class FileOutputHandler implements OutputHandler{
	private String outputFilePath;
	private BufferedWriter fileWriter;
	
	public FileOutputHandler(String path) {
		outputFilePath = path;
		try {
		    fileWriter = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(outputFilePath), "utf-8"));
		}
		catch (IOException e){			
			Logger.getInstance().logError(e.getMessage());
			Throwables.propagate(e);
		}
	}
	
	public void fileClose() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			Logger.getInstance().logError(e.getMessage());
			Throwables.propagate(e);
		}
	}

	@Override
	public void output(String expression, double result) {
		try {
			fileWriter.write(expression + " = " + result + "\n");
		} catch (IOException e) {
			Logger.getInstance().logError(e.getMessage());
			Throwables.propagate(e);
		}
	}
}
