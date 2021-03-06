package com.luxoft;

/**
 * @author mohamed
 *
 */
public class Board {

	private static final int ROWS = 6;
	private static final int COLUMNS = 7;

	Node[][] playBoard = new Node[ROWS][COLUMNS];

	public int getColumns() {
		return COLUMNS;
	}

	public int getRows() {
		return ROWS;
	}

	public boolean checkWinner(int col, String winningColor) {
		boolean winner = false;

		for (int row = 0; row < ROWS; row++) {
			if (playBoard[row][col] != null) {

				// vertical
				int streak = 3;
				for (int winRow = row + 1; winRow < ROWS; winRow++) {
					if (playBoard[winRow][col].getColorCode() == winningColor) {
						streak--;
						if (streak == 0) {
							winner = true;
						}
					} else {
						streak = 3;
					}
				}

				// horizontal
				streak = 4;
				for (int winCol = col - 3; winCol <= COLUMNS + 3; winCol++) {
					if (winCol < 0)
						continue;
					if (winCol >= COLUMNS)
						break;
					if (playBoard[row][winCol] != null && playBoard[row][winCol].getColorCode() == winningColor) {
						streak--;
						if (streak == 0) {
							winner = true;
						}
					} else {
						streak = 4;
					}
				}

				// diagonal left
				streak = 4;
				for (int winRow = row - 3, winCol = col - 3; winRow <= row + 3 && winCol <= col + 3; winRow++, winCol++) {
					if (winRow < 0 || winCol < 0)
						continue;
					if (winRow >= ROWS || winCol >= COLUMNS)
						break;

					if (playBoard[winRow][winCol] != null && playBoard[winRow][winCol].getColorCode() == winningColor) {
						streak--;
						if (streak == 0) {
							winner = true;
						}
					} else {
						streak = 4;
					}
				}
				
				// diagonal right
				streak = 4;
				for (int winRow = row - 3, winCol = col + 3; winRow <= row + 3 && winCol >= col - 3; winRow++, winCol--) {
					if (winRow < 0 || winCol >= COLUMNS)
						continue;
					if (winRow >= ROWS || winCol < 0)
						break;

					if (playBoard[winRow][winCol] != null && playBoard[winRow][winCol].getColorCode() == winningColor) {
						streak--;
						if (streak == 0) {
							winner = true;
						}
					} else {
						streak = 4;
					}
				}

				break;

			}
		}

		return winner;
	}

	public Board() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				playBoard[row][col] = null;
			}
		}
	}

	public void printBoard() {
		for (int col = 0; col < COLUMNS + 2; col++)
			System.out.print("");
		System.out.println();
		for (int row = 0; row < ROWS; row++) {
			System.out.print("|");
			for (int col = 0; col < COLUMNS; col++) {
				if (playBoard[row][col] == null) {
					System.out.print(" ");
				} else {
					System.out.print(playBoard[row][col].getColorCode());
				}
				System.out.print("|");
			}
			System.out.println();
		}
		for (int col = 0; col < COLUMNS + 2; col++)
			System.out.print("");
		System.out.println();
	}

	public boolean addColorCode(int colToAdd, String colorCode) {
		if (colToAdd >= 0 && colToAdd < COLUMNS) {
			if (playBoard[0][colToAdd] == null) {
				boolean addedNode = false;
				for (int row = ROWS - 1; row >= 0; row--) {
					if (playBoard[row][colToAdd] == null) {
						playBoard[row][colToAdd] = new Node();
						playBoard[row][colToAdd].setColorCode(colorCode);
						addedNode = true;
						break;
					}
				}
				return addedNode;
			} else {
				System.err.println("The column is full, please choose another");
				return false;
			}
		} else {
			System.err.println("You are trying to add which is not supported by connect4");
			return false;
		}
	}

}
