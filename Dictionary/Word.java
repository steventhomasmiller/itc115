package com.spconger.DictionaryProgram;

public class Word {
	
	private String word; //auto getters and setters only available private variables at class level
	private String definition;
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getDefinition() {
		return definition;
	}
	
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	public String toString()
	{
		return getWord () + "--" + getDefinition();
	}

}
