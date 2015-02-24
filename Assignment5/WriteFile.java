package com.spconger.Assignment5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile 
{
	/* This class allows the user to add text to a file.
	Steve Miller, 2/10/15
	*/
	
	private String path;
	private PrintWriter writer;
	
	public WriteFile(String path) throws IOException //constructor
	{
		this.path = path;
		FileWriter outFile = new FileWriter(path, true);
		writer = new PrintWriter(outFile);
	}
	
	public void addText(String content)
	{
		writer.println(content);//adds line to file
	}
	
	public void closeFile()
	{
		writer.close();//closes writer
	}

}
