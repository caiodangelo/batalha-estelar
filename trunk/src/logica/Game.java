package logica;

import java.util.Vector;

/**
 * Implements the Game class.
 * @author Vitor / Caio
 *
 */
public class Game {
	
	private GameState gameState;
	private Player player1;
	private Player player2;
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
		}
		else { return false; }
		return true;
	}
	
	/**
	 * Sets the ship list of a given player.
	 * @param playerName The name of the player to set.
	 * @param shipList	 The Vector containing the shiplist.
	 */
	public void setPlayerShipList (String playerName, Vector<Ship> shipList)
	{
		Player player = getPlayerByName(playerName);
		player.setShipList(shipList);
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
				if (shipList.get(i).conflictsWith(shipList.get(j)))
				{
					return ValidationCode.ShipLocationError;
				}
			}
		}
		return ValidationCode.ValidationOK;
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
	
}
