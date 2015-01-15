package com.spconger.Assignment2;
import java.util.Random;
import java.util.Scanner;

public class Program {
	
	Scanner scan = new Scanner(System.in);
	
	int triesNumber = 0;
	int guess;
	boolean correct = false;

	public static void main(String[] args) {
		Program p = new Program();
		p.guessingGame();
	}
	
	private int getRandom()
	{
		Random r = new Random();
		int number=r.nextInt(1000);
		return number;
	}
	
	private void guessingGame()
	{
		System.out.println("Guess a number between 0 and 1000");
		
		do
		{
			guess = scan.nextInt();
			triesNumber++;
			int guessNumber = getRandom();
			

			if (guess == guessNumber)
			{
				correct = true;
				System.out.println("The number was " + guessNumber);
				playAgain();
			}
			else if (guess < guessNumber)
			{
				System.out.println("Sorry, that guess is too low.");
			}
			else if (guess > guessNumber)
			{
				System.out.println("Your guess is too high.");
			}
			
			if (triesNumber > 10)
				System.out.println("Time's up!");
			
		} while (correct == false);
		//System.out.println("You've exceeded the acceptable number of guesses.");
		
	}
	
	private void playAgain()
	{
		System.out.println("Would you like to play again? Y or N");
		String play = scan.nextLine();
		if (play == "y")
		{
			guessingGame();
		}
		else if (play == "n")
		{
			System.out.println("Bugger off, then!");
		}
	}

}
