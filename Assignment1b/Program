package com.spconger.Assignment1b;

import java.util.ArrayList;

import java.util.Scanner;

public class Program {
	
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		/*This class consists of arrays, ifs and loops 
	 	* Steve Miller, 1/7/15 */
		Program p = new Program();
		p.twoDimensionalArray(); //calls array
		
	}
	
	@SuppressWarnings("unused")
	private void twoDimensionalArray()
	{
		//lists authors and books
		@SuppressWarnings("unused")
		String [][] library = new String [10][2];
		library[0][0]="Edgar Allan Poe";
		library[0][1]="'Fall of the House of Usher"; //probably the best thing on here
		library[1][0]="Robert Louis Stevenson";
		library[1][1]="'The Strange Case of Dr. Jekyll and Mr. Hyde'";
		library[2][0]="Oscar Wilde";
		library[2][1]="'A Picture of Dorian Gray'";
		library[3][0]="Mary Shelley";
		library[3][1]="'Frankenstein"; //named for the doctor, not the monster
		library[4][0]="Horace Walpol";
		library[4][1]="'The Castle of Otranto'";
		library[5][0]="Bram Stoker";
		library[5][1]="'Dracula'";
		library[6][0]="Emily Bronte";
		library[6][1]="'Wuthering Heights'";
		library[7][0]="Ann Radcliffe";
		library[7][1]="'The Italian'";
		library[8][0]="Susan Hill";
		library[8][1]="'The Woman in Black";
		library[9][0]="Jane Austen";
		library[9][1]="'Northanger Abbey'";
		
		System.out.println("Enter a the name of a macabre Gothic author: "); //prompts user for author
		String author = scan.nextLine(); //nextLine reads space between author first and last name
		
		for (int i=0; i<library.length; i++)
		{
			if(library[i][0].equals(author)) //looks for author name
			{
				System.out.println(library[i][1]); //grabs book name
			}
		}
	
	}

