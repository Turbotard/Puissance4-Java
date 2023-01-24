import java.util.ArrayList;
import java.util.Random;

public class IAniv1 {
    public static Power4Grid grid;
    public void Pion(Power4Grid grid) {
        this.grid = grid;
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
        }
    }
}
