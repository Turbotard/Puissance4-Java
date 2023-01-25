import java.text.ParseException;

import model.CustomeUtils;

public class Jeu {

    public static void jeu1v1() {
        int tourCount = 0;

        Power4Grid mygrid = new Power4Grid();
        mygrid.displayGrid();
        Pion Pion = new Pion(mygrid);
        
        VerifWin vf = new VerifWin(mygrid);
        String currentPlayer = "1";
        Player player = new Player();

        do {
            boolean win = vf.checkWin(Player.getcurrentSymbole());
            if (win) {
                
                System.out.println("Player " + player.getCurrentPlayer() + " wins!");
                break;
            }


            int col;

            String input;

            input = CustomeUtils.getUserInput();
            

                
            switch (input) {
                case "q":
                    System.out.println("Bye bye");
                    Menu.quit();
                    return;

                case "1":
                    col = 1;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();

                    break;
                case "2":
                    col = 2;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();
                    break;

                case "3":
                    col = 3;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();
                    break;
                case "4":
                    col = 4;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();
                    break;
                case "5":
                    col = 5;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();
                    break;
                case "6":
                    col = 6;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();
                    break;
                case "7":
                    col = 7;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();
                    break;
                default:
                    System.out.println("Veuillez saisir un chiffre entre 1 et 7");
                    mygrid.displayGrid();
                    break;
            }
            currentPlayer = currentPlayer == "1" ? "2" : "1";
            System.out.println("Nombre de tours : " + tourCount);
            System.out.println("Player : " + currentPlayer);
        
        }while (true);
    }
 




    public static void jeusolo() {
        Power4Grid mygrid = new Power4Grid();
        mygrid.displayGrid();
        Pion Pion = new Pion(mygrid);
        VerifWin vf = new VerifWin(mygrid);
        String currentPlayer = "1";
        String PionIA = Pion.setPionIA();
        Player player = new Player();
        do {
            boolean win = vf.checkWin(Player.getcurrentSymbole());
            if (win) {
                System.out.println("Player " + player.getCurrentPlayer() + " wins!");
                break;
            }
            if (currentPlayer == "1") {
                int col;
                String input = CustomeUtils.getUserInput();
                switch (input) {
                    case "q":
                        System.out.println("Bye bye");
                        Menu.quit();
                        return;

                    case "1":
                        col = 1;
                        col--;
                        Pion.addPion(col, currentPlayer);
                        player.changePlayer();
                        mygrid.displayGrid();
                        break;
                    case "2":
                        col = 2;
                        col--;
                        Pion.addPion(col, currentPlayer);
                        player.changePlayer();
                        mygrid.displayGrid();
                        break;
                    case "3":
                        col = 3;
                        col--;

                        Pion.addPion(col, currentPlayer);
                        player.changePlayer();
                        mygrid.displayGrid();
                        break;
                    case "4":
                        col = 4;
                        col--;

                        Pion.addPion(col, currentPlayer);
                        player.changePlayer();
                        mygrid.displayGrid();
                        break;
                    case "5":
                        col = 5;
                        col--;

                        Pion.addPion(col, currentPlayer);
                        player.changePlayer();
                        mygrid.displayGrid();
                        break;
                    case "6":
                        col = 6;
                        col--;

                        Pion.addPion(col, currentPlayer);
                        player.changePlayer();
                        mygrid.displayGrid();
                        break;
                    case "7":
                        col = 7;
                        col--;

                        Pion.addPion(col, currentPlayer);
                        player.changePlayer();
                        mygrid.displayGrid();
                        break;
                    default:
                        System.out.println("Veuillez saisir un chiffre entre 1 et 7");
                        mygrid.displayGrid();
                        break;
                }

            } else {
                Pion.RandomPion1(Player.getPionP1());
                System.out.println("L'IA a joué");
                player.changePlayer();
                mygrid.displayGrid();
            }
            currentPlayer = currentPlayer == "1" ? "2" : "1";
            System.out.println(currentPlayer);

        } while (true);

    }

}




