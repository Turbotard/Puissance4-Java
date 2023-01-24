public class Player {
    private String currentPlayer;

    public Player() {
        currentPlayer = "1";
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void changePlayer() {
        if (currentPlayer == "1") {
            currentPlayer = "2";
        } else {
            currentPlayer = "1";
        }
    }

}
