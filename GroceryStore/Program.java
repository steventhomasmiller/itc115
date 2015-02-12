package com.spconger.GroceryStore;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) 
	{
		Sale s = new Sale();
		Bulk b = new Bulk();
		b.setBin(12345);
		b.setName("almonds");
		b.setWeight(2);
		b.setPrice(12.20);
		b.setPricingUnit("pounds");
		s.add(b);
		
		Bulk b2 = new Bulk();
		b2.setBin(67890);
		b2.setName("granola");
		b2.setPrice(4.50);
		b2.setPricingUnit("Pounds");
		s.add(b2);
		
		PrePackage p = new PrePackage();
		p.setPrice(45);
		p.setName("Wild Turkey");
		p.setSku(342543);
		p.setRestricted("Age");
		s.add(p);
		
		ArrayList<Item> lineItems = s.getItems();
		for(Item i : lineItems)
		{
			System.out.println(i.getName() + " " + i.getPrice());
		}
		
		System.out.println("The total before tax is "+ s.getTotalPrice());
		System.out.println("The total tax is "+ s.calculateTax());

	}

}
