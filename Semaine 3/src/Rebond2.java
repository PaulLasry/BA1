import java.util.Scanner;

public class Rebond2 {
    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args) {
        final double g = 9.81;
        double H0 = 0;
        double hFin = 0;
        double eps = 0;
        int nbr = 0;
        double v = 0;
        do{
            System.out.print("Choisissez une hauteur H0 : ");
            H0 = kyb.nextDouble();
            System.out.print("Choisissez une variable eps entre 0 et 1 non compris : ");
            eps = kyb.nextDouble();
            System.out.print("Choisissez la hauteur de fin : ");
            hFin = kyb.nextInt();
        } while (H0 >= 0 && (eps < 0 && eps > 1) && H0>hFin);


        System.out.print("La hauteur après " + nbr + " rebonds est " + hFin + " mètres");
    }
}
