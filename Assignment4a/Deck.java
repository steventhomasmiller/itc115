package com.spconger.Assignment4a;

import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
	private ArrayList<Card> cards;
	
	Deck()
	{
		cards = new ArrayList<Card>();
		for (int i=0; i<=3; i++)
		{
			for (int j=0; j<=12; j++)
			{
				cards.add(new Card(i,j));
				//System.out.print(cards.get(i).getSuit()+ ", "+cards.get(i).getRank());
			}
		}
	}
	
	public Card drawFromDeck()
	{
		Random generator = new Random();
		int index = generator.nextInt(cards.size());
		return cards.remove(index);
	}
}
