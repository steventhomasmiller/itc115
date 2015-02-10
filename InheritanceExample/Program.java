package com.spconger.InheritanceExample;

public class Program {

	public static void main(String[] args) 
	{
		Customer c = new Customer();
		c.setName("Steve");
		c.setEmail("Steve@spconger.com");
		c.setPhone("2065555551"); //comes from Person class
		c.setZipCode("98122"); //ibid
		c.setRegistrationDate("2/9/2015");//ibid
		
		System.out.println(c.toString());
	}

}

