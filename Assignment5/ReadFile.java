package com.spconger.Assignment5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile 
{
	/* This class allows the user to pull text from a text file.
	 * Steve Miller, 2/13/15
	*/
	
	private String path;
	
	public ReadFile(String path) //constructor
	{
		this.path=path;
	}
	
	public String getText() throws IOException //this reads file's content
	{
		String content="";
		FileInputStream fstream = new FileInputStream(path); //reads file from path
		DataInputStream fileIn = new DataInputStream(fstream); //reads file's content
		BufferedReader buff = new BufferedReader(new InputStreamReader(fileIn)); //reads file's characters
		String lineIn;
		
		while ((lineIn=buff.readLine())!=null)
		{
			content += (lineIn + "\n");
		}
		
		return content;
	}
}
