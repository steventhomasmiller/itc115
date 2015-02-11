package com.spconger.Assignment4a;

public class Card 
{
	/* This class gets and sets the ranks and suits of the cards
	 * Steve Miller
	 * 1/28/15
	 */
	
	private String rank;
	private String suit;
		
	//getters and setters
	public String getRank()
	{
		return rank;
	}
	
	public void setRank(String rank)
	{
		this.rank = rank;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public void setSuit(String suit)
	{
		this.suit = suit;
	}
	
	//appears in the program itself
	public String toString()
	{
		return getRank() + " of " + getSuit();
	}
}
