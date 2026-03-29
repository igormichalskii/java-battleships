
public class Cell {
	private boolean hasShip;
	private boolean isHit;
	
	public Cell() {
		this.hasShip = false;
		this.isHit = false;
	}
	
	public void placeShip() {
		this.hasShip = true;
	}
	
	public boolean hasShip() {
		return this.hasShip;
	}
	
	public boolean isHit() {
		return this.isHit;
	}
	
	public boolean shoot() {
		if (isHit) {
			return false;
		}
		isHit = true;
		return hasShip;
	}
	
	public char getSymbol(boolean hideShips) {
		if (isHit) {
			return hasShip ? 'X' : 'O';
		} else {
			return (hasShip && !hideShips) ? 'S' : '~';
		}
	}
}
