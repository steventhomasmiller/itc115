package com.spconger.Assignment4a;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Random;

public class Deck 
{
	/* This class shuffles the deck and deals the new cards.
	 * It also declares the suits and ranks values
	 * Steve Miller, 2/3/15
	 */
	
	final String Suits[] = { "hearts", "spades", "diamonds", "clubs" };
	private String Ranks[] = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	
	private ArrayList<Card> cards;
	
	//constructor; must match class name
	public Deck()
	{
		cards = new ArrayList<Card>();
	}
	
	public ArrayList<Card> cardHand(int dealtHand) //shows the hand the player is dealt
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		
		fillDeck();
		
		shuffle(cards); //shuffles the ranks and suits
		
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
	
	public void fillDeck()//grabs the rank and suit of card dealt
	{
		for (String suit: Suits)
		{
			for (String rank: Ranks)
			{
				Card card = new Card();
				card.setSuit(suit);
				card.setRank(rank);
				cards.add(card);
			}
		}
	}
	
	private void shuffle(ArrayList<Card> deck)//shuffles the entire deck
	{
		Collections.shuffle(deck);
	}
	
}
