
import java.io.IOException;
import java.text.ParseException;
//import java.io.FileNotFoundException;
//import java.io.FilePermission;
import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.BufferedWriter;
import java.io.FileReader;
//import java.io.FileWriter;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.ArrayList;
// import java.util.stream.Collectors;
import java.util.ArrayList;
import model.ConsoleColors;
import model.CustomeUtils;
//import model.Classement;

import java.util.*;
/**
 * Ensemble des méthodes qui permettent d'afficher différents menus et gérer les
 * choix de l'utilisateur
 */
public class Menu {
    public static String couleur1 = "💙";
    public static String couleur2 = "💔";
    

    // public static void lister() throws IOException{
    //     String pathFile = "src/Top10.csv";
    //     String line = " ";

    //     try{
    //         BufferedReader br = new BufferedReader(new FileReader(pathFile));
    //         while((line =br.readLine())!=null){
    //             System.out.println(line);
    //         }
    //         System.out.println("File found");
    //     }

    //     catch(FileNotFoundException e){
    //         e.printStackTrace();
    //         System.out.println("File not found");
    //     }
    // }
    static int bestScore = 0;
    static String bestPlayer = "";
    public static Object main;




    // static void top10ToCsv() {
    //     try (BufferedWriter bw = new BufferedWriter(new FileWriter("Top10.csv"))) {
    //         for (Classement score : topTen) {
    //             String contactString = contact.toString();
    //             bw.write(contactString);
    //             bw.newLine();
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }




    // public static void lister(String[] args) {
    //     String csvFile = "Top10.csv";
    //     String line = "";
    //     String cvsSplitBy = ";";
    //     try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
    //         while ((line = br.readLine()) != null) {
    //             String[] player = line.split(cvsSplitBy);
    //             String name = player[0];
    //             int score = Integer.parseInt(player[1]); 
    //             if (score > bestScore) {
    //                 bestScore = score;
    //                 bestPlayer = name;
    //             }
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     System.out.println("Le joueur avec le meilleur score est " + bestPlayer + " avec " + bestScore + " points.");
    // }



    
    // public static void lister(String filePath) {
    //     List<String> scores = new ArrayList<>();
    //     String line;
    //     String cvsSplitBy = ";";
    //     try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
    //         while ((line = br.readLine()) != null) {
    //             String[] score = line.split(cvsSplitBy);
    //             scores.add(score[0].toString());
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     Collections.sort(scores, Collections.reverseOrder());
    //     for (String score : scores) {
    //         System.out.println(score);
    //     }
    // }
    

    public static void lister(String filePath) {
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
        for (int i = 0; i < 10; i++) {
            System.out.println("Joueur: " + scores.get(i)[0] + " avec un score de " + scores.get(i)[1]);
        }
    }





    // public void topTenToCsv() {

    //     try (BufferedWriter pw = new BufferedWriter(new FileWriter(this.filename))) {
    //         for (Classement score : topTen) {
    //             String stringScore = score.toString();
    //             pw.write(stringScore);
    //             pw.newLine();
    //         }
    //     } catch (IOException e) {
    //         System.out.println("Erreur lors de l'écriture du fichier");
    //     }
    // }

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
                    lister("Top10.csv");
                    //Classement.afficherClassement();
                    //rator.compare();
                    //ScoreComparator.main(null);
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
    public static void DiffIA() throws ParseException {

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
    

    public static void quit() {
        System.out.println(ConsoleColors.RED + "Fermeture du menu..." + ConsoleColors.DEFAULT);
    }

    public static void settingP1(){
        Player.currentPlayer ="1";
        System.out.println("Joueur1");
        System.out.println("Veuillez choisir le nom de votre choix");
        Player.setNom();
        System.out.println("Veuillez choisir le symbole de votre choix");;
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
    public static void displayMenuCouleurP2() throws ParseException {
        do {
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