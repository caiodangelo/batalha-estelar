package logica;

import java.awt.Point;

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
	private boolean sunk;
	
	public Ship(String name, int size, Point position) {
		super();
		this.name = name;
		this.size = size;
		this.position = position;
		this.sunk = false;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getSize()
	{
		return this.size;
	}

	public boolean getSunk()
	{
		return this.sunk;
	}
	public void setSunk(boolean sunk)
	{
		this.sunk = sunk;
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
	 * Checks if the ship contains the specified Point.
	 * @param location	location to check
	 * @return 			true if the location is part of the ship's points, false if it isn't
	 */
	public boolean isAt(Point location)
	{
		return ((this.position.x <= location.x) && (this.position.x + this.size > location.x) &&
				(this.position.y <= location.y) && (this.position.y + this.size > location.y));
	}

}
