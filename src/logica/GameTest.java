package logica;

import java.awt.Point;
import java.util.Vector;

import junit.framework.TestCase;

public class GameTest extends TestCase {
	private Game game;
	private Vector<Ship> shipList;
	
	protected void setUp() throws Exception {
		game = new Game(15);
		shipList = new Vector<Ship>();
		shipList.add(new Ship("teste1",1,new Point(1,1)));
		shipList.add(new Ship("teste2",1,new Point(1,1)));
	}
	
	public void testShipConflict() throws Exception {
		assertEquals(true, shipList.get(0).conflictsWith(shipList.get(1)));
	}
	public void testValidateShipList() throws Exception {
		assertEquals(ValidationCode.ShipLocationError, game.validateShipList(shipList));
	}

}
