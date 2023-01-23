public class Pion {
    private static char pion;
    public Pion(char pion) {
        this.pion = pion;
    }

    public static void placerPion(char[][] grille, int x, int y) {
        grille[x][y] = pion;
    }
}
