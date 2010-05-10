package logica;

import java.awt.Point;
import java.util.Vector;

import junit.framework.TestCase;

public class GameTest extends TestCase {
	private Game game;
	private Vector<Ship> shipListError;
	private Vector<Ship> shipList;
	
	protected void setUp() throws Exception {
		game = new Game(15);
		setFullGame();
		shipListError = new Vector<Ship>();
		shipListError.add(new Ship("teste1",1,new Point(1,1)));
		shipListError.add(new Ship("teste2",1,new Point(1,1)));
	}
	private void setFullGame() throws Exception {
		shipList = new Vector<Ship>();
		shipList.add(new Ship("xwing1", 1, new Point(0,0)));
		shipList.add(new Ship("xwing2", 1, new Point(0,2)));
		shipList.add(new Ship("xwing3", 1, new Point(0,4)));
		shipList.add(new Ship("xwing4", 1, new Point(0,6)));
		shipList.add(new Ship("xwing5", 1, new Point(0,8)));
		shipList.add(new Ship("falcon1", 2, new Point(2,0)));
		shipList.add(new Ship("falcon2", 2, new Point(2,3)));
		shipList.add(new Ship("falcon3", 2, new Point(2,6)));
		shipList.add(new Ship("millenium1", 3, new Point(5,0)));
		shipList.add(new Ship("millenium2", 3, new Point(5,4)));
		shipList.add(new Ship("millenium3", 3, new Point(5,8)));
		game.addPlayer("player1");
		game.initializePlayerBoard("player1", shipList);
		game.addPlayer("player2");
		game.initializePlayerBoard("player2", shipList);
	}
	
	public void testShipConflict() throws Exception {
		assertEquals(true, shipListError.get(0).conflictsWith(shipListError.get(1)));
	}
	public void testValidateShipListWithConflict() throws Exception {
		assertEquals(ValidationCode.ShipLocationError, game.validateShipList(shipListError));
	}
	
	public void testValidateShipList() throws Exception {
		assertEquals(ValidationCode.ValidationOK, game.validateShipList(shipList));
	}
	public void testStartGame() throws Exception {
		assertEquals(true, game.startGame());
	}
	public void testIsGameReady() throws Exception {
		game.startGame();
		assertEquals(GameState.InProgress, game.getGameState());
	}
	// fails if the random first turn is not player1 
//	public void testDoShot() throws Exception {
//		game.startGame();
//		assertEquals(ShotResult.ShipSunk, game.doShot("player1", new Point(1,1)));
//	}
	public void testGetBoardState() throws Exception {
		game.startGame();
		assertEquals(true, game.getPlayerBoard("player1")[0][0].hasShip());
	}
	public void testGetOpponentBoardState() throws Exception {
		game.startGame();
		assertEquals(false, game.getOpponentBoard("player1")[0][0].hasShip());
	}

}
