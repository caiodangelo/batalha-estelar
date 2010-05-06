package logica;

import java.util.Vector;

/**
 * Implements the Player class
 * @author Vitor
 *
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
	
	public boolean isReady()
	{
		return this.readyToStart;
	}
	
	public void setPlayerName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Initializes the player's board.
	 * @param boardSize	The size of the board.
	 * @param shipList	The ship list of the board.
	 * @return
	 */
	public void initializeBoard(int boardSize, Vector<Ship> shipList)
	{
		this.board = new Board(boardSize, shipList);
		this.readyToStart = true;
	}
	
}
