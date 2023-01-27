import java.text.ParseException;

import model.CustomeUtils;

public class Player {
    public static String currentPlayer;
    private static String pseudo1;
    static String pseudo2;
    private static String pion1;
    static String pion2;
    private static String pion;
    public static String currentSymbole;
    public static String currentColor;
    private static final String NAME_PATTERN = "^[a-zA-Z]+(([\\'\\,\\.\\-][a-zA-Z])?[a-zA-Z]*)*$";

    
    public Player() {
        currentPlayer = "1";
    }

    public static String getCurrentPlayer() {
            return currentPlayer;
    }

    public boolean changePlayer() {
        if (currentPlayer == "1") {
            currentPlayer = "2";
            currentSymbole = Menu.couleur2;
        } else if (currentPlayer =="2"){
            currentPlayer = "1";
            currentSymbole = Menu.couleur1;
        }else{
            System.out.println("Erreur");
        }
        return false;
    }

    public static String getcurrentSymbole(){
        return currentSymbole;
    }
    
    public static String setNom() throws ParseException{
        if (currentPlayer.equals ("1")){
            pseudo1 =CustomeUtils.getUserInput();
            CustomeUtils.matchValue(pseudo1, NAME_PATTERN, "prénom invalideuuux");
            
            return pseudo1;
        }else{
            pseudo2 =CustomeUtils.getUserInput();
            CustomeUtils.matchValue(pseudo2, NAME_PATTERN, "prénom invalideuuux");
            return pseudo2;
        }
    }

    public static String getNom() {
        if (currentPlayer.equals("1")){
            return pseudo1;
        }else{
            return pseudo2;
        } 
    }

    public static String setPionP1() {
            pion1 =CustomeUtils.getUserInput();
            return pion1;
    }
    
    public static String setPionP2() {
            pion2 =CustomeUtils.getUserInput();
            return pion2;
    }

    public static String getPionP1() {      
            return pion1;
    }

    public static String getPionP2() {
        return pion2;
    }

    public static String pionAI(){
        pion = Menu.couleur2;
        return pion;
    }

    public int getScore() {
        return 0;
    }
}
