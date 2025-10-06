import java.util.Scanner;

/*
 *   Author :    Paul Lasry-Robin
 *   Dare :      $(Date)
 */
public class Rectangle {
    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduisez la hauteur du rectangle ");
        double hauteur = kyb.nextDouble();
        System.out.print("Introduisez la largeur du rectangle ");
        double largeur = kyb.nextDouble();
        double resultat = 0;

        if (!testDonee(hauteur, largeur)){
            System.out.println("Les données ne sont pas valides");
            return;
        }

        System.out.println( "Résultat : " + calcul(hauteur, largeur));
    }


    static boolean testDonee(double hauteur, double largeur){
        return !(hauteur < 0) && !(largeur < 0);
    }

    static double calcul(double hauteur, double largeur){
        while (true){
            System.out.print("Voulez vous le périmètre (p/P) ou la surface (s/S) ? ");
            char calculVoulus = kyb.next().charAt(0);

            switch (calculVoulus){
                case 's':
                case 'S':
                    return hauteur * largeur;
                case 'p':
                case 'P':
                    return 2 *(hauteur + largeur);
                default:
                    System.out.println("Choix invalide, selectionez un bonne option.");
            }
        }

    }
}
