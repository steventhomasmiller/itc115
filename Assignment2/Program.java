package com.spconger.Assignment2;

import java.util.Random;
import java.util.Scanner;

public class Program {
	
	Scanner scan = new Scanner(System.in);
	
	int triesNumber = 0;
	
	public static void main(String[] args) {
		Program p = new Program();
		p.guessingGame();

	}
	
	private int getRandom()
	{
		Random r = new Random();
		int number=r.nextInt(500);
		return number;
	}
	
	private void guessingGame()
	{
		System.out.println("Guess a number between 0 and 500");
		boolean correct = false;
		
		do
		{
			int guess;
			guess = scan.nextInt();
			triesNumber++;
			int guessNumber = getRandom();
			

			if (guess == guessNumber)
			{
				correct = true;
				System.out.println("The number was " + guessNumber);
				System.out.println("Your total points: " + triesNumber);
				break;
				
			}
			else if (guess < guessNumber)
			{
				System.out.println("Sorry, that guess is too low.");
			}
			else if (guess > guessNumber)
			{
				System.out.println("Your guess is too high.");
			}
			
			if (triesNumber > 10){
				System.out.println("Time's up!");
				break;
			}
				
			
		} while (correct == false);
		
		playAgain();
	}
	
	private void playAgain()
	{
		System.out.println("Would you like to play again? Y or N");
		String play = scan.next();
		if (play.equalsIgnoreCase("y"))
		{
			guessingGame();
		}
		else if (play.equalsIgnoreCase("n"))
		{
			System.out.println("Bugger off, then!");
		}
	}

}
