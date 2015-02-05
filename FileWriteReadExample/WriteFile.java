package com.spconger.FileWriteReadExample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile 
{
	private String path;
	private PrintWriter writer;
	
	public WriteFile(String path) throws IOException
	{
		this.path=path;
		createFile();
	}
	
	private void createFile() throws IOException
	{
		FileWriter outFile = new FileWriter(path, true); //create file at path; true appends to it
		writer = new PrintWriter(outFile);
	}
	
	public void addText(String content)
	{
		writer.println(content);		
	}
	
	public void closeFile()
	{
		writer.close(); //the file must be closed
	}
}
