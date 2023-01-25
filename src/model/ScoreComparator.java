package model;

/// package model;
// import java.util.Comparator;

// public class ScoreComparator implements Comparator<Score>{
//     private int Score;

//     public void comparableScore(int Score){
//         this.Score = Score;
//     }

//     public int getScore() {
//         return Score;
//     }

//     public void setScore(int score){
//         Score = score;
//     }



//     @Override
//     public int compare(Score o1, Score o2) {

//         int compareScore = o1.getScore() - o2.getScore();
//         // TODO Auto-generated method stub
//         return compareScore;
//     }
    
// }


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScoreComparator {
    
    public static void main(String[] args) {
        String csvFile = "src/Top10.csv";
        String line = "";
        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] player = line.split(cvsSplitBy);
                String name = player[0];
                int score = Integer.parseInt(player[1]);
                if (score > bestScore) {
                    bestScore = score;
                    bestPlayer = name;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Le joueur avec le meilleur score est " + bestPlayer + " avec " + bestScore + " points.");
    }
}
