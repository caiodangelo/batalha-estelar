package logica;

import java.awt.Point;
import java.util.Vector;

/**
 * Implements the Board class.
 * @author Vitor / Caio
 * @version 1.0
 */
public class Board {
	
	private Vector<Point> shotList;
	private Vector<Ship> shipList;
	private Cell[][] board;
	private int boardSize;
	
	/**
	 * Constructs and Initializes a new Board.
	 * @param boardSize The N by N size of the new Board.
	 * @param shipCount The number of ships allowed on the Board.
	 */
	Board(int boardSize, Vector<Ship> shipList)
	{
		this.shotList = new Vector<Point>();
		this.shipList = shipList;
		this.boardSize = boardSize;
		this.board = null;
	}

	public Vector<Ship> getShipList()
	{
		return this.shipList;
	}
	
	public void setShipList(Vector<Ship> ships)
	{
		this.shipList = ships;
	}
	
	public Vector<Point> getShotList()
	{
		return this.shotList;
	}
	
	public Cell[][] getBoardState()
	{
		// Check if an older version of the board already exists
		if (board == null)
		{
			board = new Cell[boardSize][boardSize];
			for (int i = 0; i < boardSize; i++)
			{
				for (int j = 0; j < boardSize; j++)
				{
					board[i][j].setLocation(i, j);
				}
			}
		}
		// Update hasShip and wasHit of the Cells
		for (Ship ship : shipList)
		{
			for (Point point : ship.getAllLocations())
			{
				board[point.x][point.y].setHasShip(true);
			}
		}
		for (Point point : shotList)
		{
			board[point.x][point.y].setIsHit(true);
		}
		return board;
	}
	
	public Cell[][] getRestrictedBoardState()
	{
		// Check if an older version of the board already exists
		if (board == null)
		{
			board = new Cell[boardSize][boardSize];
			for (int i = 0; i < boardSize; i++)
			{
				for (int j = 0; j < boardSize; j++)
				{
					board[i][j].setLocation(i, j);
				}
			}
		}
		// Update wasHit of the Cells
		for (Point point : shotList)
		{
			board[point.x][point.y].setIsHit(true);
		}
		
		Cell[][] restrictedBoard = board.clone();
		for (int i = 0; i < boardSize; i++)
		{
			for (int j = 0; j < boardSize; j++)
			{
				restrictedBoard[i][j].setHasShip(false);
			}
		}
		return restrictedBoard;
	}
}
