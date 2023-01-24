import java.util.ArrayList;
import java.util.Random;

import model.ConsoleColors;

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
        if (Player.currentPlayer == "1"){
            for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
                if (currentGrid.get(row).get(col) == "0") {
                    currentGrid.get(row).set(col, Player.getPionPlayer1());
                    grid.setGrid(currentGrid);
                    break;
                }
            }
        }else{
            for (int row = Power4Grid.ROWS - 1; row >= 0; row--) {
                if (currentGrid.get(row).get(col) == "0") {
                    currentGrid.get(row).set(col, Player.getPionPlayer2());
                    grid.setGrid(currentGrid);
                    break;
                }
            }
        }
        return false;

    }

    public static void RandomPion(String player) {
        Random rand = new Random();
        int bot = rand.nextInt(7 - 1 + 1) + 1;
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
        for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
            if (currentGrid.get(row).get(bot) == "0") {
                currentGrid.get(row).set(bot, Player.getPionPlayer1());
                grid.setGrid(currentGrid);
                break;
            }

        }
        bot = rand.nextInt(6 - 0) + 0;
    }

    
    public static void RandomPion1(String player) {
        Random rand = new Random();
        int random = rand.nextInt(6 - 0) + 0;
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();

        // Vérifie les lignes
        for (int row = 0; row < Power4Grid.ROWS; row++) {
            for (int col = 0; col < Power4Grid.COLS - 3; col++) {
                if (currentGrid.get(row).get(col) == player
                        && currentGrid.get(row).get(col + 1) == player
                        && currentGrid.get(row).get(col + 2) == player) {
                    Pion.addPion(col + 3, player);
                }
            }
        }

          // Vérifie les colonnes
          for (int col = 0; col < Power4Grid.COLS; col++) {
            for (int row = 0; row < Power4Grid.ROWS - 3; row++) {
                if (currentGrid.get(row).get(col) == player 
                    && currentGrid.get(row + 1).get(col) == player 
                    && currentGrid.get(row + 2).get(col) == player){
                        Pion.addPion(col+3, player);
                    } 

                }
            }

        // Vérifie les diagonales

        for (int row = 0; row < Power4Grid.ROWS-3; row++) {
            for (int col = 0; col < Power4Grid.COLS - 3; col++) {
                if (currentGrid.get(row).get(col) == player
                        && currentGrid.get(row + 1).get(col + 1) == player
                        && currentGrid.get(row + 2).get(col + 2) == player
                        && currentGrid.get(row + 2).get(col + 1) == player) {
                    Pion.addPion(col + 3, player);
                }

                if (currentGrid.get(row).get(col + 3) == player
                        && currentGrid.get(row + 1).get(col + 2) == player
                        && currentGrid.get(row + 2).get(col + 1) == player) {
                    Pion.addPion(col + 3, player);
                }
            }
        }

        for (int row = Power4Grid.ROWS - 1; row >= 0; row--) {
            if (currentGrid.get(row).get(random) == "0") {
                currentGrid.get(row).set(random,Player.getPionPlayer2());
                grid.setGrid(currentGrid);
                break;
            }

        }
        random = rand.nextInt(6 - 0) + 0;

    }
}
