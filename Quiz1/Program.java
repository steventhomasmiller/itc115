package com.spconger.Quiz1;

import java.util.Random;

public class Program 
{
	final int SIZE = 20;
	
	int min = 1;
	int max = 20;
	
	public static void main(String[] args) 
	{
		Program p = new Program();
		p.createArrays();
	}
	
	public static int getRandom(int min, int max)
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
	
	private void populateArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int num = getRandom(1,20);
			array[i] = num;
		}
		tallyArray(array);
	}
	
	private void tallyArray(int[] array)
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
