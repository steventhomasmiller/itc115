package com.spconger.Assignment4;

public class Card {
	
	private String suit;
	private String rank;
	
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
	
	public String toString()
	{
		return getSuit() + getRank();
	}

}
