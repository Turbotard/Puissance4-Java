import java.util.ArrayList;
import java.util.Random;

public class Pion {
    public static Power4Grid grid;
    private static String pion;

    /**
     * auteur Benjamin
     * return le pion de l'IA
     * @return pion
     */
    public static String getPionIA() {
        return pion;
    }

    /**
     * auteur Benjamin
     * permet de set un pion pour l'ia
     * @return pion
     */
    public static String setPionIA() {
        pion = "x";
        return pion;
    }

    /**
     * auteur Benjamin
     * @param grid
     * met le pion dans la grille
     */
    public Pion(Power4Grid grid) {
        Pion.grid = grid;
    }

    /**
     * auteur Benjamin
     * @param col
     * @param player
     * place un pion sur une grille par rapport à une colonne donnée en prenant la couleure du joueur
     * @return
     */
    public boolean addPion(int col, String player) {
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

    }
    /*-----------------------------------------------------------------------------------------------------------------------
    
                    IA NIV 1
    
    -----------------------------------------------------------------------------------------------------------------------*/


    /**
     * auteur Samba
     * IA de niveau 1 qui place un Pion aléatoirement 
     */
    public void RandomPion() {
        Random rand = new Random();
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
        int bot = rand.nextInt(6 - 0) + 0;
        Boolean choixBot = true;
        while (choixBot) {
            System.out.println(bot);
            if (currentGrid.get(0).get(bot) != "  ") {
                bot = rand.nextInt(6 - 0) + 0;
            } else {
                choixBot = false;
            }
        }
        addPion(bot, Menu.couleur2);
        bot = rand.nextInt(6 - 0) + 0;
    }
    /*-----------------------------------------------------------------------------------------------------------------------
    
                    IA NIV 2
    
    -----------------------------------------------------------------------------------------------------------------------*/


