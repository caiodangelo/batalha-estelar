package logica;

import java.awt.Point;

import junit.framework.TestCase;

public class ShipTest extends TestCase {
	private Ship ship;
	
	protected void setUp() throws Exception {
		ship = new Ship("teste",2,new Point(0,0));
	}
	
	public void testIsAtPointInside() throws Exception {
		assertEquals(true, ship.isAt(new Point(0,1)));
	}
	
	public void testIsAtPointOnTheEdge() throws Exception {
		assertEquals(true, ship.isAt(new Point(1,1)));
	}
	
	public void testIsAtPointOutside() throws Exception {
		assertEquals(false, ship.isAt(new Point(4,1)));
	}
}
