package com.spconger.Assignment4a;

import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
	final String Suits[] = { "hearts", "spades", "diamonds", "clubs" };
	private String Ranks[] = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	
	private ArrayList<Card> cards;
	
	public Deck()
	{
		cards = new ArrayList<Card>();
	}
	
	public ArrayList<Card> cardHand(int dealtHand);
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		
		fillDeck();
		
		shuffle(cards);
		
		for (int i = 0; i < dealtHand; i++)
		{
			hand.add(cards.get(i));
		}
		
		return hand;
	}
	public ArrayList<Card> getDeck()
	{
		return cards;
	}
	
}
