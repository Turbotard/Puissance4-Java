import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
            
        Power4Grid mygrid = new Power4Grid();
        mygrid.displayGrid();
        Pion mypion = new Pion(mygrid);
        Pion.addPion(3);
        mygrid.displayGrid();  
        Pion.addPion(3);
        mygrid.displayGrid();
        

    }
}
