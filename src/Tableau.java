import java.util.Scanner;

public class Tableau {
    public static void grille() {
        int C = 7;
        int L = 6;
        char[][] grille = new char[C][L];
        for (int x = 0; x < C; x++) {
            for (int y = 0; y < L; y++) {
                grille[x][y] = '.';
            }
        }

        for (int loop = 0; loop < C + 2 + 2 * C; loop++)
            System.out.print('-');
        System.out.println();

        for (int y = 0; y < L; y++) {
            System.out.print("|");
            for (int x = 0; x < C; x++) {
                System.out.print(" " + grille[x][y] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        for (int loop = 0; loop < C + 2 + 2 * C; loop++)
            System.out.print('-');
        System.out.println();
    }

} 