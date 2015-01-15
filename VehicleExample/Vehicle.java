package com.spconger.VehicleExample;

public class Vehicle {
	
	
	//private fields
	private int passengers;
	private int fuelCapacity;
	private int mpg;
	
	//public getters and setters
	//accesors and mutators
	
	public int getPassengers()
	{
		return passengers;
	}
	public void setPassengers(int passengers)
	{
		this.passengers=passengers;
	}
	public int getMpg() {
		return mpg;
	}
	public void setMpg(int mpg) {
		this.mpg = mpg;
	}
	public int getFuelCapacity() {
		return fuelCapacity;
	}
	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}
	//public method
	public int calculateRange()
	{
		return getFuelCapacity() * getMpg(); 
	}
}
