import java.util.Scanner;

/*
 *   Author :    Paul Lasry-Robin
 *   Dare :      $(Date)
 */
public class MasterMind {

    public static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args) {
        int[] laCombinaison = new int[4];
        int[] combinaison = new int[4];
    }

    static int hasard(int max) {
        return (1 + (int)(Math.random() * max));
    }

    static void tirerCombinaison(int[] uneCombinaison){
        for(int i = 0; i<uneCombinaison.length; i++){
            uneCombinaison[i] = hasard(10);
        }
    }

    static void demanderCoup(int[] uneCombinaison){
        System.out.print("Choisissez votre combinaison : ");
        for(int i = 0; i<uneCombinaison.length; i++){
            System.out.print("\t Nombre " + (i+1));
            uneCombinaison[i] = kyb.nextInt();
        }
    }
}
