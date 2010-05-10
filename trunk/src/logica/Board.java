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
	private Cell[][] grid;
	
	/**
	 * Constructs and Initializes a new Board.
	 * @param boardSize The N by N size of the new Board.
	 * @param shipCount The number of ships allowed on the Board.
	 */
	Board(int boardSize, Vector<Ship> shipList)
	{
		this.shotList = new Vector<Point>();
		this.shipList = shipList;
		this.grid = new Cell[boardSize][boardSize];
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
		Cell[][] boardState = grid.clone();
		return boardState;
	}
	
	public Cell[][] getRestrictedBoardState()
	{
		Cell[][] restrictedBoardState = grid.clone();
		return restrictedBoardState;
	}
	
}
