package com.spconger.Assignment2;
import java.util.Random;
import java.util.Scanner;

public class Program {
	
	Scanner scan = new Scanner(System.in);
	
	int triesNumber = 0;
	int guess;
	String play;
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
		System.out.println("Guess a number between 1 and 1000");
		
		do
		{
			guess = scan.nextInt();
			triesNumber++;
			int guessNumber = getRandom();

			if (guess == guessNumber)
			{
				correct = true;
				System.out.println("That is the number.");
				System.out.println("The number was" + guessNumber);
				System.out.println("Play again? Y/N");
//				String play = nextString.playAgain(); //not sure this is right

			}
			else if (guess < guessNumber)
			{
				System.out.println("Sorry, that guess is too low.");
			}
			else if (guess > guessNumber)
			{
				System.out.println("Your guess is too high.");
			}
		} while (correct == false && triesNumber <= 10);
		System.out.println("You've exceeded the acceptable number of guesses.");
		
	}
	
//	private void playAgain()
//	{
//		if (play == "y" || "yes")
//		{
//			guessingGame();
//		}
//		else
//		{
//			System.out.println("Very well, then. You may leave.");
//		}
//	}

}
