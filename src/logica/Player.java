package logica;

import java.awt.Point;
import java.util.Vector;

/**
 * Implements the Player class
 * @author Vitor / Caio
 * @version 1.0
 */
public class Player {
	
	private String name;
	private Board board;
	private boolean readyToStart;
	
	Player (String playerName)
	{
		this.name = playerName;
		this.readyToStart = false;
	}
	
	public String getPlayerName()
	{
		return this.name;
	}
	
	public void setPlayerName(String name)
	{
		this.name = name;
	}
	
	public boolean isReady()
	{
		return this.readyToStart;
	}
	
	/**
	 * Initializes the player's board.
	 * @param boardSize	The size of the board.
	 * @param shipList	The ship list of the board.
	 */
	public void initializeBoard(int boardSize, Vector<Ship> shipList)
	{
		this.board = new Board(boardSize, shipList);
		this.readyToStart = true;
	}
	
	/**
	 * Gets a representation of the player's board.
	 * @return Board representation.
	 */
	public Cell[][] getBoardState()
	{
		return board.getBoardState();
	}
	
	/**
	 * Gets a restricted representation of the player's board,
	 * that is, the board's representation as seen by his 
	 * opponent.
	 * @return Restricted board representation.
	 */
	public Cell[][] getRestrictedBoardState()
	{
		return board.getRestrictedBoardState();
	}

	/**
	 * Process a shot made by the other player.
	 * @param shot Shot to process.
	 * @return	   ShotResult related to the result of the shot.
	 */
	public ShotResult getShot(Point shot)
	{
		Vector<Point> shotList = board.getShotList();
		Vector<Ship> shipList = board.getShipList();
		Ship ship = null;
		
		// Check if shot was already done before.
		if (shotList.contains(shot)) { return ShotResult.ShotAlreadyDone; }
		shotList.add(shot);
		// Check if a ship was hit.
		for (Ship tempShip : shipList)
		{
			if (tempShip.isAt(shot))
			{
				ship = tempShip;
				break;
			}
		}
		if (ship == null) { return ShotResult.Miss; }
		// Check if the ship that was hit sank.
		if (!ship.isSunk(shotList))
		{
			if (ship.getName().startsWith("Xwing"))
			{
				return ShotResult.XWingHit;
			}
			else if (ship.getName().startsWith("Falcon"))
			{
				return ShotResult.FalconHit;
			}
			else
			{
				return ShotResult.DestroyerHit;
			}
		}
		// Check if all ships have sunk.
		for (Ship tempShip : shipList)
		{
			if (!tempShip.isSunk(shotList))
			{
				if (ship.getName().startsWith("Xwing"))
				{
					return ShotResult.XWingSunk;
				}
				else if (ship.getName().startsWith("Falcon"))
				{
					return ShotResult.FalconSunk;
				}
				else
				{
					return ShotResult.DestroyerSunk;
				}
			}
		}
		return ShotResult.AllShipsSunk;
	}
}
