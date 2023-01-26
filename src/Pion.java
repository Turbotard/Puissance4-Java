import java.util.ArrayList;
import java.util.Random;

public class Pion {
    public static Power4Grid grid;
    private static String pion;

    public static String getPionIA() {
        return pion;
    }

    public static String setPionIA() {
        pion = "x";
        return pion;
    }

    public Pion(Power4Grid grid) {
        Pion.grid = grid;
    }

    public static boolean addPion(int col, String player) {
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
        if (Player.getCurrentPlayer() == "1") {
            for (int row = Power4Grid.ROWS - 1; row >= 0; row--) {
                if (currentGrid.get(row).get(col) == "  ") {
                    currentGrid.get(row).set(col, Menu.couleur1);
                    grid.setGrid(currentGrid);
                    break;
                }
            }
        } else if (Player.getCurrentPlayer() == "2") {
            for (int row = Power4Grid.ROWS - 1; row >= 0; row--) {
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

            // diago vers le bas
                    if (currentGrid.get(row).get(col +3).equals(player)
                    && currentGrid.get(row + 1).get(col +2).equals(player)
                    && currentGrid.get(row + 2).get(col +1).equals(player)
                    && currentGrid.get(row+3).get(col +0).equals("  ")) {
                        System.out.println("diago2");
                    addPion(col + 3, Menu.couleur2);
                    jouer = true;
                    break;

                }
            }
        }

        // Verifie les colonnes
        for (int col = 0; col < Power4Grid.COLS; col++) {
            for (int row = 5; row >= 0; row--) {
                if (currentGrid.get(row).get(col).equals(player)
                        && currentGrid.get(row - 1).get(col).equals(player)
                        && currentGrid.get(row - 2).get(col).equals(player)
                        && currentGrid.get(row - 3).get(col).equals("  ")) {
                    System.out.println("colonne");

                    addPion(col, Menu.couleur2);
                    jouer = true;

                    break;
                }

            }
        }

        for (int row = 0; row < Power4Grid.ROWS - 3; row++) {
            for (int col = 0; col < Power4Grid.COLS - 3; col++) {

                // diago vers le haut
                if (currentGrid.get(row).get(col).equals(player)
                        && currentGrid.get(row + 1).get(col + 1).equals(player)
                        && currentGrid.get(row + 2).get(col + 2).equals(player)
                        && currentGrid.get(row + 3).get(col + 3).equals("  ")) {
                    System.out.println("diago1");
                    addPion(col + 3, Menu.couleur2);
                    return;
                }

                // diago vers le bas
                if (currentGrid.get(row + 3).get(col).equals(player)
                        && currentGrid.get(row + 2).get(col + 1).equals(player)
                        && currentGrid.get(row + 1).get(col + 2).equals(player)
                        && currentGrid.get(row).get(col + 3).equals("  ")) {
                    System.out.println("diago2");
                    addPion(col + 3, Menu.couleur2);
                    return;
                }
            }
        }
        if (jouer == false) {
            random = rand.nextInt(Power4Grid.COLS);
            System.out.println("pif");
            addPion(random, Menu.couleur2);
            jouer = false;
        }
    }
}