package com.spconger.Assignment4;

public class Card {
	
	private static String suit;
	private static String rank;
	
	public Card(String suit, String rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	public Card()
	{
		
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public void setSuit(String suit)
	{
		this.suit = suit;
	}
	
	public String getRank()
	{
		return rank;
	}
	
	public void setRank(String rank)
	{
		this.rank = rank;
		
	}
	
	public String getCard()
	{
		return getSuit() + " of " + getRank();
	}

}
