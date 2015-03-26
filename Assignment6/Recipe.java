package com.spconger.Assignment6;

import java.util.ArrayList;

public class Recipe extends Item
{
	/* 
	This class adds items and ingredients for each item.
	*/
	private ArrayList<Item> ingredients;
	private String instructions;
	
	public Recipe() //constructor
	{
		ingredients = new ArrayList<Item>();
	}
	
	public String getInstructions() 
	{
		return instructions;
	}
	
	public void setInstructions(String instructions) 
	{
		this.instructions = instructions;
	}
	
	@Override
	public void addItem(Item i) 
	{
		ingredients.add((Ingredient) i);
	}

	
	@Override
	public void editItem(Item i)
	{
		
	}
	
	@Override
	public void removeItem(Item i)
	{
		
	}

}
