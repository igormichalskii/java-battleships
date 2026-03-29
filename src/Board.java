
public class Board {
	private Cell[][] grid;
	public final int SIZE = 10;
	
	public Board() {
		grid = new Cell[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = new Cell();
			}
		}
	}
	
	public boolean fireAt(int col, int row) {
		if (col < 0 || col >= SIZE || row < 0 || row >= SIZE) {
			System.out.println("Man, you missed... Try again.");
			return false;
		}
		return grid[col][row].shoot();
	}
	
	public void printBoard(boolean hideShips) {
		System.out.print("  0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i < SIZE; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < SIZE; j++) {
				System.out.print(grid[i][j].getSymbol(hideShips) + " ");
			}
			System.out.println();
		}
	}
	
	public Cell getCell(int col, int row) {
		if (col >= 0 && col < SIZE && row >= 0 && row < SIZE) {
			return grid[col][row];
		}
		return null;
	}
}