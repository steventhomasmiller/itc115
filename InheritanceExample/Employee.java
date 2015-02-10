package com.spconger.InheritanceExample;

public abstract class Employee extends Person
{
	private int employeeID;
	private String hireDate;
	private String dept;
	
	public int getEmployeeID() 
	{
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID) 
	{
		this.employeeID = employeeID;
	}
	
	public String getHireDate() 
	{
		return hireDate;
	}
	
	public void setHireDate(String hireDate) 
	{
		this.hireDate = hireDate;
	}
	
	public String getDept() 
	{
		return dept;
	}
	
	public void setDept(String dept) 
	{
		this.dept = dept;
	}
	
	//public method not to be implemented
	public abstract double calculateMontlyPay(); //method signature
	
	public String toString()
	{
		String parentString = super.toString();
		return Integer.toString(getEmployeeID()) + ", " + getHireDate() + " " + getDept() + parentString; //converting integer to string
	}
}
