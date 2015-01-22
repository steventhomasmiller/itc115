package com.spconger.Assignment3;

import java.util.Scanner;

public class Display {
	
	/* This class prompts the user to enter the player's information.
	 * It also displays the player's batting average and on-base percentage
	 * Steve Miller. 1/21/15  */
	
	private Stats stats;
	Scanner scan;
	
	public Display() //The constructor, called in the main
	{
		stats = new Stats(); //must match class name
		scan = new Scanner(System.in);
		getInputs(); //called below
		getOutputs(); //also called below
	}
	
	private void getInputs() //prompts user for information
	{
		System.out.println("Enter player's total at bats: ");
		stats.setNumTotalBats(scan.nextInt());
		System.out.println("Enter player's total hits: ");
		stats.setNumHits(scan.nextInt());
		System.out.println("Enter player's total walks: ");
		stats.setNumWalks(scan.nextInt());
		System.out.println("Enter player's total outs: ");
		stats.setNumOuts(scan.nextInt());
	}
	
	private void getOutputs() //displays calculations
	{
		System.out.println("The player's batting average is " + stats.calculateBattingAverage()+ ", and their on-base percentage is " + stats.calculateOnBasePercentage() + ".");
	}

}
