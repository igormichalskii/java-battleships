import java.util.List;
import java.util.Random;

public class Shipyard {
    public boolean placeShip(Board board, Ship ship, int row, int col, boolean isHorizontal) {
        int size = ship.getSize();
        
        if (isHorizontal && (col + size > board.SIZE)) return false;
        if (!isHorizontal && (row + size > board.SIZE)) return false;

        for (int i = 0; i < size; i++) {
            int r = isHorizontal ? row : row + i;
            int c = isHorizontal ? col + i : col;
            Cell checkCell = board.getCell(r, c);
            if (checkCell == null || checkCell.hasShip()) return false; 
        }

        for (int i = 0; i < size; i++) {
            int r = isHorizontal ? row : row + i;
            int c = isHorizontal ? col + i : col;
            ship.occupyCell(board.getCell(r, c)); 
        }
        return true;
    }
    
	public void deployFleetRandomly(Board board, List<Ship> fleet) {
		Random rand = new Random();
		for (Ship ship : fleet) {
			boolean placed = false;
			while (!placed) {
				int r = rand.nextInt(board.SIZE);
				int c = rand.nextInt(board.SIZE);
				boolean horiz = rand.nextBoolean();
				placed = placeShip(board, ship, r, c, horiz);
			}
		}
	}
}