package com.spconger.Assignment6;

import java.util.ArrayList;

public class Recipes implements ManageItems
{
	private ArrayList<Recipe> recipeList;
	
	public Recipes()//constructor
	{
		recipeList = new ArrayList<Recipe>();
	}
	
	public void setRecipeList(ArrayList<Recipe> recipeList)
	{
		this recipeList = recipelist;
	}
	
	@Override
	public void addItem(Item i)
	{
		recipeList.add((Recipe) i);
	}
	
	@Override
	public void editItem(Item i)
	{
		for(Item recipe : recipeList)
		{
			if(recipe.getName()==i.getName())
			{
				recipe = i;
			}
		}
	}
	
	@Override
	public void removeItems(Item i)
	{
		for (Item recipe : recipeList)
		{
			if(recipe.getName()==i.getName())
			{
				recipeList.remove(recipeList.indexOf(recipe));
			}
		}
	}
}
