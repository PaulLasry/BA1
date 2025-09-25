import java.util.Scanner;

public class PairImpair {
    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Choissisez un nombre entier : ");
        int number = kyb.nextInt();

        boolean pair= false;
        boolean negatif = false;

        if (number < 0){
            negatif = true;
        }
        if (number % 2 == 0){
            pair = true;
        }

        System.out.println("Le nombre est " + ((pair) ? "pair" : "impair") + " et " +
                ((negatif) ? "négatif" : "positif"));

    }
}
