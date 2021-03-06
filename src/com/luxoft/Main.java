package com.luxoft;

/**
 * @author mohamed
 *
 */
public class Main {

	public static void main(String[] args) {
/*		Board connect4 = new Board();
		connect4.printBoard();
		connect4.addColorCode(0, "R");
		connect4.addColorCode(0, "G");
		connect4.addColorCode(1, "R");
		connect4.addColorCode(2, "G");
		connect4.addColorCode(1, "G");
		connect4.printBoard();
		*/
		Game game = new Game("R","G");
		game.startGame();
	}
}
