package com.spconger.Assignment4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck()
	{
		cards = new ArrayList<Card>();
		String[] suits = new String[]{"club","diamond","heart","spade"};
		String[] ranks = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};//write them out
		
		for(int i=0; i<suits.length; i++)
		{
			Card c = new Card();
			c.setSuit(suits [i]);
			for(int j = 0; j<ranks.length; j++)
			{
				c.setRank(ranks [j]);
				cards.add(c);
				System.out.print(cards.get(i).getSuit()+ ", "+cards.get(i).getRank());
			}
		}
	}
	
	public void addCard(Card c)
	{
		cards.add(c);
	}
	
	public ArrayList<Card> getCards()
	{
		return cards;
	}
	
} 
