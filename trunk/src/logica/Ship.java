package logica;

import java.awt.Point;
import java.util.Vector;

/**
 * Implements the Ship Class. A ship has a name, size, base
 * position and a flag that indicates if it has been sunk.
 * The size attribute indicates both X and Y sizes. That is,
 * if the size is 2, then the ship is a 2 by 2 square.
 * @TO-DO create an abstract class for Ship and make the 
 * "square size" type of ship a subclass inherited from it.
 * @author Vitor / Caio
 * @version 1.0
 */
public class Ship {
	
	private String name;
	private int size;
	private Point position;
	
	/**
	 * Constructs and Initializes a new ship at the
	 * specified position.
	 * @param name		The name of the ship.
	 * @param size		The sizes of both X and Y directions
	 * 					of the ship.
	 * @param position	The position of the ship on the board.
	 */
	public Ship(String name, int size, Point position) {
		this.name = name;
		this.size = size;
		this.position = position;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public Point getPosition()
	{
		return this.position;
	}
	
	public void setPosition(Point position)
	{
		this.position = position;
	}
	
	/**
	 * Gets all locations that belong to this ship.
	 * @return Vector of Points.
	 */
	public Vector<Point> getAllLocations()
	{
		Vector<Point> locations = new Vector<Point>();
		for (int x = position.x; x < position.x + size; x++)
		{
			for (int y = position.y; y < position.y + size; y++)
			{
				locations.add(new Point(x,y));
			}
		}
		return locations;
	}
	
	/**
	 * Checks conflict with another ship.
	 * @param otherShip	The other ship to check conflict with.
	 * @return 			true if the ships conflict, false if they don't
	 */
	public boolean conflictsWith(Ship otherShip)
	{
		for (Point otherShipLocation : otherShip.getAllLocations())
		{
			if (this.isAt(otherShipLocation))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if the ship contains the specified Point.
	 * @param location	location to check.
	 * @return 			true if the location is part of the ship's points, false if it isn't.
	 */
	public boolean isAt(Point location)
	{
		return ((this.position.x <= location.x) && (this.position.x + this.size > location.x) &&
				(this.position.y <= location.y) && (this.position.y + this.size > location.y));
	}
	
	/**
	 * Checks if a ship is sunk.
	 * @param Shots the shots list.
	 * @return		True if the ship is sunk, False if it's not.
	 */
	public boolean isSunk(Vector<Point> Shots)
	{
		for (Point point : getAllLocations())
		{
			if (!Shots.contains(point))
			{
				return false;
			}
		}
		return true;
	}
}
