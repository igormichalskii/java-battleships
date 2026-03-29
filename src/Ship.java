import java.util.ArrayList;
import java.util.List;

public class Ship {
	private String name;
	private int size;
	private List<Cell> hull;
	
	public Ship(String name, int size) {
		this.name = name;
		this.size = size;
		this.hull = new ArrayList<>();
	}
	
	public void occupyCell(Cell cell) {
		if (hull.size() < size) {
			this.hull.add(cell);
			cell.placeShip();
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isSunk() {
		if (hull.isEmpty()) return false;
		for (Cell part : hull) {
			if (!part.isHit()) return false;
		}
		return true;
	}
}

class Carrier extends Ship {
	public Carrier() { super("Aircraft Carrier", 5); }
}

class Battleship extends Ship {
	public Battleship() { super("Battleship", 4); }
}

class Submarine extends Ship {
	public Submarine() { super("Submarine", 3); }
}

class Destroyer extends Ship {
	public Destroyer() { super("Destroyer", 3); }
}

class PatrolBoat extends Ship {
	public PatrolBoat() { super("Patrol Boat", 2); } 
}