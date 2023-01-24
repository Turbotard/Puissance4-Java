import java.util.ArrayList;

public class IAniv1 {
    public static Power4Grid grid = new Power4Grid();

    public IAniv1() { }

    public static void RandomPion(int player) {
        ArrayList<ArrayList<Integer>> currentGrid = grid.getGrid();
        int randomIndex = (int) (Math.random() * Power4Grid.COLS);
        int col = randomIndex;
        for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
            if (currentGrid.get(row).get(col) == 0) {
                currentGrid.get(row).set(col, player);
                grid.setGrid(currentGrid);
                break;
            }
        }
    }
    public static void main(String[] args) {
        IAniv1 ia = new IAniv1();
        ia.RandomPion(1);
        grid.displayGrid();
    }
}
