import java.util.ArrayList;
import java.util.Random;

public class Pion {
    public static Power4Grid grid;

    public Pion(Power4Grid grid) {
        Pion.grid = grid;
    }

    public static boolean addPion(int col, String player) {
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
        for (int row = Power4Grid.ROWS - 1; row >= 0; row--) {
            if (currentGrid.get(row).get(col) == "0") {
                currentGrid.get(row).set(col, player);
                grid.setGrid(currentGrid);
                break;
            }
        }
        return false;
    }

    public static void RandomPion(String player) {
        Random rand = new Random();
        int col = rand.nextInt(6 - 0) + 0;
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
        for (int row = Power4Grid.ROWS - 1; row >= 0; row--) {
            if (currentGrid.get(row).get(col) == "0") {
                currentGrid.get(row).set(col, player);
                grid.setGrid(currentGrid);
                break;
            }

        }
        col = rand.nextInt(6 - 0) + 0;
    }

}
