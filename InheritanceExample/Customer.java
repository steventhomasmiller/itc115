package com.spconger.InheritanceExample;

public class Customer extends Person //extends = key word for inheritence
{
	//private fields
	private int customerNo;
	private String registrationDate;
	private String zipCode;
	private int discountPoints;
	
	//setters and getters
	public int getCustomerNo() 
	{
		return customerNo;
	}
	public void setCustomerNo(int customerNo) 
	{
		this.customerNo = customerNo;
	}
	
	public String getRegistrationDate() 
	{
		return registrationDate;
	}
	
	public void setRegistrationDate(String registrationDate) 
	{
		this.registrationDate = registrationDate;
	}
	
	public String getZipCode() 
	{
		return zipCode;
	}
	
	public void setZipCode(String zipCode) 
	{
		this.zipCode = zipCode;
	}
	
	public int getDiscountPoints() 
	{
		return discountPoints;
	}
	
	public void setDiscountPoints(int discountPoints) 
	{
		this.discountPoints = discountPoints;
	}
	
	public double calculateDiscount(double amount)
	{
		double discount = amount - getDiscountPoints();
		return discount;
	}
	
	@Override
	public String toString()
	{
		String parentString = super.toString();
		return getCustomerNo() + "--" + getRegistrationDate() + ", " + parentString;
	}
	
	
}
