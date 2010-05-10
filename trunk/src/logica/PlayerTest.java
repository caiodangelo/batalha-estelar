package logica;

import java.awt.Point;
import java.util.Vector;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	private Player player;
	private Vector<Ship> shipList;
	
	protected void setUp() throws Exception {
		player = new Player("playerTest");
		shipList = new Vector<Ship>();
		shipList.add(new Ship("teste1",1,new Point(1,1)));
		shipList.add(new Ship("teste2",2,new Point(3,1)));
		player.initializeBoard(15, shipList);
	}
	
	public void testReadyToStart() throws Exception {
		assertEquals(true, player.isReady());
	}
	
	public void testGetShotShipSunk() throws Exception {
		assertEquals(ShotResult.ShipSunk, player.getShot(new Point(1,1)));
	}
	
	public void testGetShotShipHit() throws Exception {
		assertEquals(ShotResult.ShipHit, player.getShot(new Point(3,1)));
	}
	
	public void testGetShotMiss() throws Exception {
		assertEquals(ShotResult.Miss, player.getShot(new Point(5,5)));
	}
	
	public void testGetShotShipHitNotMainLocationPoint() throws Exception {
		assertEquals(ShotResult.ShipHit, player.getShot(new Point(4,1)));
	}
	
	public void testGetShotAllShipsSunk() throws Exception {
		player.getShot(new Point(1,1));
		player.getShot(new Point(3,1));
		player.getShot(new Point(3,2));
		player.getShot(new Point(4,1));
		assertEquals(ShotResult.AllShipsSunk, player.getShot(new Point(4,2)));
	}
}