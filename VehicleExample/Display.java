package com.spconger.VehicleExample;

import java.util.Scanner;

public class Display {
	
	private Vehicle vehicle; //access the vehicle from anywhere; created own "type"
	Scanner scan;
	
	public Display()
	{
		vehicle = new Vehicle();
		scan = new Scanner(System.in);
		getInputs();
		getOutput();
	}
	
	private void getInputs()
	{
		System.out.println("Enter seating capacity of vehicle: ");
		vehicle.setPassengers(scan.nextInt());
		System.out.println("Enter the fuel capacity: ");
		vehicle.setFuelCapacity(scan.nextInt());
		System.out.println("Enter the mpg: ");
		vehicle.setMpg(scan.nextInt());
	}
	
	private void getOutput()
	{
		System.out.println("Your vehicle can hold " + vehicle.getPassengers() + " passengers, and has a range of " + vehicle.calculateRange() + "miles!!");
	}
}
