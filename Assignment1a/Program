package spconger.Assignment1;

import java.util.Random;

public class Program {
	
	/*This class consists of arrays, ifs and loop example 
	 * Steve Miller, 1/7/15 */

	final int SIZE=50; //loops through 50 times declare literal string as constant; makes it more readable
	final int MAXRANDOM=500;  //"final"=constant
	public static void main(String[] args) {
		Program p = new Program(); //Always match class name
		p.createArrays(); //called later
		
	}
	
	private int getRandom()
	{
		Random r = new Random();
		int number=r.nextInt(MAXRANDOM);
		return number;
	}
	
	private void createArrays() //creates two integers
	{
		int[] even = new int[SIZE];
		int[] odd = new int [SIZE];
		populateArray(even, odd); //pass numbers to appropriate method
	}
	
	private void populateArray(int[] even, int[] odd) //parameters
	{
		@SuppressWarnings("unused")
		int evenCounter=0, oddCounter=0;
		
		for (int i=0; i<SIZE; i++)
		{
			int num = getRandom();
			
			if ((num%2 == 0)) //calculating even number
			{
				even[evenCounter]=num;
				evenCounter++;
			}
			else //calculating odd number
			{
				odd[oddCounter]=num;
				oddCounter++;
			}
			
		}
		displayArrays(even, odd);
	}
	
	public void displayArrays(int[] even, int[] odd)
	{
		System.out.println("Here are your even values: ");
		for (int i=0; i<SIZE; i++)//loops through array
		{
			if (even[i] !=0)
				System.out.println(even[i]);
		}
		System.out.println("These are your odd numbers: ");
		int x=0;
		while(x<even.length) //length (size of array)
		{
			if(odd[x] != 0)
			{
				System.out.println(odd[x]);
				x++;
			}
		}
	}
	

}
