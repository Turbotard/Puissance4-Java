import java.util.ArrayList;
import java.util.Random;

public class Pion {
    public static Power4Grid grid;
    private static String pion;

    public static String getPionIA(){
        return pion;
    }
    public static String setPionIA(){
        pion = "x" ;
        return pion;
    }

    public Pion(Power4Grid grid) {
        Pion.grid = grid;
    }

    public static boolean addPion(int col, String player) {
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
            for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
                if (currentGrid.get(row).get(col) == " ") {
                    currentGrid.get(row).set(col, Player.getPion());
                    grid.setGrid(currentGrid);
                    break;
                }
            }
        
        return false;

    }

    public static void RandomPion(String player) {
        Random rand = new Random();
        int bot = rand.nextInt(7 - 1 + 1) + 1;
        addPion(bot, player);
        bot = rand.nextInt(6 - 0) + 0;
    }

    
    public void RandomPion1(String player, String ia) {
        Random rand = new Random();
        int random = rand.nextInt(6 - 0) + 0;
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();

        // Vérifie les lignes
        for (int row = 0; row < Power4Grid.ROWS; row++) {
            for (int col = 0; col < Power4Grid.COLS - 3; col++) {
                if (currentGrid.get(row).get(col)== player
                        && currentGrid.get(row).get(col + 1)== player
                        && currentGrid.get(row).get(col + 2)== player) {
                    Pion.addPion(col + 3, ia);
                    break;
                }
            }
        }

          // Vérifie les colonnes
        for (int col = 0; col < Power4Grid.COLS; col++) {
            for (int row = 0; row < Power4Grid.ROWS - 3; row++) {
                if (currentGrid.get(row).get(col)== player 
                    && currentGrid.get(row + 1).get(col)== player 
                    && currentGrid.get(row + 2).get(col)== player){
                        Pion.addPion(col+3, ia);
                        break;
                    } 

                }
        }

        // Vérifie les diagonales

        for (int row = 0; row < Power4Grid.ROWS-3; row++) {
            for (int col = 0; col < Power4Grid.COLS - 3; col++) {
                if (currentGrid.get(row).get(col) == player
                        && currentGrid.get(row + 1).get(col + 1)== player
                        && currentGrid.get(row + 2).get(col + 2)== player
                        && currentGrid.get(row + 2).get(col + 1)== player) {
                    Pion.addPion(col + 3, ia);
                    break;
                }

                if (currentGrid.get(row).get(col + 3)== player
                        && currentGrid.get(row + 1).get(col + 2)== player
                        && currentGrid.get(row + 2).get(col + 1)== player) {
                    Pion.addPion(col + 3, ia);
                    break;
                }
            }
        }

        addPion(random, Player.pionAI());
        random = rand.nextInt(6 - 0) + 0;

    }
}
