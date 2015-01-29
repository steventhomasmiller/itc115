package com.spconger.DictionaryProgram;

import java.util.ArrayList;

public class MyDictionary 
{	
	private ArrayList<Word> words; //list of those things; don't have to give it size, comes with more methods and functions
	
	public MyDictionary()
	{
		words = new ArrayList<Word>(); //makes it usable		
	}
	
	public void addWord(Word w)
	{
		words.add(w); //add card to deck
	}
	
	public void removeWord(Word w)
	{
		for(Word wd : words) //how java does foreach
		{
			if(wd.getWord().equals(w.getWord()))
			{
				words.remove(wd);
			}
		}
	}
	
	public ArrayList<Word> getWords()
	{
		return words; //use them elsewhere
	}
}
