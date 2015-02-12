package com.spconger.GroceryStore;

public class PrePackage extends Item
{
	private String restricted; //if it's alcohol
	private String expirationDate;
	
	public String getRestricted() 
	{
		return restricted;
	}
	
	public void setRestricted(String restricted) 
	{
		this.restricted = restricted;
	}
	
	public String getExpirationDate() 
	{
		return expirationDate;
	}
	
	public void setExpirationDate(String expirationDate) 
	{
		this.expirationDate = expirationDate;
	}
}
