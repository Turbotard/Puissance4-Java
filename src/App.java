import java.util.Scanner;

import model.CustomeUtils;

public class App {
    public static void main(String[] args) throws Exception {

        Power4Grid mygrid = new Power4Grid();
        mygrid.displayGrid();
        // Pion mypion = new Pion(mygrid);
        Pion Pion = new Pion(mygrid);

        // int col = 6;
        // col--;
        // Pion.addPion(col);
        // mygrid.displayGrid();
        // Pion.addPion(col);
        // mygrid.displayGrid();
        do {
            int col;
            String input = CustomeUtils.getUserInput();
            switch (input) {
                case "q":
                    System.out.println("Bye bye");
                    System.exit(0);
                    break;
                case "1":
                    col = 1;
                    col--;
                    Pion.addPion(col);
                    VerifWin.checkWin(1);
                    mygrid.displayGrid();
                    break;
                case "2":
                    col = 2;
                    col--;
                    Pion.addPion(col);
                    VerifWin.checkWin(1);

                    mygrid.displayGrid();
                    break;
                case "3":
                    col = 3;
                    col--;
                    Pion.addPion(col);
                    VerifWin.checkWin(1);

                    mygrid.displayGrid();
                    break;
                case "4":
                    col = 4;
                    col--;
                    Pion.addPion(col);
                    VerifWin.checkWin(1);

                    mygrid.displayGrid();
                    break;
                case "5":
                    col = 5;
                    col--;
                    Pion.addPion(col);
                    VerifWin.checkWin(1);

                    mygrid.displayGrid();
                    break;
                case "6":
                    col = 6;
                    col--;
                    Pion.addPion(col);
                    VerifWin.checkWin(1);

                    mygrid.displayGrid();
                    break;
                case "7":
                    col = 7;
                    col--;
                    Pion.addPion(col);
                    VerifWin.checkWin(1);

                    mygrid.displayGrid();
                    break;
                default:
                    System.out.println("Veuillez saisir un chiffre entre 1 et 7");
                    mygrid.displayGrid();
                    break;
            }

        } while (true);

    }
}
