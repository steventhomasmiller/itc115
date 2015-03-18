package assignment7;
import java.awt.Color;
import java.awt.event.KeyEvent;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class assignment7-2 extends GraphicsProgram
{
	/*
	This class creates everything we need for the brick breaker game.
	It sets the brick height, width and colors, and also establishes the brick rows.
	This also creates the ball and its components (such as shape, size, starting point and velocity).
	Further, it sets boundaries for the game, as well as keeps the user's score.
	Steve Miller
	3/18/15
	 */

	// Constants for Applet:
	public static final int APP_WIDTH = 400;
	public static final int APP_HEIGHT = 600;

	// Constants for Brick:
	public static final int SEPARATION = 4;
	public static final int BRICK_WIDTH = (APP_WIDTH - (SEPARATION * 10)) / 10;
	public static final int NUM_BRICK_ROWS = 10;
	public static final int NUM_BRICK_COLUMNS = 10;
	public static final int BRICK_HEIGHT = 8;
	public static final int BRICK_Y_OFFSET = 70;

	// Constants for paddle
	public static final int PADDLE_Y_OFFSET = 30;
	public static final int PADDLE_WIDTH = 60;
	public static final int PADDLE_HEIGHT = 10;
	public static final int PADDLE_MOVE = 6;

	// Constants for Ball:
	public static final int BALL_RADIUS = 10;
	public static final int BALL_START_X = (APP_WIDTH - BALL_RADIUS * 2) / 2;
	public static final int BALL_START_Y = (APP_HEIGHT - BALL_RADIUS * 2) / 2;

	// Sets how many times you can play the game
	public int gameTurns = 3;
	public int gameScore = 0;
	private double vx, vy;
	private GRect paddle;
	private GRect brick;
	private GOval ball;
	private GObject collider;
	
	public void run() // implements the Runnable interface
	{
		gameSetup();
		moveBall();
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
	}

	public void gamePlay()
	{
		do
		{
			moveBall();
		} while (gameTurns != 0);
		if (gameTurns == 0)
		{
			gameLost();
		}
		if (gameScore == 100)
		{
			gameWon();
		}
	}
	public void setApplet()
	{
		setSize(APP_WIDTH, APP_HEIGHT);
	}

	// makes the brick:
	public void makeBrick(int x, int y, Color color)
	{
		brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		brick.setFillColor(color);
		brick.setFilled(true);
		add(brick);
	}

	// making bricks 10rows, 10columns and 2rows each coloring
	public void makeBricks()
	{
		Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN };
		// making bricks 10rows, 10columns
		for (int row = 0; row < NUM_BRICK_ROWS; row++)
		{
			for (int col = 0; col < NUM_BRICK_COLUMNS; col++)
			{
				makeBrick((BRICK_WIDTH + SEPARATION) * col, BRICK_Y_OFFSET + (BRICK_HEIGHT + SEPARATION) * row, colors[row / 2]);
				// 2 rows each coloring
			}
		}
	}
	
	// make the paddle:
	public void makePaddle()
	{
		paddle = new GRect((APP_WIDTH - PADDLE_WIDTH) / 2, APP_HEIGHT - (PADDLE_Y_OFFSET + PADDLE_HEIGHT), PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setColor(Color.DARK_GRAY);
		paddle.setFilled(true);
		add(paddle);
	}

	// make the ball:
	public void makeBall()
	{
		ball = new GOval(BALL_START_X, BALL_START_Y, BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setColor(Color.DARK_GRAY);
		ball.setFilled(true);
		add(ball);
	}

	// move the paddle;
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode()) {
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
	// making a ball velocity
	private void initialBallMovement()
	{
		RandomGenerator rgen = new RandomGenerator();
		vy = rgen.nextDouble(1, 3);
		vx = rgen.nextDouble(1, 3);
		if (rgen.nextBoolean())
		{
			vx = -vx;
		}
	}

	private void moveBall()
	{
		initialBallMovement();
		while (ball.getY() != APP_HEIGHT)
		{
			checkForCollision();
			ball.move(vx, vy);
			pause(10);
		}
		gameTurns--;
	}

	private void checkForCollision()
	{
		bounceBallWithWall();
		establishBallCorners();
	}

	public void bounceBallWithWall()
	{
		if (ball.getX() + BALL_RADIUS < 0 || ball.getX() + BALL_RADIUS > APP_WIDTH)
		{
			vx = -vx;
		} else if (ball.getY() + BALL_RADIUS <= 0)
		{
			vy = -vy;
		} else
		{
			newTurn();
		}
	}

	private void establishBallCorners()
	{
		if (checkCollisionPoints(ball.getX(), ball.getY()))
			return;
		if (checkCollisionPoints((ball.getX() + BALL_RADIUS * 2), (ball.getY())))
			return;
		if (checkCollisionPoints((ball.getX()), ((ball.getY() + BALL_RADIUS * 2))))
			return;
		if (checkCollisionPoints((ball.getX() + BALL_RADIUS * 2), (ball.getY() + BALL_RADIUS * 2)))
			return;
	}

	public boolean checkCollisionPoints(double x, double y)
	{
		collider = getElementAt(x, y);
		if (collider == null)
		{
			return false;
		}
		if (collider == paddle)
		{
			vy = -Math.abs(vy);
			return true;
		} else
		{
			remove(collider);
			vy = -vy;
			gameScore++;
			return true;
		}
	}

	public void gameWon()
	{
		removeAll();
	}

	public void gameLost()
	{
		removeAll();
	}
	public void newTurn()
	{
		if (ball.getY() + BALL_RADIUS > APP_HEIGHT)
		{
			remove(ball);
			gameTurns--;
			makeBall();
		}
	}
}
