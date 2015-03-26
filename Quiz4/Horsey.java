package Quiz4;

public class Horsey implements Sounds
{
	/*
	 * This class is for the horsey sound
	 * Steve Miller 3/26/15
	 */
	
	private String sound;

	@Override
	public String makeSound() //to be used elsewhere
	{
		sound = "Nay. Nay"; //what I presume a horse says
		return sound;
	}

}
