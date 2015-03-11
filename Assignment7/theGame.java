package com.spconger.Assignment7;

import acm.program.GraphicsProgram; //I'll have to input this in the school's computers

public class theGame extends GraphicsProgram
{
	//Constants for Applet
	public static final int APP_WIDTH=400;
	public static final int APP_HEIGHT= 600;
	
	//Constants for Brick
	public static final int SEPARATION = 4;
	public static final int BRICK_WIDTH = (APP_WIDTH - (SEPARATION *10)) /10 ;
	public static final int NUM_BRICK_ROWS = 10;
	public static final int NUM_BRICK_COLUMNS = 10;
	public static final int BRICK_HEIGHT = 8;
	public static final int BRICK_Y_OFFSET = 70;
	
	//Constants for paddle
	public static final int PADDLE_Y_OFFSET = 30;
	public static final int PADDLE_WIDTH = 60;
	public static final int PADDLE_HEIGHT = 10;
	public static final int PADDLE_MOVE = 10;
	
	//Constants and variables for ball
	public static final int BALL_RADIUS = 10;
	public static final int BALL_START_X = (APP_WIDTH - BALL_RADIUS * 2) / 2;
	public static final int BALL_START_Y = (APP_HEIGHT - BALL_RADIUS * 2) / 2;
	private static double LOWER_LIMIT = 1.0;
	private static double UPPER_LIMIT = 3.0;
	private double vx, vy;
	
	//Game variables
	private boolean play = true;
	public int gameTurns = 3;
	public int gameScore = 100;
	
	//Game objects
	private GRect paddle; //add this as well
	private GRect brick;
	private GOval ball;
	private GObject collider;
	
	public void run()
	{
		gameSetup();
		gamePlay();
	}
	
	public void gameSetup()
	{
		setApplet();
		makeBricks();
		makePaddle();
		makeBall();
		
	}
	
}