    /**
     * auteur Samba
     * comme IA niveau 1 mais regarde si elle peut nous contrer en prenant en paramètre la couleure du joueur en face de lui
     * @param player
     */
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
                    addPion(col + 3, Menu.couleur2);
                    jouer = true;
                    break;

                }
            }
        }
        // Verifie les colonnes
        for (int col = 0; col < Power4Grid.COLS; col++) {
            for (int row = 5; row >= 3; row--) {
                if (currentGrid.get(row).get(col).equals(player)
                        && currentGrid.get(row - 1).get(col).equals(player)
                        && currentGrid.get(row - 2).get(col).equals(player)
                        && currentGrid.get(row - 3).get(col).equals("  ")) {
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
                    addPion(col + 3, Menu.couleur2);

                }

                // diago vers le bas
                if (currentGrid.get(row).get(col + 3).equals(player)
                        && currentGrid.get(row + 1).get(col + 2).equals(player)
                        && currentGrid.get(row + 2).get(col + 1).equals(player)
                        && currentGrid.get(row + 3).get(col + 0).equals("  ")) {
                    addPion(col + 3, Menu.couleur2);

                }

                // anti diago vers le haut
                if (row + 3 < currentGrid.size() && col - 3 >= 0) {
                    if (currentGrid.get(row).get(col).equals(player)
                            && currentGrid.get(row + 1).get(col - 1).equals(player)
                            && currentGrid.get(row + 2).get(col - 2).equals(player)
                            && currentGrid.get(row + 3).get(col - 3).equals("  ")) {
                        addPion(col - 3, Menu.couleur2);

                    }
                }

                // anti-diago vers le bas
                if (row + 3 < currentGrid.size() && col - 3 >= 0) {
                    if (currentGrid.get(row).get(col - 3).equals(player)
                            && currentGrid.get(row + 1).get(col - 2).equals(player)
                            && currentGrid.get(row + 2).get(col - 1).equals(player)
                            && currentGrid.get(row + 3).get(col - 0).equals("  ")) {
                        addPion(col - 3, Menu.couleur2);

                    }
                }

            }
        }
        if (jouer == false) {
            random = rand.nextInt(Power4Grid.COLS);
            Boolean choixBot = true;
            while (choixBot) {
                System.out.println(random);
                if (currentGrid.get(0).get(random) != "  ") {
                    random = rand.nextInt(6 - 0) + 0;
                } else {
                    choixBot = false;
                }
            }
            addPion(random, Menu.couleur2);
            jouer = false;
        }


    }
    /*-----------------------------------------------------------------------------------------------------------------------
    
                    IA NIV 3
    
    -----------------------------------------------------------------------------------------------------------------------*/

    /**
     * auteur Samba
     * @param player
     * Comme RandomPion1 mais rajoute en plus le fait qu'elle regardera où il ne faut PAS poser de pion pour nous laisser gagner
     *
     */
    public void RandomPion2(String player) {
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
                    addPion(col + 3, Menu.couleur2);
                    jouer = true;
                    break;

                }

                if (currentGrid.get(row).get(col).equals(player)
                        && currentGrid.get(row).get(col + 1).equals(player)
                        && currentGrid.get(row).get(col + 2).equals("  ")
                        && currentGrid.get(row).get(col + 3).equals(player)) {
                    System.out.println("le contre ligne est ok");
                    addPion(col + 2, Menu.couleur2);
                }
            }

        }

        // Verifie les colonnes
        for (int col = 0; col < Power4Grid.COLS; col++) {
            for (int row = 5; row >= 3; row--) {
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

                }

                if (currentGrid.get(row).get(col).equals(player)
                        && currentGrid.get(row + 1).get(col + 1).equals(player)
                        && currentGrid.get(row).get(col + 2).equals("  ")
                        && currentGrid.get(row + 3).get(col + 3).equals(player)) {
                    System.out.println("le contre diago est ok");
                    addPion(col + 2, Menu.couleur2);
                }

                // diago vers le bas
                if (currentGrid.get(row).get(col + 3).equals(player)
                        && currentGrid.get(row + 1).get(col + 2).equals(player)
                        && currentGrid.get(row + 2).get(col + 1).equals(player)
                        && currentGrid.get(row + 3).get(col + 0).equals("  ")) {
                    System.out.println("diago2");
                    addPion(col + 3, Menu.couleur2);

                }

                if (currentGrid.get(row).get(col + 3).equals(player)
                        && currentGrid.get(row + 1).get(col + 2).equals(player)
                        && currentGrid.get(row + 2).get(col + 1).equals("  ")
                        && currentGrid.get(row + 3).get(col + 3).equals(player)) {
                    System.out.println("le contre diago bas est ok");
                    addPion(col + 1, Menu.couleur2);
                }

                // anti diago vers le haut
                if (row + 3 < currentGrid.size() && col - 3 >= 0) {
                    if (currentGrid.get(row).get(col).equals(player)
                            && currentGrid.get(row + 1).get(col - 1).equals(player)
                            && currentGrid.get(row + 2).get(col - 2).equals(player)
                            && currentGrid.get(row + 3).get(col - 3).equals("  ")) {
                        System.out.println("anti-diagohaut");
                        addPion(col - 3, Menu.couleur2);

                    }

                    if (currentGrid.get(row).get(col).equals(player)
                            && currentGrid.get(row + 1).get(col + 1).equals(player)
                            && currentGrid.get(row + 2).get(col + 2).equals("  ")
                            && currentGrid.get(row + 3).get(col + 3).equals(player)) {
                        System.out.println("le contre diago-haut est ok");
                        addPion(col + 2, Menu.couleur2);
                    }

                }

                // anti-diago vers le bas
                if (row + 3 < currentGrid.size() && col - 3 >= 0) {
                    if (currentGrid.get(row).get(col - 3).equals(player)
                            && currentGrid.get(row + 1).get(col - 2).equals(player)
                            && currentGrid.get(row + 2).get(col - 1).equals(player)
                            && currentGrid.get(row + 3).get(col).equals("  ")) {
                        System.out.println("anti-diago-bas");
                        addPion(col - 3, Menu.couleur2);

                    }

                    if (currentGrid.get(row).get(col - 3).equals(player)
                            && currentGrid.get(row + 1).get(col - 2).equals(player)
                            && currentGrid.get(row).get(col - 1).equals("  ")
                            && currentGrid.get(row + 3).get(col).equals(player)) {
                        System.out.println("le contre anti diago est ok");
                        addPion(col + 2, Menu.couleur2);
                    }

                }

            }
        }
        if (jouer == false) {
            random = rand.nextInt(Power4Grid.COLS);
            Boolean choixBot = true;
            while (choixBot) {
                System.out.println(random);
                if (currentGrid.get(0).get(random) != "  ") {
                    random = rand.nextInt(Power4Grid.COLS - 1);
                } else {
                    choixBot = false;
                }
            }
            addPion(random, Menu.couleur2);
            jouer = false;
        }

    }

    /*-----------------------------------------------------------------------------------------------------------------------
    
                    IA GOD MODE
    
    -----------------------------------------------------------------------------------------------------------------------*/

    /**
     * auteur Benjamin et Samba
     * @param player
     * Meme code que RandomPion mais cette fois ci elle prend en argument les pions du joueurs en face,
     * pour pouvoir elle meme chercher à faire des 
     * Puiassances 4
     */
    public void IAgodmode(String player) {
        ArrayList<ArrayList<String>> currentGrid = grid.getGrid();

        // Vérifie les lignes
        for (int row = 0; row < Power4Grid.ROWS; row++) {
            for (int col = 0; col < Power4Grid.COLS - 3; col++) {
                if (currentGrid.get(row).get(col).equals(player)
                        && currentGrid.get(row).get(col + 1).equals(player)
                        && currentGrid.get(row).get(col + 2).equals(player)
                        && currentGrid.get(row).get(col + 3).equals("  ")) {
                    System.out.println("ligne");
                    addPion(col + 3, Menu.couleur2);
                    break;

                }

                if (currentGrid.get(row).get(col).equals(player)
                        && currentGrid.get(row).get(col + 1).equals(player)
                        && currentGrid.get(row).get(col + 2).equals("  ")
                        && currentGrid.get(row).get(col + 3).equals(player)) {
                    System.out.println("le contre ligne est ok");
                    addPion(col + 2, Menu.couleur2);
                    break;
                }
            }

        }

        // Verifie les colonnes
        for (int col = 0; col < Power4Grid.COLS; col++) {
            for (int row = 5; row >= 3; row--) {
                if (currentGrid.get(row).get(col).equals(player)
                        && currentGrid.get(row - 1).get(col).equals(player)
                        && currentGrid.get(row - 2).get(col).equals(player)
                        && currentGrid.get(row - 3).get(col).equals("  ")) {
                    System.out.println("colonne");

                    addPion(col, Menu.couleur2);

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
                    break;

                }

                if (currentGrid.get(row).get(col).equals(player)
                        && currentGrid.get(row + 1).get(col + 1).equals(player)
                        && currentGrid.get(row).get(col + 2).equals("  ")
                        && currentGrid.get(row + 3).get(col + 3).equals(player)) {
                    System.out.println("le contre diago est ok");
                    addPion(col + 2, Menu.couleur2);
                    break;
                }

                // diago vers le bas
                if (currentGrid.get(row).get(col + 3).equals(player)
                        && currentGrid.get(row + 1).get(col + 2).equals(player)
                        && currentGrid.get(row + 2).get(col + 1).equals(player)
                        && currentGrid.get(row + 3).get(col + 0).equals("  ")) {
                    System.out.println("diago2");
                    addPion(col + 3, Menu.couleur2);
                    break;

                }

                if (currentGrid.get(row).get(col + 3).equals(player)
                        && currentGrid.get(row + 1).get(col + 2).equals(player)
                        && currentGrid.get(row + 2).get(col + 1).equals("  ")
                        && currentGrid.get(row + 3).get(col + 3).equals(player)) {
                    System.out.println("le contre diago bas est ok");
                    addPion(col + 1, Menu.couleur2);
                    break;
                }

                // anti diago vers le haut
                if (row + 3 < currentGrid.size() && col - 3 >= 0) {
                    if (currentGrid.get(row).get(col).equals(player)
                            && currentGrid.get(row + 1).get(col - 1).equals(player)
                            && currentGrid.get(row + 2).get(col - 2).equals(player)
                            && currentGrid.get(row + 3).get(col - 3).equals("  ")) {
                        System.out.println("anti-diagohaut");
                        addPion(col - 3, Menu.couleur2);
                        break;

                    }

                    if (currentGrid.get(row).get(col).equals(player)
                            && currentGrid.get(row + 1).get(col + 1).equals(player)
                            && currentGrid.get(row).get(col + 2).equals("  ")
                            && currentGrid.get(row + 3).get(col + 3).equals(player)) {
                        System.out.println("le contre diago-haut est ok");
                        addPion(col + 2, Menu.couleur2);
                        break;
                    }

                }

                // anti-diago vers le bas
                if (row + 3 < currentGrid.size() && col - 3 >= 0) {
                    if (currentGrid.get(row).get(col - 3).equals(player)
                            && currentGrid.get(row + 1).get(col - 2).equals(player)
                            && currentGrid.get(row + 2).get(col - 1).equals(player)
                            && currentGrid.get(row + 3).get(col).equals("  ")) {
                        System.out.println("anti-diago-bas");
                        addPion(col - 3, Menu.couleur2);
                        break;

                    }

                    if (currentGrid.get(row).get(col - 3).equals(player)
                            && currentGrid.get(row + 1).get(col - 2).equals(player)
                            && currentGrid.get(row).get(col - 1).equals("  ")
                            && currentGrid.get(row + 3).get(col).equals(player)) {
                        System.out.println("le contre anti diago est ok");
                        addPion(col + 2, Menu.couleur2);
                        break;
                    }

                }

            }
        }

        // Sinon, l'IA joue aléatoirement
        RandomPion2(Menu.couleur1);
    }
}