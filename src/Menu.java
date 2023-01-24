
import java.text.ParseException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import model.CustomeUtils;
import model.ConsoleColors;

/**
 * Ensemble des méthodes qui permettent d'afficher différents menus et gérer les
 * choix de l'utilisateur
 */
public class Menu {

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
                    Jeu.jeusolo();
                    break;
                case "2":
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
}