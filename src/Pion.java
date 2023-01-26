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

   }

   public static boolean addPionBot(int col, String player) {
       ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
       if (Player.getCurrentPlayer() == "1") {
           for (int row = Power4Grid.ROWS - 1; row >= 0; row--) {
               if (currentGrid.get(row).get(col) == "  ") {
                   currentGrid.get(row).set(col, Menu.couleur1);
                   grid.setGrid(currentGrid);
                   break;
               }
           }
       } else if (Player.getCurrentPlayer() == "AI") {
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

   public void RandomPion() {
       Random rand = new Random();
       int bot = rand.nextInt(6 - 0) + 0;
       addPion(bot, Menu.couleur2);
       bot = rand.nextInt(6 - 0) + 0;
   }

   public void RandomPion1(String player){
       Random rand = new Random();
       int random = rand.nextInt(6 - 0) + 0;
       ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
       boolean jouer = false;
       // Vérifie les lignes
       for (int row = 0; row < Power4Grid.ROWS; row++) {
           for (int col = 0; col < Power4Grid.COLS - 3; col++) {
               if (currentGrid.get(row).get(col).equals(player)
                       && currentGrid.get(row).get(col +1).equals(player)
                       && currentGrid.get(row).get(col +2).equals(player)
                       && currentGrid.get(row).get(col + 3).equals("  ")) {
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
                       && currentGrid.get(row -1).get(col).equals(player)
                       && currentGrid.get(row -2).get(col).equals(player)
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
                    && currentGrid.get(row + 1).get(col +1).equals(player)
                    && currentGrid.get(row + 2).get(col +2).equals(player)
                    && currentGrid.get(row + 3).get(col +3).equals("  ")) {
                    addPion(col + 3, Menu.couleur2);
                
            }

            // diago vers le bas
                    if (currentGrid.get(row).get(col +3).equals(player)
                    && currentGrid.get(row + 1).get(col +2).equals(player)
                    && currentGrid.get(row + 2).get(col +1).equals(player)
                    && currentGrid.get(row+3).get(col +0).equals("  ")) {
                    addPion(col + 3, Menu.couleur2);
        
            }

                //anti diago vers le haut
                if (row + 3 < currentGrid.size() && col - 3 >= 0) {
                if (currentGrid.get(row).get(col).equals(player)
                && currentGrid.get(row + 1).get(col -1).equals(player)
                && currentGrid.get(row + 2).get(col -2).equals(player)
                && currentGrid.get(row + 3).get(col -3).equals("  ")) {
               addPion(col - 3, Menu.couleur2);
        
}
            }

            // anti-diago vers le bas
            if (row + 3 < currentGrid.size() && col - 3 >= 0) {
            if (currentGrid.get(row).get(col -3).equals(player)
            && currentGrid.get(row + 1).get(col -2).equals(player)
            && currentGrid.get(row + 2).get(col -1).equals(player)
            && currentGrid.get(row+3).get(col -0).equals("  ")) {
           addPion(col - 3, Menu.couleur2);
        
}
            }

        }
    }
    if (jouer == false){
        random = rand.nextInt(Power4Grid.COLS);
        System.out.println("pif");
        addPion(random, Menu.couleur2);
        jouer = false;    
    }
    
    
    /*if (!jouer) {
        random = rand.nextInt(6 - 0) + 0;
        addPion(random, Menu.couleur2);
    }*/
    
   }
   /*-----------------------------------------------------------------------------------------------------------------------

                    IA NIV 3

   -----------------------------------------------------------------------------------------------------------------------*/


   public void RandomPion2(String player){
    Random rand = new Random();
    int random = rand.nextInt(6 - 0) + 0;
    ArrayList<ArrayList<String>> currentGrid = grid.getGrid();
    boolean jouer = false;
    // Vérifie les lignes
    for (int row = 0; row < Power4Grid.ROWS; row++) {
        for (int col = 0; col < Power4Grid.COLS - 3; col++) {
            if (currentGrid.get(row).get(col).equals(player)
                    && currentGrid.get(row).get(col +1).equals(player)
                    && currentGrid.get(row).get(col +2).equals(player)
                    && currentGrid.get(row).get(col + 3).equals("  ")) {
                System.out.println("ligne");
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
                    && currentGrid.get(row -1).get(col).equals(player)
                    && currentGrid.get(row -2).get(col).equals(player)
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
                 && currentGrid.get(row + 1).get(col +1).equals(player)
                 && currentGrid.get(row + 2).get(col +2).equals(player)
                 && currentGrid.get(row + 3).get(col +3).equals("  ")) {
                     System.out.println("diago1");
                 addPion(col + 3, Menu.couleur2);
             
         }

         // diago vers le bas
                 if (currentGrid.get(row).get(col +3).equals(player)
                 && currentGrid.get(row + 1).get(col +2).equals(player)
                 && currentGrid.get(row + 2).get(col +1).equals(player)
                 && currentGrid.get(row+3).get(col +0).equals("  ")) {
                     System.out.println("diago2");
                 addPion(col + 3, Menu.couleur2);
     
         }

             //anti diago vers le haut
             if (row + 3 < currentGrid.size() && col - 3 >= 0) {
             if (currentGrid.get(row).get(col).equals(player)
             && currentGrid.get(row + 1).get(col -1).equals(player)
             && currentGrid.get(row + 2).get(col -2).equals(player)
             && currentGrid.get(row + 3).get(col -3).equals("  ")) {
             System.out.println("anti-diagohaut");
            addPion(col - 3, Menu.couleur2);
     
}
         }

         // anti-diago vers le bas
         if (row + 3 < currentGrid.size() && col - 3 >= 0) {
         if (currentGrid.get(row).get(col -3).equals(player)
         && currentGrid.get(row + 1).get(col -2).equals(player)
         && currentGrid.get(row + 2).get(col -1).equals(player)
         && currentGrid.get(row+3).get(col -0).equals("  ")) {
         System.out.println("anti-diago-bas");
        addPion(col - 3, Menu.couleur2);
     
}
         }

     }
 }
 if (jouer == false){
     random = rand.nextInt(Power4Grid.COLS);
     System.out.println("pif");
     addPion(random, Menu.couleur2);
     jouer = false;    
 }
 

   }

   public void IAgodmode(String player) {
    ArrayList<ArrayList<String>> currentGrid = grid.getGrid();

    // Vérifie si l'IA peut aligner 4 pions
    for (int row = 0; row < Power4Grid.ROWS; row++) {
        for (int col = 0; col < Power4Grid.COLS - 3; col++) {
            if (currentGrid.get(row).get(col)== player
                    && currentGrid.get(row).get(col + 1)== player
                    && currentGrid.get(row).get(col + 2)== "  "
                    && currentGrid.get(row).get(col + 3)== "  ") {
                currentGrid.get(row).set(col + 2, player);
                VerifWin.nbPion++;
                if (VerifWin.checkWin(player)) {
                    System.out.println("IA a gagné !");
                    return;
                }
                return;
            }
        }
    }


    // Sinon, l'IA joue aléatoirement
    RandomPion2(player);
}
}