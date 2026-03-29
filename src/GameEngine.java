import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
	public static void main(String[] args) {
		Board board = new Board();
		Shipyard shipyard = new Shipyard();
		List<Ship> fleet = new ArrayList<>();
		
		Ship carrier = new Carrier();
		Ship sub = new Submarine();
		fleet.add(carrier);
		fleet.add(sub);
		
		shipyard.placeShip(board, carrier, 2, 2, true);
		shipyard.placeShip(board, sub, 5, 7, false);
		
		Scanner scanner = new Scanner(System.in);
		Weapon standard = new StandardShot();
		Weapon nuke = new Nuke();
		Weapon radar = new Radar();
		
		System.out.println("--- WELCOME TO BATTLESHIP ---");
		
		while (true) {
			board.printBoard(true);
			
			System.out.println("\nSelect Weapon System:");
			System.out.println("1. Standard Artillery");
			System.out.println("2. Tactical Nuke");
			System.out.println("3. Sonar Sweep");
			System.out.print("Command: ");
			
			int choice = scanner.nextInt();
			System.out.print("Enter Target Column (0-9): ");
			int col = scanner.nextInt();
			System.out.print("Enter Target Row (0-9): ");
			int row = scanner.nextInt();
			
			System.out.println();
			
			switch (choice) {
			case 1:
				standard.fire(board, col, row);
				break;
			case 2:
				nuke.fire(board, col, row);
				break;
			case 3:
				radar.fire(board, col, row);
				break;
			default:
				System.out.println("Invalid weapon. You just shot yourself in the foot.");
			}
			
			boolean allSunk = true;
			for (Ship ship : fleet) {
				if (!ship.isSunk()) {
					allSunk = false;
					break;
				}
			}
			if (allSunk) {
				System.out.println("\nAll enemy vessels destroyed. The ocean is yours!")
				board.printBoard(false);
				break;
			}
		}
		scanner.close();
	}
}
