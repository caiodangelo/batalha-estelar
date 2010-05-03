package logica;

import junit.framework.TestCase;

public class CellTest extends TestCase {
	private Cell cell;
	
	protected void setUp() throws Exception {
		cell = new Cell(2,2);
	}
	
	public void testCellConstructor() throws Exception {
		assertEquals(2, cell.getLocation().x);
	}

}
