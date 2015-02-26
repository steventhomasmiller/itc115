package com.spconger.Assignment6;

import java.util.ArrayList;

public class Recipe extends Item
{
	private ArrayList<Item> ingredients;
	private String instructions;
	
	public Recipe()
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
}
