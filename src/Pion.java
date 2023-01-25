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
        if (Player.getCurrentPlayer() == "1"){
            for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
                if (currentGrid.get(row).get(col) == "  ") {
                    currentGrid.get(row).set(col, Menu.couleur1);
                    grid.setGrid(currentGrid);
                    break;
                }
            }
        } else if (Player.getCurrentPlayer() == "2"){
            for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
                if (currentGrid.get(row).get(col) == "  ") {
                    currentGrid.get(row).set(col, Menu.couleur2);
                    grid.setGrid(currentGrid);
                    break;
                }
            }
        } else {
            System.out.println("Erreur");
        }
        return false;

    }

    public static boolean addPionBot(int col, String player) {
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
        if (Player.getCurrentPlayer() == "1"){
            for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
                if (currentGrid.get(row).get(col) == "  ") {
                    currentGrid.get(row).set(col, Menu.couleur1);
                    grid.setGrid(currentGrid);
                    break;
                }
            }
        } else if (Player.getCurrentPlayer() == "AI"){
            for (int row = Power4Grid.ROWS-1; row >= 0; row--) {
                if (currentGrid.get(row).get(col) == "  ") {
                    currentGrid.get(row).set(col, Menu.couleur2);
                    grid.setGrid(currentGrid);
                    break;
                }
            }
        } else {
            System.out.println("Erreur");
        }
        return false;

    }

    public void RandomPion() {
        Random rand = new Random();
        int bot = rand.nextInt(6 - 0) + 0;
        addPion(bot, Menu.couleur2);
        bot = rand.nextInt(6 - 0) + 0;
    }

    
    public void RandomPion1(String player) {
        Random rand = new Random();
        int random = rand.nextInt(6 - 0) + 0;
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
        boolean jouer = false;
        // Vérifie les lignes
        for (int row = 0; row < Power4Grid.ROWS; row++) {
            for (int col = 0; col < Power4Grid.COLS - 3; col++) {
                if (currentGrid.get(row).get(col).equals(player)
                && currentGrid.get(row).get(col + 1).equals(player)
                && currentGrid.get(row).get(col + 2).equals(player)
                && currentGrid.get(row).get(col + 3).equals("  ")) {

                    System.out.println("ligne");
                    if (currentGrid.get(row).get(col).equals(player)
                            && currentGrid.get(row).get(col + 1).equals(player)
                            && currentGrid.get(row).get(col + 2).equals(player)) {

                                System.out.println("ligne2");
                                addPion(col+3, Menu.couleur2);
                                jouer = true;
                        break;
                    }
                }
            }
        }

          // Vérifie les colonnes
        for (int col = 0; col < Power4Grid.COLS; col++) {
            for (int row = 0; row < Power4Grid.ROWS - 3; row++) {
                System.out.println("test");
                if (currentGrid.get(row).get(col).equals(player) 
                    && currentGrid.get(row + 1).get(col).equals(player) 
                    && currentGrid.get(row + 2).get(col).equals(player)){
                        System.out.println("colonne");

                        addPion(row+3, Menu.couleur2);
                        jouer = true;

                        break;
                    } 

                }
        }

        // Vérifie les diagonales

        for (int row = 0; row < Power4Grid.ROWS-3; row++) {
            for (int col = 0; col < Power4Grid.COLS - 3; col++) {
                if (currentGrid.get(row).get(col) .equals(player)
                        && currentGrid.get(row + 1).get(col + 1).equals(player)
                        && currentGrid.get(row + 2).get(col + 2).equals(player)
                        && currentGrid.get(row + 2).get(col + 1).equals(player)) {
                            System.out.println("diago");
                            addPion(col+3, Menu.couleur2);
                            jouer = true;

                    break;
                }

                if (currentGrid.get(row).get(col + 3).equals(player)
                        && currentGrid.get(row + 1).get(col + 2).equals(player)
                        && currentGrid.get(row + 2).get(col + 1).equals(player)) {
                            System.out.println("diago2");
                            addPion(col+3, Menu.couleur2);
                            jouer = true;

                    break;
                }
            }
        }

        if (!jouer){
            random = rand.nextInt(6 - 0) + 0;;
            addPion(random, Menu.couleur2);
        }
        

    }
}
