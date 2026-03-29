class Nuke implements Weapon {
	@Override
    public void fire(Board board, int row, int col) {
        System.out.println("Tactical Nuke detonating at " + row + "," + col + "...");
        board.fireAt(row, col);
        board.fireAt(row - 1, col);
        board.fireAt(row + 1, col);
        board.fireAt(row, col - 1);
        board.fireAt(row, col + 1);
    }
}