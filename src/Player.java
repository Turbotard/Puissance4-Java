import model.CustomeUtils;

public class Player {
    public static String currentPlayer;
    private static String pseudo1;
    private static String pseudo2;
    private static String pion1;
    private static String pion2;
    

    public Player() {
        currentPlayer = "1";
    }

    public String getCurrentPlayer() {
        if (currentPlayer == "1"){
            currentPlayer = getNomPlayer1();
            return currentPlayer;
        }
        else{
            currentPlayer = getNomPlayer2();
            return currentPlayer;
        }
    }

    public boolean changePlayer() {
        if (currentPlayer == "1") {
            currentPlayer = "2";
        } else {
            System.out.println("Erreur");
        }
        return false;
    }

    public static String getNomPlayer1(){
        return pseudo1;
    }

    public static String setNomPlayer1(){
        pseudo1 =CustomeUtils.getUserInput();
        return pseudo1;
    }
    
    public static String getNomPlayer2(){
        return pseudo2;
    }

    public static String setNomPlayer2(){
        pseudo2 =CustomeUtils.getUserInput();
        return pseudo2;
    }

    public static String getPionPlayer1(){
        return pion1;
    }

    public static String setPionP1(){
        pion1 =CustomeUtils.getUserInput();
        return pion1;
    }
    
    public static String getPionPlayer2(){
        return pion2;
    }

    public static String setPionP2(){
        pion2 =CustomeUtils.getUserInput();
        return pion2;
    }
}
