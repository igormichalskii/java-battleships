class StandardShot implements Weapon {
	@Override
    public void fire(Board board, int row, int col) {
        System.out.println("Firing standard artillery at " + row + "," + col + "...");
        if (board.fireAt(row, col)) System.out.println("Direct hit!");
        else System.out.println("Splash. You hit water.");
    }
}