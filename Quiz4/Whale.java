package Quiz4;

public class Whale implements Sounds 
{
	/*
	 * This class is for the whale sound
	 * Steve Miller, 3/26/15
	 */

	private String sound;
	
	@Override
	public String makeSound() //to be called in the program
	{
		sound = "Ooooowoaaaaaaaah";
		return sound;
	}
	
}
