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
	private Vector<Ship> shipList;
	
	Player (String playerName)
	{
		this.name = playerName;
	}
	
	public String getPlayerName()
	{
		return this.name;
	}
	
	public void setPlayerName(String name)
	{
		this.name = name;
	}
	
	public void setShipList(Vector<Ship> shipList)
	{
		
	}
	
}
