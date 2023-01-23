import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
            //DEBUT DU PROGRAMME
            
            Scanner scanner = new Scanner(System.in);
            
            
            //Le plateau vertical de jeu:
            //alignement requis :
            int N = 4;
            //colonnes et lignes :
            int C = 7;
            int L = 6;
            //tableau du plateau ('.' = emplacement vide  / 'X' = joueur 1  /  'O'  = joueur 2)
            char[][] plateau = new char[C][L];
            //remplissage des cases avec du vide, oui c'est paradoxal !
            for(int x = 0 ; x < C ; x++){
                for(int y = 0 ; y < L ; y++)
                    plateau[x][y] = '.';
            }
        
            for(int i = 1 ; i <= C*L ; i++){
                    
            System.out.println("Tour " + i + ", Etat du plateau :");
                    
                    for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
                    System.out.println();
                    
                    for(int y = 0 ; y < L ; y++){
                        System.out.print('|');
                        for(int x = 0 ; x < C ; x++){
                            System.out.print(" " + plateau[x][y] + " ");
                        }
                        System.out.print('|');
                        System.out.println();
                    }
                    
                    for(int loop = 0 ; loop < C+2+2*C ; loop++)System.out.print('-');
                    System.out.println();
                    
                }
        }    }
