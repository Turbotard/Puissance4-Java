
import java.io.IOException;
import java.text.ParseException;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.ArrayList;
// import java.util.stream.Collectors;
import java.util.ArrayList;
import model.ConsoleColors;
import model.CustomeUtils;


/**
 * Ensemble des méthodes qui permettent d'afficher différents menus et gérer les
 * choix de l'utilisateur
 */
public class Menu {
    public static String couleur1;
    public static String couleur2;
    

    public static void lister() throws IOException{
        String pathFile = "src/Top10.csv";
        String line = " ";

        try{
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            while((line =br.readLine())!=null){
                System.out.println(line);
            }
            System.out.println("File found");
        }

        catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found");
        }
    }
    /**
     * Affiche le menu principal et gère les choix de l'utilisateur
     * @throws IOException
     */
    public static void displayMenu() throws ParseException, IOException {
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
                    lister();
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
    public static void DiffIA() throws ParseException {

        System.out.println("1. Difficulté 1");
        System.out.println("2. difficulté 2");
        String input = CustomeUtils.getUserInput();
        switch (input){
            case "1":
                settingP1();
                settingIA();
                lvl =1;
                Jeu.jeusolo();
                
                break;
            case "2":
                settingP1();
                settingIA();
                lvl =2;
                Jeu.jeusolo();
                
                break;
            default:
                System.out.println("Veuillez entrer une option valide de difficulté");
                break;
        }
    }
    

    public static void quit() {
        System.out.println(ConsoleColors.RED + "Fermeture du menu..." + ConsoleColors.DEFAULT);
    }

    public static void settingP1(){
        Player.currentPlayer ="1";
        System.out.println("Joueur1");
        System.out.println("Veuillez choisir le nom de votre choix");
        Player.setNom();
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
        Player.currentPlayer ="2";
        System.out.println("Joueur 2");
        System.out.println("Veuillez choisir le nom de votre choix");
        Player.setNom();
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
        Player.currentPlayer ="2";
        Player.pseudo2 ="IA";
        Player.pion2 = "X";

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


    private static void listerContact() throws IOException, ParseException{

    }
}