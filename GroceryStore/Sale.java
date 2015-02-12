package com.spconger.GroceryStore;

import java.util.ArrayList;

public class Sale implements ListOperations 
{
	private ArrayList<Item> basket = new ArrayList<Item>();
	private final double TAXPERCENT=.095;
	
	public double getTotalPrice()
	{
		double total=0;
		for (Item i: basket)
		{
			total += i.getPrice();
		}
		
		return total;
	}
	
	public ArrayList<Item> getItems()
	{
		return basket;
	}
	
	public double calculateTax()
	{
		return getTotalPrice() * TAXPERCENT;
	}

	@Override
	public void add(Item i) 
	{
		basket.add(i);
		
//		if(i.getClass().equals("Bulk"))
//		{
//			Bulk bi = (Bulk)i;
//			basket.add(i);
//		}
//		else
//		{
//			PrePackage p = (PrePackage)i;
//			basket.add(p);
//		}
	}

	@Override
	public void edit(Item i) 
	{
		for(Item it : basket)
		{
			if (it.getSku()==i.getSku())
			{
				it=i;
			}
		}
	}

	@Override
	public void remove(Item i) 
	{
		for(Item it : basket)
		{
			if (it.getSku()==i.getSku())
			{
				basket.remove(it);
			}
		}
	}
}
