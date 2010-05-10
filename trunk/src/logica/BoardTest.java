package logica;

import junit.framework.TestCase;

public class BoardTest extends TestCase {
	@SuppressWarnings("unused")
	private Board board;
	
	protected void setUp() throws Exception {
		board = new Board(15,null);
	}

}
