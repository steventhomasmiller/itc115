package com.spconger.FileWriteReadExample;

import java.io.IOException;
import java.util.Scanner;

public class Program {
	
	Scanner scan;
	
	public static void main(String[] args) 
	{
		Program p = new Program();
		p.writeToFile();
	}
	
	@SuppressWarnings("unused")
	private void writeToFile()
	{
		try {
			scan = new Scanner(System.in);
			WriteFile wf = new WriteFile("C:\\Temp\\myFile.txt");
			System.out.println("Enter some text for the file: ");
			String content = scan.nextLine();
			wf.addText(content);
			wf.closeFile();
		} catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}

}