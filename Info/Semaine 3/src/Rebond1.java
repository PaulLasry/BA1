import java.util.Scanner;

public class Rebond1 {
    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args) {
        final double g = 9.81;
        double H0 = 0;
        double h = 0;
        double eps = 0;
        int nbr = 0;
        double v = 0;
        do{
            System.out.print("Choisissez une hauteur H0 : ");
            H0 = kyb.nextDouble();
            System.out.print("Choisissez une variable eps entre 0 et 1 non compris : ");
            eps = kyb.nextDouble();
            System.out.print("Choisissez un nombre de rebond : ");
            nbr = kyb.nextInt();
        } while (H0 >= 0 && (eps < 0 && eps > 1) && nbr < 0);

        h = H0;
        for(int i = 1; i <= nbr; ++i){
            v = Math.sqrt(2*g*h);
            v = eps * v;
            h= (v*v)/(2*g);
        }
        System.out.print("La hauteur après " + nbr + " rebonds est " + h + " mètres");
    }
}
