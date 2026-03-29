
public class Radar implements Weapon {
	@Override
	public void fire(Board board, int col, int row) {
		System.out.println("Ping... Sonar sweeping 3x3 sector aroub " + col + "," + row + "...");
		int pings = 0;
		
		for (int c = col - 1; c <= col + 1; c++) {
			for (int r = row - 1; r <= row + 1; r++) {
				Cell cell = board.getCell(c, r);
				
				if (cell != null && cell.hasShip() && !cell.isHit()) {
					pings++;
				}
			}
		}
		System.out.println("Signal detected " + pings + " intact hull(s) in that sector.");
	}
}