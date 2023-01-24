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
        for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
            if (currentGrid.get(row).get(bot) == "0") {
                currentGrid.get(row).set(bot, player);
                grid.setGrid(currentGrid);
                break;
            }

        }
        bot = rand.nextInt(6 - 0) + 0;
    }
}
