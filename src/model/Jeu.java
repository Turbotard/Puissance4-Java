package model;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Jeu {  //classe jeu


    /**
     * auteur Lucas
     * Sauvegarde de Score
     */
    private static void saveScore(String player, int tourCount) {
        try {
            File file = new File("Top10.csv");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(player + ";" + tourCount);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }

    /**
     * auteur Samba, Esteban et Benjamin
     * Jouer l'un contre l'autre 
     */
    public static void jeu1v1() { // 
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

                System.out.println("Player " + Player.getCurrentPlayer() + " wins!");
                saveScore(Player.getNom(), tourCount/2);
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

                    currentPlayer = currentPlayer == "1" ? "2" : "1";
                    break;
                case "2":
                    col = 2;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();
                    currentPlayer = currentPlayer == "1" ? "2" : "1";
                    break;

                case "3":
                    col = 3;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();
                    currentPlayer = currentPlayer == "1" ? "2" : "1";
                    break;
                case "4":
                    col = 4;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();
                    currentPlayer = currentPlayer == "1" ? "2" : "1";
                    break;
                case "5":
                    col = 5;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();
                    currentPlayer = currentPlayer == "1" ? "2" : "1";
                    break;
                case "6":
                    col = 6;
                    col--;
                    if (vf.checkcol(col)) {
                        break;
                    } else {
                        Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion += 1;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid();
                        break;
                    }
                case "7":
                    col = 7;
                    col--;
                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    tourCount++;
                    player.changePlayer();
                    currentPlayer = currentPlayer == "1" ? "2" : "1";
                    break;
                default:
                    System.out.println("Veuillez saisir un chiffre entre 1 et 7");
                    mygrid.displayGrid();
                    break;
            }

            System.out.println("Nombre de tours : " + tourCount);
            System.out.println("Player : " + currentPlayer);

        } while (true);
    }
 
    /**
     * auteur Samba, Esteban et Benjamin
     * Jouer contre l'IA 
     */
    public static void jeusolo() {
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
                System.out.println("Player " + Player.getCurrentPlayer() + " wins!");
                saveScore(Player.getNom(), tourCount);
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
                        if (vf.checkcol(col) == true) {
                            break;
                        } else {
                            Pion.addPion(col, currentPlayer);
                            VerifWin.nbPion++;
                            player.changePlayer();
                            currentPlayer = currentPlayer == "1" ? "2" : "1";
                            mygrid.displayGrid();
                            tourCount++;
                            break;
                        }
                    case "2":
                        col = 2;
                        col--;
                        if (vf.checkcol(col)) {
                            break;
                        } else {
                            Pion.addPion(col, currentPlayer);
                            VerifWin.nbPion++;
                            player.changePlayer();
                            currentPlayer = currentPlayer == "1" ? "2" : "1";
                            mygrid.displayGrid();
                            tourCount++;
                            break;
                        }
                    case "3":
                        col = 3;
                        col--;
                        if (vf.checkcol(col)) {
                            break;
                        } else {
                            Pion.addPion(col, currentPlayer);
                            VerifWin.nbPion++;
                            player.changePlayer();
                            currentPlayer = currentPlayer == "1" ? "2" : "1";
                            mygrid.displayGrid();
                            tourCount++;
                            break;
                        }
                    case "4":
                        col = 4;
                        col--;
                        if (vf.checkcol(col)) {
                            break;
                        } else {
                            Pion.addPion(col, currentPlayer);
                            VerifWin.nbPion++;
                            player.changePlayer();
                            currentPlayer = currentPlayer == "1" ? "2" : "1";
                            mygrid.displayGrid();
                            tourCount++;
                            break;
                        }
                    case "5":
                        col = 5;
                        col--;
                        if (vf.checkcol(col)) {
                            break;
                        } else {
                            Pion.addPion(col, currentPlayer);
                            VerifWin.nbPion++;
                            player.changePlayer();
                            currentPlayer = currentPlayer == "1" ? "2" : "1";
                            mygrid.displayGrid();
                            tourCount++;
                            break;
                        }
                    case "6":
                        col = 6;
                        col--;
                        if (vf.checkcol(col)) {
                            break;
                        } else {
                            Pion.addPion(col, currentPlayer);
                            VerifWin.nbPion++;
                            player.changePlayer();
                            currentPlayer = currentPlayer == "1" ? "2" : "1";
                            mygrid.displayGrid();
                            tourCount++;
                            break;
                        }
                    case "7":
                        col = 7;
                        col--;
                        if (vf.checkcol(col)) {
                            break;
                        } else {
                            Pion.addPion(col, currentPlayer);
                            VerifWin.nbPion++;
                            player.changePlayer();
                            currentPlayer = currentPlayer == "1" ? "2" : "1";
                            mygrid.displayGrid();
                            tourCount++;
                            break;
                        }
                    default:
                        System.out.println("Veuillez saisir un chiffre entre 1 et 7");
                        mygrid.displayGrid();
                        break;
                }
            } else {
                    if (Menu.lvl == 1){
                        Pion.RandomPion();
                        System.out.println("IA lvl 1 ?? jou??");
                    }else if (Menu.lvl == 2){
                        Pion.RandomPion1(Menu.couleur1);
                        System.out.println("IA lvl 2 ?? jou??");
                    }else if (Menu.lvl == 3){
                        Pion.RandomPion2(Menu.couleur1);
                        System.out.println("IA lvl 3 ?? jou??");
                    }else if (Menu.lvl == 4){
                        Pion.IAgodmode(Menu.couleur2);
                        System.out.println("IA lvl 4 ?? jou??");
                    }
                    System.out.println("L'IA a jou??");
                    player.changePlayer();
                    mygrid.displayGrid();
                    currentPlayer = currentPlayer == "1" ? "2" : "1";    
        }       
    }while(true);
        System.out.println(currentPlayer);     
    }
}