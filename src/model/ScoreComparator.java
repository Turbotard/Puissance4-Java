package model;
import java.util.Comparator;

public class ScoreComparator implements Comparator<Score>{
    private int Score;

    public void comparableScore(int Score){
        this.Score = Score;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score){
        Score = score;
    }



    @Override
    public int compare(Score o1, Score o2) {

        int compareScore = o1.getScore() - o2.getScore();
        // TODO Auto-generated method stub
        return compareScore;
    }
    
}
