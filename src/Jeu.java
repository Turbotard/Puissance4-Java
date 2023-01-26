
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.CustomeUtils;

public class Jeu {

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

    // private static final int MAX_SCORE_COUNT = 10;

    // private static void saveScore(Player player, int score) {
    // try {
    // //Créer ou ouvrir le fichier "Top10.csv" en mode "append"
    // File file = new File("Top10.csv");
    // FileWriter fw = new FileWriter(file, true);
    // BufferedWriter bw = new BufferedWriter(fw);

    // //Lire les scores existants dans le fichier
    // List<Score> scores = readScores();

    // //Ajouter le nouveau score à la liste
    // scores.add(new Score(player.getNom(), score));

    // //Trier la liste des scores par ordre décroissant de score (meilleur score en
    // premier)
    // scores.sort((s1, s2) -> s1.score - s2.score);

    // //Retenir les 10 meilleurs scores
    // if(scores.size() > MAX_SCORE_COUNT) {
    // scores = scores.subList(0, MAX_SCORE_COUNT);
    // }

    // //Effacer le contenu du fichier pour écrire les scores à jour
    // fw.flush();
    // fw.seek(0);

    // //Ecriture des scores dans le fichier
    // for (Score sc : scores) {
    // bw.write(sc.name + "," + sc.score);
    // bw.newLine();
    // }
    // bw.close();
    // } catch (IOException e) {
    // System.out.println("Erreur lors de la sauvegarde du score : " +
    // e.getMessage());
    // }
    // }

    // private static List<Score> readScores() throws IOException {
    // List<Score> scores = new ArrayList<>();
    // File file = new File("Top10.csv");
    // if (file.exists() && file.length() > 0) {
    // try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    // String line;
    // while ((line = br.readLine()) != null) {
    // String[] parts = line.split(",");
    // scores.add(new Score(parts[0], Integer.parseInt(parts[1])));
    // }
    // }
    // }
    // return scores;
    // }

    private static class Score {
        public String name;
        public int score;

        public Score(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

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
            boolean egalite = VerifWin.checkNul();
            if (win) {

                System.out.println("Player " + player.getCurrentPlayer() + " wins!");
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
                    currentPlayer = currentPlayer;
                    mygrid.displayGrid();
                    break;
            }

            System.out.println("Nombre de tours : " + tourCount);
            System.out.println("Player : " + currentPlayer);

        } while (true);
    }
 




    /**
     * 
     */
    public static void jeusolo() {
        int tourCount = 0;
        Power4Grid mygrid = new Power4Grid();
        mygrid.displayGrid();
        Pion Pion = new Pion(mygrid);
        VerifWin vf = new VerifWin(mygrid);
        String currentPlayer = "1";
        String PionIA = Pion.setPionIA();
        Player player = new Player();
        do {
            boolean win = vf.checkWin(Player.getcurrentSymbole());
            boolean egalite = VerifWin.checkNul();
            if (win) {
                System.out.println("Player " + player.getCurrentPlayer() + " wins!");
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
                // do {
                //     int col;
                //     if (Menu.lvl == 1){
                //         col = Pion.RandomPion();
                //         System.out.println("IA lvl 1 à joué");
                //     }else if (Menu.lvl == 2){
                //         col = Pion.RandomPion1(Menu.couleur1);
                //         System.out.println("IA lvl 2 à joué");
                //     }
                //     // else if (Menu.lvl == 3){
                //     //     col = Pion.RandomPion2(Menu.couleur1);
                //     //     System.out.println("IA lvl 3 à joué");
                //     // }

                //     if (!vf.checkcol(col)) {
                //         Pion.addPion(col, Menu.couleur2);
                //         break;
                //     }
                // } while (true);
                // randomPion 1 2 3 4
                
                    if (vf.checkcolbot()){
                        break;
                    }else{
                        if (Menu.lvl == 1){
                            Pion.RandomPion();
                            System.out.println("IA lvl 1 à joué");
                        }else if (Menu.lvl == 2){
                            Pion.RandomPion1(Menu.couleur1);
                            System.out.println("IA lvl 2 à joué");
                        }else if (Menu.lvl == 3){
                            Pion.RandomPion2(Menu.couleur1);
                            System.out.println("IA lvl 3 à joué");
                        }
                    }
                    System.out.println("L'IA a joué");
                    player.changePlayer();
                    mygrid.displayGrid();
                    currentPlayer = currentPlayer == "1" ? "2" : "1";    
        }       
    }while(true);
            System.out.println(currentPlayer);

        
    }
}




