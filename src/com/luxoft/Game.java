package com.luxoft;

import java.util.Random;
import java.util.Scanner;

/**
 * @author mohamed
 *
 */
public class Game {
	private Board board;
	private String colorCode1;
	private String colorCode2;
	private boolean isPlaying;

	public Game(String colorCode1, String colorCode2) {
		board = new Board();
		this.colorCode1 = colorCode1;
		this.colorCode2 = colorCode2;

		isPlaying = true;//(new Random()).nextBoolean();
	}

	public boolean checkWinner(int column) {
		String winningColor;

		if (isPlaying) {
			winningColor = colorCode1;
		} else {
			winningColor = colorCode2;
		}
		return board.checkWinner(column, winningColor);
	}

	public void startGame() {

		boolean executing = true;
		while (executing) {
			board.printBoard();
			String colorCode;
			if (isPlaying) {
				colorCode = colorCode1;
				System.out.println("Player 1 [RED] - choose column (1-7): ");
			} else {
				colorCode = colorCode2;
				System.out.println("Player 2 [GREEN] - choose column (1-7): ");
			}

			Scanner input = new Scanner(System.in);
			int column = input.nextInt() - 1;
			boolean success = board.addColorCode(column, colorCode);
			if (success) {
				if (checkWinner(column)) {
					board.printBoard();
					executing = false;
					if (isPlaying) {
						System.out.println("Player 1 [RED] wins!");
					} else {
						System.out.println("Player 2 [GREEN] wins!");
					}
				}
				isPlaying = !isPlaying;
			}
		}

	}
}
