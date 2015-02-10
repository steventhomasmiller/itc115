package com.spconger.InheritanceExample;

public abstract class Person //abstract = can't use class directly
{
	private String name;
	private String email;
	private String phone;
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getPhone() 
	{
		return phone;
	}
	
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	
	public String toString()
	{
		return getName() + ", " + getEmail() + ", " + getPhone();
	}
	
}
