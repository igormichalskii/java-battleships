import java.util.Random;
import java.util.Stack;

public class EnemyAI {
    private Stack<int[]> targets = new Stack<>();
    private Random rand = new Random();

    public void takeTurn(Board playerBoard) {
        System.out.println("\nEnemy AI is firing...");
        boolean validShot = false;

        while (!validShot) {
            int row, col;
            if (!targets.isEmpty()) {
                int[] guess = targets.pop();
                row = guess[0]; col = guess[1];
            } else {
                row = rand.nextInt(playerBoard.SIZE);
                col = rand.nextInt(playerBoard.SIZE);
            }

            Cell targetCell = playerBoard.getCell(row, col);
            if (targetCell != null && !targetCell.isHit()) {
                validShot = true;
                if (playerBoard.fireAt(row, col)) {
                    System.out.println("AI hit your fleet at " + row + "," + col + "!");
                    pushIfValid(playerBoard, row - 1, col); 
                    pushIfValid(playerBoard, row + 1, col); 
                    pushIfValid(playerBoard, row, col - 1); 
                    pushIfValid(playerBoard, row, col + 1); 
                } else {
                    System.out.println("AI missed.");
                }
            }
        }
    }

    private void pushIfValid(Board board, int row, int col) {
        Cell cell = board.getCell(row, col);
        if (cell != null && !cell.isHit()) targets.push(new int[]{row, col});
    }
}