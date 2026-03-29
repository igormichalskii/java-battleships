class Radar implements Weapon {
	@Override
    public void fire(Board board, int row, int col) {
        System.out.println("Sonar sweeping 3x3 sector around " + row + "," + col + "...");
        int pings = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                Cell cell = board.getCell(r, c);
                if (cell != null && cell.hasShip() && !cell.isHit()) pings++;
            }
        }
        System.out.println("Detected " + pings + " intact hull(s) in that sector.");
    }
}