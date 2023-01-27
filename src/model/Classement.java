package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Classement {

    private String filename;
    private String name;
    private int move;

    private static ArrayList<Classement> topTen = new ArrayList<Classement>();

    /**
     * auteur Lucas
     * Créer le classement
     * @param filename
     */
    public Classement(String filename) {
        this.filename = filename;
    }

    public Classement() {
    }

    /**
     * auteur Lucas
     * Envoie le CSV dans la variable topten
     * @throws IOException
     */
    public void csvToTopTen() throws IOException{
        try (BufferedReader pw = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = pw.readLine()) != null) {
                try {
                    String[] valeurs = line.split(";");

                    String name = valeurs[0];
                    int move = Integer.parseInt(valeurs[1]);
                    Classement score = new Classement();
                    score.setName(name);
                    score.setMove(move);

                    topTen.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Erreur lors de la ligne");
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier");
        }
    }

    /**
     * auteur Lucas
     * envoie le contenue de la variable topten dans le fichier CSV
     */
    public static void topTenToCsv() {

        try (BufferedWriter pw = new BufferedWriter(new FileWriter("Top10.csv"))) {
            for (Classement score : topTen) {
                String stringScore = score.toString();
                pw.write(stringScore);
                pw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier");
        }
    }

    /**
     * auteur Lucas
     * Permet de sauvegarder le classement des 10 premiers
     * @param name
     * @param move
     */
    public void saveClassement(String name, int move) {
        setName(name);
        setMove(move);

        for (Classement score : topTen) {
            if (move < score.getMove()) {
                int index = topTen.indexOf(score);
                topTen.add(index, this);
                if (topTen.size() > 10) {
                    topTen.remove(10);
                }
                break;
            }
        }
        if(topTen.size()<10){
            topTen.add(this);
        }
        afficherClassement(); 
        topTenToCsv();
    }

    /*          
     * Auteur Lucas
     * récupere le nom du joueur
     */

    public String getName() {
        return name;
    }

    /*          
     * Auteur Lucas
     * récupere le nombre de coup du joueur
     */

    public int getMove() {
        return move;
    }

    /*          
     * Auteur Lucas
     * permet de set le nom du joueur
     */
    public void setName(String name) {
        this.name = name;
    }

    /*          
     * Auteur Lucas
     * permet de set le nombre de coup du joueur
     */
    public void setMove(int move) {
        this.move = move;
    }

    /**
     * auteur Lucas
     * Permet d'afficher le classement des 10 premiers joueurs
     * 
     */
    public static void afficherClassement() {
        for (Classement score : topTen) { 
            String scoreString = score.toString();
    
            scoreString = scoreString.replace(";", " : ");
    
            System.out.println(scoreString);
        }
    }
    
    /*          
     * Auteur Lucas
     * permet de convertir des int en String
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getName());
        builder.append(";");
        builder.append(this.getMove());
        return builder.toString();
    }
} 




