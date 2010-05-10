package logica;

import java.awt.Point;
import java.util.Vector;

import junit.framework.TestCase;

public class ShipTest extends TestCase {
	private Ship ship;
	private Ship otherShip;
	
	protected void setUp() throws Exception {
		ship = new Ship("teste",2,new Point(0,0));
		otherShip = new Ship("teste2", 2, new Point(1,0));
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
	
	public void testGetAllLocations() throws Exception {
		Vector<Point> locations = new Vector<Point>();
		locations.add(new Point(0,0));
		locations.add(new Point(0,1));
		locations.add(new Point(1,0));
		locations.add(new Point(1,1));
		assertEquals(locations, ship.getAllLocations());
	}
	
	public void testConflict() throws Exception {
		assertEquals(true, ship.conflictsWith(otherShip));
	}
	public void testConflict2() throws Exception {
		assertEquals(true, otherShip.conflictsWith(ship));
	}
}
