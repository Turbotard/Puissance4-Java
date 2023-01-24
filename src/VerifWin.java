import java.util.ArrayList;

public class VerifWin {
    private static Power4Grid grid;

    public VerifWin(Power4Grid grid) {
        this.grid = grid;
    }

    public static boolean checkWin(String player) {
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();

        // Vérifie les lignes
        for (int row = 0; row < Power4Grid.ROWS; row++) {
            for (int col = 0; col < Power4Grid.COLS - 3; col++) {
                if (currentGrid.get(row).get(col).equals(player) 
                        && currentGrid.get(row).get(col + 1).equals(player)
                        && currentGrid.get(row).get(col + 2).equals(player)
                        && currentGrid.get(row).get(col + 3).equals(player)) {
                            System.out.println("win");
                    return true;
                }
            }
        }

        // Vérifie les colonnes
        for (int col = 0; col < Power4Grid.COLS; col++) {
            for (int row = 0; row < Power4Grid.ROWS - 3; row++) {
                if (currentGrid.get(row).get(col).equals(player)
                        && currentGrid.get(row + 1).get(col).equals(player)
                        && currentGrid.get(row + 2).get(col).equals(player)
                        && currentGrid.get(row + 3).get(col).equals(player)) {
                            System.out.println("win");
                    return true;
                }
            }
        }

        // Vérifie les diagonales
        for (int row = 0; row < Power4Grid.ROWS - 3; row++) {
            for (int col = 0; col < Power4Grid.COLS - 3; col++) {
                if (currentGrid.get(row).get(col).equals(player)
                        && currentGrid.get(row + 1).get(col + 1).equals(player)
                        && currentGrid.get(row + 2).get(col + 2).equals(player)
                        && currentGrid.get(row + 3).get(col + 3).equals(player)) {
                            System.out.println("win");
                    return true;
                }
                if (currentGrid.get(row).get(col + 3).equals(player)
                        && currentGrid.get(row + 1).get(col + 2).equals(player)
                        && currentGrid.get(row + 2).get(col + 1).equals(player)
                        && currentGrid.get(row + 3).get(col).equals(player)) {
                            System.out.println("win");
                    return true;
                }
            }
        }
        System.out.println("no win");
        return false;
    }
}
