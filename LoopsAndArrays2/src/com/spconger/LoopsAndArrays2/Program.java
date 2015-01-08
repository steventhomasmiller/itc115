package com.spconger.LoopuDoopu;

import java.util.Random;

public class Program {
	/*This class consists of arrays, ifs and loop example 
	 * Steve Miller, 1/7/15 */
	
	final int SIZE=50; //loops through 50 times declare literal string as constant; makes it more readable
	final int MAXRANDOM=500; //"final"=constant
	public static void main(String[] args) {
		Program p = new Program(); //Always match class name
		p.createArrays();
	}
	
	private int getRandom()
	{
		Random r = new Random();
		int number=r.nextInt(MAXRANDOM);
		return number;
	}
	
	//@SuppressWarnings("unused")
	private void createArrays() //create two integers
	{
		int[] smaller = new int[SIZE];
		int[] larger = new int[SIZE];
		populateArray(smaller, larger); //pass numbers down
	}
	
	//@SuppressWarnings("unused")
	private void populateArray(int[] small, int[] large) //parameters
	{
		int smallCounter=0, largeCounter=0; 
		
		for (int i=0; i<SIZE; i++)
		{
			int num = getRandom();
			
			if(num > 250)
			{
				large[largeCounter]=num;
				largeCounter++;
			}
			else //Add number to other array if less than 250
			{
				small[smallCounter]=num;
				smallCounter++;
			}
		}
		displayArrays(small, large);
	}
	
	public void displayArrays(int[] small, int[] large)
	{
		System.out.println("These are the values 250 or less: ");
		for (int i=0; i<SIZE; i++)//loop through array
		{
			if(small[i] !=0)
				System.out.println(small[i]); //no curly brace if there's only one line
		}
		System.out.println("These are the values more than 250: ");
		int x=0;
		while(x<small.length) //length (size) of array
		{
			if(large[x] != 0)
			{
				System.out.println(large[x]);
				x++;
			}
		}
	}

}
