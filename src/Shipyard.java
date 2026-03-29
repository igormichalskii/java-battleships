
public class Shipyard {
	public boolean placeShip(Board board, Ship ship, int startCol, int startRow, boolean isHorizontal) {
		int size = ship.getSize();
		
		if (!isValidPlacement(board, size, startCol, startRow, isHorizontal)) {
			System.out.println("Dockmaster: Invalid coordinates for " + ship.getName() + ". Try again.");
			return false;
		}
		
		for (int i = 0; i < size; i++) {
			int c = isHorizontal ? startCol + i : startCol;
			int r = isHorizontal ? startRow : startRow + i;
			
			Cell targetCell = board.getCell(c,  r);
			ship.occupyCell(targetCell);
		}
		
		System.out.println(ship.getName() + " successfully deployed.");
		return true;
	}
	
	private boolean isValidPlacement(Board board, int size, int col, int row, boolean isHorizontal) {
		if (isHorizontal && (col + size > board.SIZE)) return false;
		if (!isHorizontal && (row + size > board.SIZE))return false;
		
		for (int i = 0; i < size; i++) {
			int c = isHorizontal ? col + i : col;
			int r = isHorizontal ? row : row + i;
			
			Cell checkCell = board.getCell(c, r);
			if (checkCell == null || checkCell.hasShip()) {
				return false;
			}
		}
		return true;
	}
}
