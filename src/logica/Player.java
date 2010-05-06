package logica;

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
	
}
