package com.spconger.Assignment3;

public class Stats {
	
	/* This class gets player's number of hits, walks, outs and at bats.
	 * It also calculates batting average and on-base percentage
	 * Steve Miller, 1/21/15 */
	
	//private fields
	
		private int numTotalBats;
		private int numHits;
		private int numOuts;
		private int numWalks;

		//public getters and setters
		//accessors and mutators
		
		public int getNumTotalBats()
		{
			return numTotalBats;
		}
		
		public void setNumTotalBats(int numTotalBats)
		{
			this.numTotalBats = numTotalBats;
		}
		
		public int getNumHits()
		{
			return numHits;
		}
		
		public void setNumHits(int numHits)
		{
			this.numHits = numHits;
		}
		
		public int getNumOuts()
		{
			return numOuts;
		}
		
		public void setNumOuts(int numOuts)
		{
			this.numOuts = numOuts;
		}
		
		public int getNumWalks()
		{
			return numWalks;
		}
		
		public void setNumWalks(int numWalks)
		{
			this.numWalks = numWalks;
		}
		
		//public methods
		public double calculateBattingAverage() //double because it's a decimal
		{
			return 1.0 * getNumHits() / getNumTotalBats(); //multiply by 1.0 to make percentage
		}
		
		public double calculateOnBasePercentage() //same as above
		{
			return 1.0 * (getNumHits() + getNumWalks()) / getNumTotalBats(); //same as above
		}

}
