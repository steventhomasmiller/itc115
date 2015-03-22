
package com.spconger.Quiz2;

import java.util.Scanner;


public class Program 
{
	/*
	 * This class prompts non-judgmentally prompts the user to enter
	 * the amount of miles they would like converted to kilometers.
	 * Steve Miller, 3/22/15
	 */

	public static void main(String[] args) 
	{
		Program p = new Program(); //iniates the program
	}
	
	
	Scanner scan;
	
	//The doubles needed for the equation
	private double miles;
	private double kilometers;
	
	//Getters and setters
	public double getMiles() 
	{
		return miles;
	}
	public void setMiles(double miles) 
	{
		this.miles = miles;
	}

	public double getKilometers() 
	{
		return kilometers;
	}

	public void setKilometers(double kilometers) 
	{
		this.kilometers = kilometers;
	}
	
	public Program() //constructor
	{
		scan = new Scanner(System.in);
		getInputs();
		getOutput();
	}
	
	public int mToKm() //converts miles to kilometers
	{
		double convertedKMs = (getMiles() * 1.7);
		return (int) convertedKMs;
	}
	
	public void getInputs()//prompts the user and stores the doubles
	{
		System.out.println("This is a safe place where you can convert miles to kilometers. We judge no one.");
		System.out.println("Enter the number of miles you like converted to kilometers.");
		setMiles(scan.nextDouble());
	}
	
	public void getOutput() //displays the outputs
	{
		System.out.println(getMiles() + " miles is about " + mToKm() + " kilometers");
		System.out.println("Again, we don't judge anyone here -- unless you can't do simple math."); //a passive-aggressive message to the program users
	}

}
