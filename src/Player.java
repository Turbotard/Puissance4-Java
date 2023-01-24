import java.util.Scanner;

import model.ConsoleColors;

public class Player {
    public static String currentPlayer;
    private static String pseudo1;
    private static String pseudo2;
    private static String pion1;
    private static String pion2;
    private static String couleur;
    

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

    public void changePlayer() {
        if (currentPlayer == "1") {
            currentPlayer = "2";
        } else {
            currentPlayer = "1";
        }
    }

    public static String getNomPlayer1(){
        return pseudo1;
    }

    public static String setNomPlayer1(){
        Scanner scanner = new Scanner(System.in);
        pseudo1 = scanner.nextLine();
        return pseudo1;
    }
    
    public static String getNomPlayer2(){
        return pseudo2;
    }

    public static String setNomPlayer2(){
        Scanner scanner = new Scanner(System.in);
        pseudo2 = scanner.nextLine();
        return pseudo2;
    }

    public static String getPionPlayer1(){
        return pion1;
    }

    public static String setPionP1(){
        Scanner scanner = new Scanner(System.in);
        pion1 = scanner.nextLine();
        return pion1;
    }
    
    public static String getPionPlayer2(){
        return pion2;
    }

    public static String setPionP2(){
        Scanner scanner = new Scanner(System.in);
        pion2 = scanner.nextLine();
        return pion2;
    }
}
