package com.spconger.Quiz1;

import java.util.Random;
import java.util.Arrays;

public class Program 
{
	/* This class creates arrays that will count numbers
	between 1-20 and return the numbers above 10 
	Steve Miller 3/21/15
	*/
	
	//sets size of the array
	final int SIZE = 20; 
	
	int min = 1;
	int max = 20;
	
	public static void main(String[] args) 
	{
		Program p = new Program();
		p.createArrays(); //calls method to make arrays
	}
	
	public static int getRandom(int min, int max) //Generates random number between 1 and 20
	{
		Random r = new Random();
		int number=r.nextInt((max-min)+1)+1;
		return number;
	}
	
	private void createArrays()
	{
		int[] array = new int[SIZE];
		populateArray(array);
	}
	
	private void populateArray(int[] array) //fills empty array
	{
		for (int i = 0; i < array.length; i++)
		{
			int num = getRandom(1,20);
			array[i] = num;
		}
		tallyArray(array);
	}
	
	private void tallyArray(int[] array) //displays the integers greater than 10
	{
		System.out.print("Here are the random numbers greater than 10: ");
		for (int i = 0; i < array.length; i++ )
		{
			if (array[i] > 10)
			{
				System.out.print(array[i]); 
				if(i != array.length-1)
				{
					System.out.print(", "); 
				}
			}
		}
	}

}
