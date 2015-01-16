package com.spconger.Assignment2;

import java.util.Random;
import java.util.Scanner;

public class Program {
	/* This class generates a random number, gets the user's guesses, 
	 * keeps track of score, and prompts user to play again 
	 * Steve Miller, 1/16/15 */
	
	Scanner scan = new Scanner(System.in);
	
	int triesNumber = 0;
	
	public static void main(String[] args) {
		Program p = new Program();
		p.guessingGame();
	}
	
	private int getRandom() //gets random number
	{
		Random r = new Random();
		int number=r.nextInt(500);
		return number;
	}
	
	private void guessingGame()
	{
		System.out.println("Guess a number between 0 and 500"); //prompts user
		boolean correct = false;
		
		do
		{
			int guess;
			guess = scan.nextInt();
			triesNumber++;
			int guessNumber = getRandom();
			

			if (guess == guessNumber) //for correct guesses
			{
				correct = true;
				System.out.println("The number was " + guessNumber);
				System.out.println("Your total points: " + triesNumber);
				break; //ends the loop if correct
				
			}
			else if (guess < guessNumber)
			{
				System.out.println("Sorry, that guess is too low.");
			}
			else if (guess > guessNumber)
			{
				System.out.println("Sorry, that guess is too high.");
			}
			
			if (triesNumber > 10){
				System.out.println("Too many tries!");
				break;
			}
				
			
		} while (correct == false);
		
		playAgain();
	}
	
	private void playAgain()
	{
		System.out.println("Would you like to play again? Y or N");
		String play = scan.next();
		if (play.equalsIgnoreCase("y")) //works for lower or upper case
		{
			guessingGame(); //calls game again
		}
		else if (play.equalsIgnoreCase("n"))
		{
			System.out.println("Bugger off, then!"); //exits the game
		}
	}

}
