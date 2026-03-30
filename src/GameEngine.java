import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shipyard shipyard = new Shipyard();
        
        int score = 0;
        int nukeAmmo = 1;
        int radarAmmo = 2;

        // Setup Enemy
        Board enemyBoard = new Board();
        List<Ship> enemyFleet = new ArrayList<>();
        enemyFleet.add(new Carrier());
        enemyFleet.add(new Submarine());
        enemyFleet.add(new Battleship());
        shipyard.deployFleetRandomly(enemyBoard, enemyFleet);

        // Setup Player
        Board playerBoard = new Board();
        List<Ship> playerFleet = new ArrayList<>();
        
        playerFleet.add(new Destroyer());
        playerFleet.add(new Carrier());
        playerFleet.add(new Submarine());
        
        System.out.println("\n=== DEPLOY YOUR FLEET ===");
        
        for (Ship ship : playerFleet) {
        	boolean deployed = false;
        	while (!deployed) {
        		System.out.println("\n--- Current Grid ---");
        		playerBoard.printBoard(false);
        		
        		System.out.println("\nDeploying: " + ship.getName() + "(Length: " + ship.getSize() + ")");
        		System.out.println("Enter Start Row (0-9): ");
        		int r = scanner.nextInt();
        		System.out.print("Enter Start Col (0-9): ");
        		int c = scanner.nextInt();
        		System.out.print("Horizontal alignment? (true/false): ");
        		boolean horiz = scanner.nextBoolean();
        		
        		deployed = shipyard.placeShip(playerBoard, ship, r, c, horiz);
        		
        		if (!deployed) { System.out.println("Invalid coordinates. Try again."); }
        		}
        	}
        playerBoard.printBoard(false);
        System.out.println("\nAll vessels secured. Commencing war games.");

        EnemyAI skynet = new EnemyAI();
        Weapon standard = new StandardShot();
        Weapon nuke = new Nuke();
        Weapon radar = new Radar();

        System.out.println("--- WELCOME TO BATTLESHIP: STEROID EDITION ---");

        while (true) {
            System.out.println("\n=== ENEMY TERRITORY ===");
            enemyBoard.printBoard(true);
            System.out.println("SCORE: " + score + " | NUKES: " + nukeAmmo + " | RADARS: " + radarAmmo);

            System.out.println("\nSelect Weapon System (1. Standard | 2. Nuke | 3. Radar):");
            System.out.print("Command: ");
            int choice = scanner.nextInt();

            System.out.print("Enter Target Row (0-9): ");
            int row = scanner.nextInt();
            System.out.print("Enter Target Col (0-9): ");
            int col = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1: 
                	standard.fire(enemyBoard, row, col); 
                	score += enemyBoard.getCell(row, col) != null & enemyBoard.getCell(row, col).hasShip() ? 50 : 0;
                	break;
                case 2: 
                	if (nukeAmmo > 0) {
                		nuke.fire(enemyBoard, row, col);
                		nukeAmmo--;
                		score -= 10;
                	} else {
                		System.out.println("Click. Out of nukes. Firing standard artillery instead.");
                		standard.fire(enemyBoard, row, col);
                		score += enemyBoard.getCell(row, col) != null && enemyBoard.getCell(row, col).hasShip() ? 50 : 0;
                	}
                	break;
                case 3:
                	if (radarAmmo > 0) {
                		radar.fire(enemyBoard, row, col);
                		radarAmmo--;
                	} else {
                		System.out.println("Radar offline. Guessing blindly.");
                	}
                	break;
                default: System.out.println("Invalid command. Wasted turn.");
            }

            // Check if player won before AI retaliates
            boolean enemyDead = true;
            for (Ship s : enemyFleet) { if (!s.isSunk()) enemyDead = false; }
            if (enemyDead) {
                System.out.println("\nAll enemy vessels destroyed. The ocean is yours.");
                break;
            }

            // AI Turn
            skynet.takeTurn(playerBoard);
            System.out.println("\n=== YOUR FLEET ===");
            playerBoard.printBoard(false);

            // Check if AI won
            boolean playerDead = true;
            for (Ship s : playerFleet) { if (!s.isSunk()) playerDead = false; }
            if (playerDead) {
                System.out.println("\nYour fleet is at the bottom of the ocean. Humanity falls.");
                break;
            }
        }
        scanner.close();
    }
}