
public class StandardShot implements Weapon {
	@Override
	public void fire(Board board, int col, int row) {
		System.out.println("Firing standard artilery at " + col + "," + row + "...");
		boolean hit = board.fireAt(col, row);
		
		if (hit) {
			System.out.println("Direct hit! Enemy armor penetrated.");
		} else {
			System.out.println("Splash. You hit water, genius.");
		}
	}
}