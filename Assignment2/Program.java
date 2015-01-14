package com.spconger.Assignment2;

import java.util.Scanner;
import java.util.Scanner;

int triesNumber = 0;
int guess;
boolean correct = false;

public class Program {

	Scanner scan = new Scanner(Systerm.in);

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
		do
		{
			System.out.println("Guess a number between 1 and 1000");
			guess = input.nextInt();
			triesNumber++;
			int guessNumber = getRandom();

			if (guess == guessNumber)
			{
				correct = true;
				System.out.println("That is the number.");
				System.out.println("The number was" + guessNumber);
				System.out.println("Play again? Y/N");

			}
			else if (guess < guessNumber)
			{
				System.out.println("Sorry, that guess is too low.");
			}
			else if (guess > guessNumber)
			{
				System.out.println("Your guess is too high.")
			}
		} while (correct == false && triesNumber <= 10)
		
			// System.out.println("Sorry, you've exceeded the permitted number of guesses. You can no longer play this excellent game.");
			// System.out.println("Go home now.");

	}

}

