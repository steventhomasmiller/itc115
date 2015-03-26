package com.spconger.Assignment6;

import java.util.ArrayList;

public class Recipes implements ManageItems
{
	/* 
	This class uses and (perhaps) overrides methods from previous classes
	*/
	
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
		recipeList.add((Recipe) i);//adds recipe to array
	}
	
	@Override
	public void editItem(Item i)//edits the item if need be
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
	public void removeItems(Item i) //removes the item, if need be
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
