package com.spconger.Assignment3;

import java.util.Scanner;

public class Display {

	private Stats stats;
	Scanner scan;
	
	public Display()
	{
		stats = new Stats();
		scan = new Scanner(System.in);
		getInputs();
		getOutputs();
	}
	
	private void getInputs()
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
	
	private void getOutputs()
	{
		System.out.println("The player's batting average is " + stats.calculateBattingAverage()+ ", and their on-base percentage is " + stats.calculateOnBasePercentage() + ".");
	}
}


