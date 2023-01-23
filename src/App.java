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
        VerifWin vf = new VerifWin(mygrid);
        int currentPlayer = 1;
        Player player = new Player();
        do {
        boolean win = vf.checkWin(currentPlayer);
        if (win) {
            System.out.println("Player " + player.getCurrentPlayer() + " wins!");
            break;
        }
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
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    break;
                case "2":
                    col = 2;
                    col--;
                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "3":
                    col = 3;
                    col--;
                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "4":
                    col = 4;
                    col--;
                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "5":
                    col = 5;
                    col--;
                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "6":
                    col = 6;
                    col--;
                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "7":
                    col = 7;
                    col--;
                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                default:
                    System.out.println("Veuillez saisir un chiffre entre 1 et 7");
                    mygrid.displayGrid();
                    break;
            }
            currentPlayer = currentPlayer == 1 ? 2 : 1;
            player.changePlayer();
            System.out.println(currentPlayer);
        } while (true);

    }
}
