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
            boolean egalite = VerifWin.checkNul();
            if (win) {
                
                System.out.println("Player " + player.getNom() + " wins!");
                break;
            }
            if (egalite){
                System.out.println("Dommage");
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
                    if (vf.checkcol(col)){
                        break;
                    }else{
                        Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
                        break;
                    }
                case "2":
                    col = 2;
                    col--;
                    if (vf.checkcol(col)){
                        break;
                    }else{
                        Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
                        break;
                    }

                case "3":
                    col = 3;
                    col--;
                    if (vf.checkcol(col)){
                        break;
                    }else{
                        Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
                        break;
                    }
                case "4":
                    col = 4;
                    col--;
                    if (vf.checkcol(col)){
                        break;
                    }else{
                        Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
                        break;
                    }
                case "5":
                    col = 5;
                    col--;
                    if (vf.checkcol(col)){
                        break;
                    }else{
                        Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
                        break;
                    }
                case "6":
                    col = 6;
                    col--;
                    if (vf.checkcol(col)){
                        break;
                    }else{
                        Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
                        break;
                    }
                case "7":
                    col = 7;
                    col--;
                    if (vf.checkcol(col)){
                        break;
                    }else{
                        Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
                        break;
                    }
                default:
                    System.out.println("Veuillez saisir un chiffre entre 1 et 7");
                    currentPlayer = currentPlayer ;
                    mygrid.displayGrid();
                    break;
            }
            
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
            boolean egalite = VerifWin.checkNul();
            if (win) {
                System.out.println("Player " + player.getNom() + " wins!");
                break;
            }
            if (egalite){
                System.out.println("Dommage");
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
                        if (vf.checkcol(col) == true){
                            break;
                        }else{
                            Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
                        break;
                        }
                    case "2":
                        col = 2;
                        col--;
                        if (vf.checkcol(col)){
                            break;
                        }else{
                            Pion.addPion(col, currentPlayer);
                            VerifWin.nbPion ++;
                            player.changePlayer();
                            currentPlayer = currentPlayer == "1" ? "2" : "1";

                            mygrid.displayGrid(); 
                            break;
                        }
                    case "3":
                        col = 3;
                        col--;
                        if (vf.checkcol(col)){
                            break;
                        }else{
                            Pion.addPion(col, currentPlayer);
                            VerifWin.nbPion ++;
                            player.changePlayer();
                            currentPlayer = currentPlayer == "1" ? "2" : "1";

                            mygrid.displayGrid(); 
                        break;
                        }
                    case "4":
                        col = 4;
                        col--;
                        if (vf.checkcol(col)){
                            break;
                        }else{
                            Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
                        break;
                        }
                    case "5":
                        col = 5;
                        col--;
                        if (vf.checkcol(col)){
                            break;
                        }else{
                            Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
                        break;
                        }
                    case "6":
                        col = 6;
                        col--;
                        if (vf.checkcol(col)){
                            break;
                        }else{
                            Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
                        break;
                        }
                    case "7":
                        col = 7;
                        col--;
                        if (vf.checkcol(col)){
                            break;
                        }else{
                            Pion.addPion(col, currentPlayer);
                        VerifWin.nbPion ++;
                        player.changePlayer();
                        currentPlayer = currentPlayer == "1" ? "2" : "1";

                        mygrid.displayGrid(); 
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
                    System.out.println("IA lvl 1 à joué");
                }else if (Menu.lvl == 2){
                    Pion.RandomPion1(Menu.couleur1);
                    System.out.println("IA lvl 2 à joué");
                }else if (Menu.lvl == 3){
                    Pion.RandomPion2(Menu.couleur1);
                    System.out.println("IA lvl 3 à joué");
                }
                System.out.println("L'IA a joué");
                player.changePlayer();
                mygrid.displayGrid();
                currentPlayer = currentPlayer == "1" ? "2" : "1";

            }
            System.out.println(currentPlayer);

        } while (true);

    }

}




