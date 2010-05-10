package logica;

import java.awt.Point;
import java.util.Vector;

import junit.framework.TestCase;

public class BoardTest extends TestCase {
	private Board board;
	private Vector<Ship> shipList;
	private Vector<Point> shotList;
	
	protected void setUp() throws Exception {
		shipList = new Vector<Ship>();
		shipList.add(new Ship("teste1",1,new Point(1,1)));
		shipList.add(new Ship("teste2",1,new Point(3,1)));
		shipList.add(new Ship("teste3",1,new Point(14,14)));
		board = new Board(15,shipList);
		shotList = board.getShotList();
		shotList.add(new Point(1,1));
		shotList.add(new Point(4,4));
	}
	
	public void testBoardStateShip11() throws Exception {
		assertEquals(true, board.getBoardState()[1][1].hasShip());
	}
	public void testBoardStateHit11() throws Exception {
		assertEquals(true, board.getBoardState()[1][1].isHit());
	}
	public void testBoardStateShip44() throws Exception {
		assertEquals(false, board.getBoardState()[4][4].hasShip());
	}
	public void testBoardStateHit44() throws Exception {
		assertEquals(true, board.getBoardState()[4][4].isHit());
	}
	public void testBoardStateShip31() throws Exception {
		assertEquals(true, board.getBoardState()[3][1].hasShip());
	}
	public void testBoardStateHit31() throws Exception {
		assertEquals(false, board.getBoardState()[3][1].isHit());
	}
	public void testBoardStateShip55() throws Exception {
		assertEquals(false, board.getBoardState()[5][5].isHit());
	}
	public void testBoardStateHit55() throws Exception {
		assertEquals(false, board.getBoardState()[5][5].hasShip());
	}
	public void testBoardStateShip1414() throws Exception {
		assertEquals(true, board.getBoardState()[14][14].hasShip());
	}
	public void testBoardStateHit1414() throws Exception {
		assertEquals(false, board.getBoardState()[14][14].isHit());
	}

}
