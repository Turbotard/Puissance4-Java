import java.util.ArrayList;

public class Power4Grid {

    private ArrayList<ArrayList<Integer>> grid;
    final static int ROWS = 6;
    final static int COLS = 7;

    public Power4Grid() {
        grid = new ArrayList<ArrayList<Integer>>();
        for (int row = 0; row < ROWS; row++) {
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            for (int col = 0; col < COLS; col++) {
                newRow.add(0);
            }
            grid.add(newRow);
        }
    }

    public ArrayList<ArrayList<Integer>> getGrid() {
        return grid;
    }

    public void setGrid(ArrayList<ArrayList<Integer>> grid) {
        this.grid = grid;
    }
    
    public void displayGrid() {
        for (int lol = 1; lol < COLS+1;lol++){
            System.out.print("" + lol + " " );
        }
        System.out.println();
        for (int loop = 0; loop < COLS * 2 - 1; loop++)
            System.out.print('-');
        System.out.println();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(grid.get(row).get(col) + " ");
            }
            System.out.println();
        }
        for (int loop = 0; loop < COLS * 2 - 1; loop++)
            System.out.print('-');
        System.out.println();
    }
}
