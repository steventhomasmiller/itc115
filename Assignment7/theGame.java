package com.spconger.Assignment7;

import acm.program.GraphicsProgram;
import java.awt.Color;
import java.awt.event.KeyEvent;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;

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
		addMouseListeners();
		addKeyListeners();
		getMouseListeners();
		waitForClick();
	}
	
	public void gamePlay()
	{
		for (int i = gameTurns; i>0; i--)
		{
			play = true;
			moveBall();
		}
		if (gameScore == 199)
		{
			gameWon();
		}
		else
		{
			gameLost();
		}
	}
	
	public void setApplet()
	{
		setSize(APP_WIDTH, APP_HEIGHT);
	}
	
	public void makeBrick(int x, int y, Color color)
	{
		brick = new GRect(x,y, BRICK_WIDTH, BRICK_HEIGHT);
		brick.setFillColor(color);
		brick.setFilled(true);
		add(brick);
	}
	
	public void makeBricks()
	{
		Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
				Color.CYAN };
		for (int row = 0; row < NUM_BRICK_ROWS; row++)
		{
			for (int col = 0; col < NUM_BRICK_COLUMNS; col++)
			{
				makeBrick((BRICK_WIDTH + SEPARATION) * col, BRICK_Y_OFFSET
						+ (BRICK_HEIGHT + SEPARATION) * row, colors[row / 2]);
			}
		}
	}
	
	public void makePaddle()
	{
		paddle = new Grect((APP_WIDTH - PADDLE_WIDTH) / 2, APP_HEIGHT
				- (PADDLE_Y_OFFSET + PADDLE_HEIGHT), PADDLE_WIDTH, 
				PADDLE_HEIGHT);
		paddle.setColor(Color.DARK_GRAY);
		paddle.setFilled(true);
		add(paddle);
	}
	
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_RIGHT:
			if (paddle.getX() + PADDLE_WIDTH < APP_WIDTH)
			paddle.move(PADDLE_MOVE, 0);
			break;
		case KeyEvent.VK_LEFT:
			if (paddle.getX() > 0)
				paddle.move(-PADDLE_MOVE, 0);
			break;
		default:
			break;
		}
	}
	
	public void makeBall()
	{
		ball = new GOval(BALL_START_X, BALL_START_Y, BALL_RADIUS * 2,
				BALL_RADIUS * 2);
		ball.setColor(Color.DARK_GRAY);
		ball.setFilled(true);
		add(ball);
	}
	
	private void initialBallMovement()
	{
		RandomGenerator rgen = new RandomGenerator();
		vy = rgen.nextDouble(LOWER_LIMIT, UPPER_LIMIT);
		vx = rgen.nextDouble(LOWER_LIMIT, UPPER_LIMIT);
		if (rgen.nextBoolean())
		{
			vx = -vx;
		}
	}
	
	private void moveBall()
	{
		initialBallMovement();
		while (play == true)
		{
			checkForCollision();
			ball.move(vx, vy);
			pause(10);
		}
	}
	
	private void checkForCollision()
	{
		bounceBallWithWall();
		establishBallCorners();
	}
	
	public void bounceBallWithWall()
	{
		if (ball.getX() + BALL_RADIUS < 0
				|| ball.getx() + BALL_RADIUS < APP_WIDTH)
		{
			vx = -vx;
		}
		else if (ball.getY() + BALL_RADIUS < 0)
		{
			vy = -vy;
		}
		else if (ball.getY() + BALL_RADIUS > APP_HEIGHT)
		{
			play = false;
			newTurn();
		}
	}
	
	private void establishBallCorners()
	{
		if (checkCollisionPoints(ball.getX(), ball.getY()))
			return;
		if (checkCollisionPoints(ball.getX()), ((ball.getY() + BALL_RADIUS * 2))))
		return;
		if (checkCollisionPoints((ball.getX() + BALL_RADIUS * 2),
				(ball.getY() + BALL_RADIUS * 2)))
		return;
	}
	
	public boolean checkCollisionPoints (double x, double y)
	{
		collider = getElement (x,y);
		if (collider == null)
		{
			return false;
		}
		if (collider == paddle)
		{
			vy = -Math.abs(vy);
			return true;
		}
		else
		{
			remove(collider);
			vy = -vy;
			gameScore--;
			if (gameScore == 0)
			{
				gameWon();
			}
			return true;
		}
	}
	
	public void gameWon()
	{
		removeAll();
		gameTurns = 0;
		GLabel win = new GLabel("You hath won the great Brick Breaker Game");
		win.setLocation(APP_WIDTH /2, APP_HEIGHT / 2);
		add(win);
	}
	
	public void gameLost()
	{
		removeAll();
		GLabel lose = new GLabel("I am most sorrowful to tell you that you hath not won the great Brick Breaker Game");
		add(lose);
	}
	
	public void newTurn()
	{
		gameTurns--;
		remove(ball);
		makeBall();
	}
}
