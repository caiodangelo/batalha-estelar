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
		shipList.add(new Ship("xwing1", 1, new Point(1,1)));
		shipList.add(new Ship("xwing2", 1, new Point(1,3)));
		shipList.add(new Ship("xwing3", 1, new Point(1,5)));
		shipList.add(new Ship("xwing4", 1, new Point(1,7)));
		shipList.add(new Ship("xwing5", 1, new Point(1,9)));
		shipList.add(new Ship("falcon1", 2, new Point(3,1)));
		shipList.add(new Ship("falcon2", 2, new Point(3,4)));
		shipList.add(new Ship("falcon3", 2, new Point(3,7)));
		shipList.add(new Ship("millenium1", 3, new Point(6,1)));
		shipList.add(new Ship("millenium2", 3, new Point(6,5)));
		shipList.add(new Ship("millenium3", 3, new Point(6,9)));
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
		assertEquals(true, game.getPlayerBoard("player1")[1][1].hasShip());
	}
	public void testGetOpponentBoardState() throws Exception {
		game.startGame();
		assertEquals(false, game.getOpponentBoard("player1")[1][1].hasShip());
	}

}
