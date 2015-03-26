package Quiz4;

public class Program 
{
	/*
	 * This calls the sounds from the other classes.
	 * Steve Miller, 3/26/15
	 */

	public static void main(String[] args) 
	{
		Horsey horsey = new Horsey();
		Whale whale = new Whale();
		System.out.println("This is what a horsey says: " + "'" + horsey.makeSound() + ".'");
		System.out.println("This is what a whale says: " + "'" + whale.makeSound() + ".'");

	}

}
