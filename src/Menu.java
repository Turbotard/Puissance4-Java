
import java.io.IOException;
import java.text.ParseException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import model.ConsoleColors;
import model.CustomeUtils;
import java.util.*;
/**
 * Ensemble des méthodes qui permettent d'afficher différents menus et gérer les
 * choix de l'utilisateur
 */
public class Menu { // classe mneu
    
    // intialisation de variables
    public static String couleur1 = "💙";
    public static String couleur2 = "💔";
    static int bestScore = 0;
    static String bestPlayer = "";
    public static Object main;

    public static void lister(String filePath) { // fonction pour afficher le top 10 des meilleurs joueurs / autheur : Lucas
        List<String[]> scores = new ArrayList<>();
        String line;
        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] score = line.split(cvsSplitBy);
                scores.add(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(scores, (a, b) -> Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1])));
        int limit = Math.min(scores.size(), 10);
        if (scores.size() < 10) {
            limit = scores.size();
        }
        for (int i = 0; i < limit; i++) {
            System.out.println("Joueur: " + scores.get(i)[0] + " avec un score de " + scores.get(i)[1]);
        }
    }

    /**
     * Affiche le menu principal et gère les choix de l'utilisateur
     * @throws IOException
     */
    public static void displayMenu() throws ParseException, IOException {  // fontion permettant d'afficher le menu principal / autheur : Esteban
        do {
            System.out.println(ConsoleColors.GREEN + "  -- Menu --");
            System.out.println("1. Jouer en solo");
            System.out.println("2. Jouer à deux ");
            System.out.println("3. Afficher le top 10");
            System.out.println("q. Quitter le menu" + ConsoleColors.DEFAULT);

            String input = CustomeUtils.getUserInput();

            switch (input) {
                case "1":
                    DiffIA();
                    
                    break;
                case "2":
                    settingP1();
                    settingP2();
                    Jeu.jeu1v1();
                    break;
                case "3":
                    lister("Top10.csv");
                    break;
                case "q":
                    quit();
                    return;
                default:
                    System.out.println(ConsoleColors.RED + "Veuillez entrer une option valide" + ConsoleColors.DEFAULT);
                    break;
            }
        } while (true);
    }

    public static int lvl;
    public static String couleurIA;

    public static void DiffIA() throws ParseException {  // fonction pour afficher le menu de difficultées de IA / autheurs : Esteban et Samba 

        System.out.println(ConsoleColors.GREEN + "1. difficulté 1" + ConsoleColors.DEFAULT);
        System.out.println(ConsoleColors.YELLOW + "2. difficulté 2" + ConsoleColors.DEFAULT);
        System.out.println(ConsoleColors.PURPLE + "3. difficulté 3" + ConsoleColors.DEFAULT);
        System.out.println(ConsoleColors.RED + "4. GODMODE !!!!" + ConsoleColors.DEFAULT);
        String input = CustomeUtils.getUserInput();
        switch (input){
            case "1":
                settingP1();
                settingIA();
                lvl = 1;
                Jeu.jeusolo();
                
                break;
            case "2":
                settingP1();
                settingIA();
                lvl = 2;
                Jeu.jeusolo();
                
                break;
            case "3":
                settingP1();
                settingIA();
                lvl = 3;
                Jeu.jeusolo();
                
                break;
            case "4":
                settingP1();
                settingIA();
                lvl = 4;
                Jeu.jeusolo();
                
                break;
            default:
                System.out.println(ConsoleColors.RED + "Veuillez entrer une option valide de difficulté" + ConsoleColors.DEFAULT);
                break;
        }
    }
    

    public static void quit() { // fonction du message de sortie de menu / autheur : Esteban
        System.out.println(ConsoleColors.RED + "Fermeture du menu..." + ConsoleColors.DEFAULT);
    }

    public static void settingP1() throws ParseException{  // fonction pour paramétrer le joueur 1 / autheur : Esteban
        Player.currentPlayer ="1";
        System.out.println("Joueur1");
        System.out.println("Veuillez choisir le nom de votre choix");
        Player.setNom();
        System.out.println("Veuillez choisir le symbole de votre choix");;
        try {
            displayMenuCouleurP1();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void settingP2() throws ParseException{  // fonction pour paramétrer le joueur 2 / autheur : Esteban
        Player.currentPlayer ="2";
        System.out.println("Joueur 2");
        System.out.println("Veuillez choisir le nom de votre choix");
        Player.setNom();
        System.out.println("Veuillez choisir le symbole de votre choix");
        try {
            displayMenuCouleurP2();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public static void settingIA(){  // fonction de paramètre de l'IA / autheur : Esteban
        Player.currentPlayer ="2";
        Player.pseudo2 ="IA";
    }


    public static void displayMenuCouleurP1() throws ParseException {  // fonction pour paramétrer le pion du joueur 1 avec un menu
        do {                                                           // autheurs : Esteban et Benjamin
            System.out.println(ConsoleColors.GREEN + "  -- Menu Couleur--");
            System.out.println("1. 💖");
            System.out.println("2. 💚");
            System.out.println("3. 💙");
            System.out.println("4. 💛");
            System.out.println("5. 💜");
            System.out.println("6. 🖤");
            System.out.println("7. 🧡");
            System.out.println("e. accepter les modifs" + ConsoleColors.DEFAULT);
            String input = CustomeUtils.getUserInput();

            switch (input) {
                case "1":
                    couleur1 = "💖";
                    break;
                case "2":
                    couleur1 = "💚";
                    break;
                case "3":
                    couleur1 = "💙";
                    break;
                case "4":
                    couleur1 = "💛";
                    break;
                case "5":
                    couleur1 = "💜";
                    break;
                case "6":
                    couleur1 = "🖤";
                    break;
                case "7":
                    couleur1= "🧡";
                    break;
                case "e":
                    return;
                default:
                    System.out.println(ConsoleColors.RED + "Veuillez entrer une option valide" + ConsoleColors.DEFAULT);
                    break;
            }
        } while (true);
    }
    public static void displayMenuCouleurP2() throws ParseException {  // fonction pour paramétrer le pion du joueur 2 avec un menu                                                                  
        do {                                                           // autheurs : Esteban et Benjamin
            System.out.println(ConsoleColors.GREEN + "  -- Menu Couleur--");
            System.out.println("1. 💖");
            System.out.println("2. 💚");
            System.out.println("3. 💙");
            System.out.println("4. 💛");
            System.out.println("5. 💜");
            System.out.println("6. 🖤");
            System.out.println("7. 🧡");
            System.out.println("e. accepter les modifs" + ConsoleColors.DEFAULT);

            String input = CustomeUtils.getUserInput();

            switch (input) {
                case "1":
                    couleur2 = "💖";
                    break;
                case "2":
                    couleur2 = "💚";
                    break;
                case "3":
                    couleur2 = "💙";
                    break;
                case "4":
                    couleur2 = "💛";
                    break;
                case "5":
                    couleur2 = "💜";
                    break;
                case "6":
                    couleur2 = "🖤";
                    break;
                case "7":
                    couleur2 = "🧡";
                    break;
                case "e":
                    return;
               default:
                    System.out.println(ConsoleColors.RED + "Veuillez entrer une option valide" + ConsoleColors.DEFAULT);
                    break;
            }
        } while (true);
    }
}