package model;
import java.text.ParseException;

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

    
    /**
     * auteur Esteban
     *  Fonction qui attribue un player
     */
    public Player() {
        currentPlayer = "1";
    }

    /**
     * auteur Esteban
     * Permet de récuperer quel joueur est entrain de jouer
     * @return currentPlayer
     */
    public static String getCurrentPlayer() {
            return currentPlayer;
    }

    /**
     * auteur Esteban
     * Permet de changer de joueur et ça couleur 
     * @return
     */
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

    /**
     * auteur Esteban   
     * Récupère le symbole actuel
     * @return current
     */
    public static String getcurrentSymbole(){
        return currentSymbole;
    }
    
    /**
     * auteur Esteban
     * Permet d'attribuer le nom du joueur
     * @return String
     * @throws ParseException
     */
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

    /**
     * auteur Esteban
     * Permet de récuperer le nom du joueur
     * @return
     */
    public static String getNom() {
        if (currentPlayer.equals("1")){
            return pseudo1;
        }else{
            return pseudo2;
        } 
    }

    /**
     * auteur Benjamin
     * Permet de créer le Pion du Joueur 1
     * @return
     */
    public static String setPionP1() {
            pion1 =CustomeUtils.getUserInput();
            return pion1;
    }

    /**
     * auteur Benjamin
     * Permet de créer le Pion du Joueur 2
     * @return
     */
    public static String setPionP2() {
            pion2 =CustomeUtils.getUserInput();
            return pion2;
    }
    /**
     * auteur Benjamin
     * Permet de récuperer le Pion du Joueur 1
     * @return
     */

    public static String getPionP1() {      
            return pion1;
    }

    /**
     * auteur Benjamin
     * Permet de récuperer le Pion du Joueur 2
     * @return
     */
    public static String getPionP2() {
        return pion2;
    }

}
