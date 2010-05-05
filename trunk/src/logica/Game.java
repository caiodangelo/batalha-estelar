package logica;

/**
 * Implements the Game class.
 * @author Vitor / Caio
 *
 */
public class Game {
	private GameState gameState;
	private Player player1;
	private Player player2;
	private int boardSize;
	private int shipCount;
	
	/**
	 * Constructs and Initializes a new game
	 * @param boardSize NxN size of each board
	 * @param shipCount Number of ships per player
	 */
	Game(int boardSize, int shipCount)
	{
		this.boardSize = boardSize;
		this.shipCount = shipCount;
		this.gameState = GameState.WaitingForPlayers;
	}
	
}
