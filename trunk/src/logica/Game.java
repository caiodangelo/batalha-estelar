package logica;

import java.awt.Point;
import java.util.Random;
import java.util.Vector;

/**
 * Implements the Game class.
 * @author Vitor / Caio
 * @version 1.0
 */
public class Game {
	
	private GameState gameState;
	private Player player1;
	private Player player2;
	private Player turn;
	private int boardSize;
	
	/**
	 * Constructs and Initializes a new game.
	 * @param boardSize NxN size of each board.
	 * @param shipCount Number of ships per player.
	 */
	Game(int boardSize)
	{
		this.boardSize = boardSize;
		this.gameState = GameState.WaitingForPlayers;
	}
	
	public GameState getGameState()
	{
		return this.gameState;
	}
	
	public int getBoardSize()
	{
		return this.boardSize;
	}
	
	/**
	 * Adds a player to the game.
	 * @param playerName Name of the player to add.
	 * @return			 True if the player was added successfully
	 * 		  			 False if the game was already full.
	 */
	public boolean addPlayer (String playerName)
	{
		if (player1 == null)
		{
			player1 = new Player(playerName);
		}
		else if (player2 == null)
		{
			player2 = new Player(playerName);
			this.gameState = GameState.Initializing;
		}
		else { return false; }
		return true;
	}

	/**
	 * Validates the Ship List passed as a parameter
	 * from the Servlet.
	 * @param	shipList List of ships to validate.
	 * @return			 Result of the validation in the form of a
	 * 		   			 ValidationCode.
	 */
	public ValidationCode validateShipList(Vector<Ship> shipList)
	{
		for (int i = 0; i < shipList.size(); i++)
		{
			for (int j = i + 1; j < shipList.size(); j++)
			{
				Ship ship1 = shipList.get(i);
				Ship ship2 = shipList.get(j);
				if (ship1.conflictsWith(ship2))
				//if (shipList.get(i).conflictsWith(shipList.get(j)))
				{
					return ValidationCode.ShipLocationError;
				}
			}
		}
		return ValidationCode.ValidationOK;
	}
	
	/**
	 * Initializes the board of a given player. Note that the ship
	 * list is supposed to be already validated by the servlet.
	 * @param playerName Name of the player to set.
	 * @param shipList	 Vector containing the ship list.
	 */
	public void initializePlayerBoard (String playerName, Vector<Ship> shipList)
	{
		Player player = getPlayerByName(playerName);
		player.initializeBoard(this.boardSize, shipList);
	}
	
	/**
	 * Attempts to start the game. Will be successful if both
	 * players are ready.
	 * @return True if the game started successfully, False
	 * 		   if it didn't.
	 */
	public boolean startGame()
	{
		if (isGameReady())
		{
			this.gameState = GameState.InProgress;
			Random random = new Random();
			if (random.nextDouble() >= 0.5)
			{
				this.turn = this.player2;
			}
			else
			{
				this.turn = this.player1;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if it's a given player's turn.
	 * @param playerName Name of the player.
	 * @return			 True if it is his turn, False it it isn't.
	 */
	public boolean isPlayersTurn(String playerName)
	{
		return turn.getPlayerName().equals(playerName);
	}
	
	/**
	 * Attempts to shoot at the adversary.
	 * @param playerName Name of the player doing the shot.
	 * @return 			 True if the shot was completed, False 
	 * 					 if it wasn't. 
	 */
	public ShotResult doShot(String playerName, Point shot)
	{
		ShotResult result;
		Player playerShooting = getPlayerByName(playerName);
		Player playerBeingShot = getOpposingPlayer(playerName);
		// Test if the player attempting the shot is this turn's player.
		if (turn != playerShooting)
		{
			return ShotResult.NotYourTurn;
		}
		
		result = playerBeingShot.getShot(shot);
		if (result == ShotResult.AllShipsSunk)
		{
			this.gameState = GameState.Ended;
		}
		changeTurns();
		return result;
	}
	
	/**
	 * Gets a Cell grid that represents the current state of the
	 * player's board. Used to generate the HTML table that will
	 * be displayed to the user.
	 * @param playerName Name of the player asking for the table.
	 * @return			 Cell grid that represents the current
	 * 					 state of the player's board.
	 */
	public Cell[][] getPlayerBoard(String playerName)
	{
		Player player = getPlayerByName(playerName);
		return player.getBoardState();
	}
	
	/**
	 * Gets a Cell grid that represents the current state of the
	 * opponent's board. Used to generate the HTML table that will
	 * be displayed to the user.
	 * @param playerName Name of the player asking for the table.
	 * @return			 Cell grid that represents the current
	 * 					 state of the opponent's board.
	 */
	public Cell[][] getOpponentBoard(String playerName)
	{
		Player player = getOpposingPlayer(playerName);
		return player.getRestrictedBoardState();
	}
	
	/**
	 * Get the player instance by its name
	 * @param playerName name of the player to get.
	 * @return			 Player instance with the name provided.
	 */
	private Player getPlayerByName(String playerName)
	{
		if (playerName.equals(player1.getPlayerName()))
		{
			return player1;
		}
		else if (playerName.equals(player2.getPlayerName()))
		{
			return player2;
		}
		else return null;
	}
	
	/**
	 * Gets the opposing player of a given player's name.
	 * @param playerName Name of the player.
	 * @return		 	 The opposing player's instance.
	 */
	private Player getOpposingPlayer(String playerName)
	{
		if (playerName.equals(player1.getPlayerName()))
		{
			return player2;
		}
		else
		{
			return player1;
		}
	}
	
	/**
	 * Checks if the game is ready to start.
	 * @return True if the game is ready, False if it's not.
	 */
	private boolean isGameReady()
	{
		if (player1 == null || player2 == null)
		{
			return false;
		}
		if (player1.isReady() && player2.isReady())
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Swaps Turns.
	 */
	private void changeTurns()
	{
		if (turn.equals(player1))
		{
			turn = player2;
		}
		else 
		{
			turn = player1;
		}
	}
}
