import java.util.Scanner;

public class Tableau {
    public static void grille(){
        int C = 7;
        int L = 6;
        char [][] grille = new char [C] [L];
        for (int x = 0; x < C; x++){
            for (int y = 0 ; y < L; y++){
                grille[x] [y] = '.';
            }
        }
    }

    public static void afficherGrille(){
        int C = 7;
        int L = 6;        

        for (int y = 0; y < L; y++){
            System.out.println("|");
            for (int x = 0; x < C; x++){
                System.out.println("" +  grille() + "");
            }
            System.out.println("|");
            System.out.println();
        }
    }
    
    


}