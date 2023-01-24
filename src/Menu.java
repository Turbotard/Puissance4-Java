
import java.text.ParseException;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.ArrayList;
// import java.util.stream.Collectors;

import model.CustomeUtils;
import model.ConsoleColors;

/**
 * Ensemble des méthodes qui permettent d'afficher différents menus et gérer les
 * choix de l'utilisateur
 */
public class Menu {
    public static String couleur1;
    public static String couleur2;

    /**
     * Affiche le menu principal et gère les choix de l'utilisateur
     */
    public static void displayMenu() throws ParseException {
        do {
            System.out.println(ConsoleColors.GREEN + "  -- Menu --");
            System.out.println("1. Jouer en solo");
            System.out.println("2. Jouer à deux ");
            System.out.println("3. Afficehr le top 10");
            System.out.println("q. Quitter le menu" + ConsoleColors.DEFAULT);

            String input = CustomeUtils.getUserInput();

            switch (input) {
                case "1":
                    settingIA();
                    settingP2();
                    Jeu.jeusolo();
                    break;
                case "2":
                    settingP1();
                    settingP2();
                    Jeu.jeu1v1();
                    break;
                case "3":
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

    public static void quit() {
        System.out.println(ConsoleColors.RED + "Fermeture du menu..." + ConsoleColors.DEFAULT);
    }

    public static void settingP1(){
        System.out.println("Joueur1");
        System.out.println("Veuillez choisir le nom de votre choix");
        Player.setNomPlayer1();
        System.out.println("Veuillez choisir le symbole de votre choix");
        Player.setPionP1();
        try {
            displayMenuCouleurP1();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /*System.out.println("Veuillez choisir la couleur de votre choix");
        Player.getCouleur();*/
    }

    public static void settingP2(){
        System.out.println("Joueur 2");
        System.out.println("Veuillez choisir le nom de votre choix");
        Player.setNomPlayer2();
        System.out.println("Veuillez choisir le symbole de votre choix");
        Player.setPionP2();
        try {
            displayMenuCouleurP2();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void settingIA(){
        System.out.println("IA");
        Player.pionIA();
    }

    public static void displayMenuCouleurP1() throws ParseException {
        do {
            System.out.println(ConsoleColors.GREEN + "  -- Menu Couleur--");
            System.out.println("1. RED");
            System.out.println("2. GREEN");
            System.out.println("3. DARK GREEN");
            System.out.println("4. YELLOW");
            System.out.println("5. PURPLE");
            System.out.println("6. CYAN");
            System.out.println("7. BLUE");
            System.out.println("q. Quitter le menu" + ConsoleColors.DEFAULT);

            String input = CustomeUtils.getUserInput();

            switch (input) {
                case "1":
                    couleur1 = ConsoleColors.RED;
                    break;
                case "2":
                    couleur1 = ConsoleColors.GREEN;
                    break;
                case "3":
                    couleur1 = ConsoleColors.DARK_GREEN;
                    break;
                case "4":
                    couleur1 = ConsoleColors.YELLOW;
                    break;
                case "5":
                    couleur2 = ConsoleColors.PURPLE;
                    break;
                case "6":
                    couleur2 = ConsoleColors.CYAN;
                    break;
                case "7":
                    couleur2 = ConsoleColors.BLUE;
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
    public static void displayMenuCouleurP2() throws ParseException {
        do {
            System.out.println(ConsoleColors.GREEN + "  -- Menu Couleur--");
            System.out.println("1. RED");
            System.out.println("2. GREEN");
            System.out.println("3. DARK GREEN");
            System.out.println("4. YELLOW");
            System.out.println("5. PURPLE");
            System.out.println("6. CYAN");
            System.out.println("7. BLUE");
            System.out.println("q. Quitter le menu" + ConsoleColors.DEFAULT);

            String input = CustomeUtils.getUserInput();

            switch (input) {
                case "1":
                    couleur2 = ConsoleColors.RED;
                    break;
                case "2":
                    couleur2 = ConsoleColors.GREEN;
                    break;
                case "3":
                    couleur2 = ConsoleColors.DARK_GREEN;
                    break;
                case "4":
                    couleur2 = ConsoleColors.YELLOW;
                    break;
                case "5":
                    couleur2 = ConsoleColors.PURPLE;
                    break;
                case "6":
                    couleur2 = ConsoleColors.CYAN;
                    break;
                case "7":
                    couleur2 = ConsoleColors.BLUE;
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
}