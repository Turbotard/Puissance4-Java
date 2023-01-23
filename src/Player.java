public class Player {
    private int currentPlayer;

    public Player() {
        currentPlayer = 1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void changePlayer() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }
}
