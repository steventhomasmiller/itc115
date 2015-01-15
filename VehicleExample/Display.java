package com.spconger.VehicleExample;

import java.util.Scanner;

public class Display {
	
	private Vehicle vehicle; //access the vehicle from anywhere; created own "type"
	Scanner scan;
	
	public Display()
	{
		vehicle = new Vehicle();
		scan = new Scanner(System.in);
	}
	
	private void getInputs()
	{
		System.out.println("Enter seating capacity of vehicle");
		
	}
}
