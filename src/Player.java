import model.CustomeUtils;

public class Player {
    public static String currentPlayer;
    private static String pseudo1;
    private static String pseudo2;
    private static String pion1;
    private static String pion2;
    private static String pion;
    public static String currentSymbole;
    public static String currentColor;

    
    public Player() {
        currentPlayer = "1";
    }

    public String getCurrentPlayer() {
            return currentPlayer;
    }

    public boolean changePlayer() {
        if (currentPlayer == "1") {
            currentPlayer = "2";
            currentSymbole = getPionPlayer2();
        } else if (currentPlayer =="2"){
            currentPlayer = "1";
            currentSymbole = getPionPlayer1();
        }else{
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

    public static  String getPionPlayer1(){
        return pion1;
    }

    public static String setPionP1(){
        pion1 =CustomeUtils.getUserInput();
        return pion1;
    }
    
    public static  String getPionPlayer2(){
        return pion2;
    }

    public static String setPionP2(){
        pion2 =CustomeUtils.getUserInput();
        return pion2;
    }

    public static String pionIA(){
        pion = "x";
        return pion;
    }
    public static String getcurrentSymbole(){
        return currentSymbole;
    }
   
}
