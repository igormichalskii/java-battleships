
public class Nuke implements Weapon {
	@Override
	public void fire(Board board, int col, int row) {
		System.out.println("WARNING: Tactical Nuke detonating at " + col + "," + row + "...");
		
		board.fireAt(col,row);
		board.fireAt(col, row - 1);
		board.fireAt(col + 1, row);
		board.fireAt(col, row + 1);
		board.fireAt(col - 1, row);
		
		System.out.println("Fallout has settled. Check the board.");
	}
}