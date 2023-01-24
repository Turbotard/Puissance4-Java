import java.util.ArrayList;
import java.util.Random;

public class IAniv1 {
    public static Power4Grid grid;

    public void Pion(Power4Grid grid) {
        Pion.grid = grid;
    }

    public static void RandomPion(String player) {
        Random rand = new Random();
        int bot = rand.nextInt(7 - 1 + 1) + 1;
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
        int randomIndex = (int) (Math.random() * Power4Grid.COLS);
        int col = randomIndex;
        for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
            if (currentGrid.get(row).get(col) == "0") {
                currentGrid.get(row).set(col, bot);
                grid.setGrid(currentGrid);
                break;
            }

        }
        col = rand.nextInt(6 - 0) + 0;
    }
}
