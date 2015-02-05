package com.spconger.FileWriteReadExample;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile 
{
	private String path;
	
	public ReadFile(String path)
	{
		this.path=path;
	}
	
	public String getText() throws IOException //stores what's in the file
	{
		String content=""; //empty content
		FileInputStream fstream = new FileInputStream(path);
		DataInputStream fileIn = new DataInputStream(fstream);
		BufferedReader buff = new BufferedReader(new InputStreamReader(fileIn));
		String lineIn;
		while ((lineIn=buff.readLine())!=null) //as long as the reader is reading lines
		{
			content += (lineIn + "\n");
		}
		
		return content;
		
	}
}
