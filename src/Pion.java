import java.util.ArrayList;
import java.util.Random;

public class Pion {
    public static Power4Grid grid;
    public Pion(Power4Grid grid) {
        Pion.grid = grid;
    }

    public static void addPion(int col, int player) {
        ArrayList<ArrayList<Integer>> currentGrid = grid.getGrid();
        for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
            if (currentGrid.get(row).get(col) == 0) {
                currentGrid.get(row).set(col, player);
                grid.setGrid(currentGrid);
                break;
            }
        }
    }
    public static void RandomPion(int player) {
        Random rand = new Random();
        int bot = rand.nextInt(6 - 0 + 1) + 0;
        ArrayList<ArrayList<Integer>> currentGrid = grid.getGrid();
        int randomIndex = (int) (Math.random() * Power4Grid.COLS);
        int col = randomIndex;
        for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
            if (currentGrid.get(row).get(col) == 0) {
                currentGrid.get(row).set(bot, player);
                grid.setGrid(currentGrid);
                break;
            }
            bot = rand.nextInt(6 - 0 + 1) + 0;
        }
    }
}
