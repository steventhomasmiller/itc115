package com.spconger.InheritanceExample;

public class HourlyEmployee extends Employee //also does Person class
{
	private double rateOfPay;
	private int hours;
	private String status; //full or part time
	
	//overridden abstract method
	@Override
	public double calculateMonthlyPay() 
	{
		// TODO Auto-generated method stub
		return getRateOfPay() * getHours();
	}
	
	public String toString()
	{
		String parentString = super.toString();
		return parentString + ", Monthly Pay " + Double.toString(calculateMonthlyPay());
	}

	public double getRateOfPay() 
	{
		return rateOfPay;
	}

	public void setRateOfPay(double rateOfPay) 
	{
		this.rateOfPay = rateOfPay;
	}

	public int getHours() 
	{
		return hours;
	}

	public void setHours(int hours) 
	{
		this.hours = hours;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}
	
}
