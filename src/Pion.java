import java.util.ArrayList;

public class Pion {
    public static Power4Grid grid;
    public Pion(Power4Grid grid) {
        Pion.grid = grid;
    }

    public static void addPion(int col, String player) {
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
        for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
            if (currentGrid.get(row).get(col) == "0") {
                currentGrid.get(row).set(col, player);
                grid.setGrid(currentGrid);
                break;
            }
        }
    }
}
