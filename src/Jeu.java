import model.CustomeUtils;

public class Jeu {
    
    public static void jeu1v1(){
        Power4Grid mygrid = new Power4Grid();
        mygrid.displayGrid();
        Pion Pion = new Pion(mygrid);

        VerifWin vf = new VerifWin(mygrid);
        String currentPlayer = "1";
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
                    return;
                    
                case "1":
                    col = 1;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    break;
                case "2":
                    col = 2;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "3":
                    col = 3;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "4":
                    col = 4;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "5":
                    col = 5;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "6":
                    col = 6;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "7":
                    col = 7;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                default:
                    System.out.println("Veuillez saisir un chiffre entre 1 et 7");
                    mygrid.displayGrid();
                    break;
            }
            currentPlayer = currentPlayer == "1" ? "2" : "1";
            System.out.println(currentPlayer);
        } while (true);

    }
    public static void jeusolo(){
        Power4Grid mygrid = new Power4Grid();
        mygrid.displayGrid();
        Pion Pion = new Pion(mygrid);

        VerifWin vf = new VerifWin(mygrid);
        int currentPlayer = 1;
        Player player = new Player();
        do {
        boolean win = vf.checkWin(currentPlayer);
        if (win) {
            System.out.println("Player " + player.getCurrentPlayer() + " wins!");
            break;
        }
        if(currentPlayer ==1){
            int col;
            String input = CustomeUtils.getUserInput();
            switch (input) {
                case "q":
                    System.out.println("Bye bye");
                    System.exit(0);
                    return;
                    
                case "1":
                    col = 1;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);
                    mygrid.displayGrid();
                    break;
                case "2":
                    col = 2;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "3":
                    col = 3;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "4":
                    col = 4;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "5":
                    col = 5;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "6":
                    col = 6;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                case "7":
                    col = 7;
                    col--;
                    player.changePlayer();

                    Pion.addPion(col, currentPlayer);

                    mygrid.displayGrid();
                    break;
                default:
                    System.out.println("Veuillez saisir un chiffre entre 1 et 7");
                    mygrid.displayGrid();
                    break;
            }
            currentPlayer = currentPlayer == 1 ? 2 : 1;
            System.out.println(currentPlayer);
            
        }else{
            IAniv1.RandomPion();
        }
            
        } while (true);

    }
        
    
}
