import java.util.Scanner;

public class Degre2 {
    private static Scanner kyb = new Scanner(System.in);

    public static void main (String[] args){
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;

        do{
            System.out.println("Choissisez la valeur non nulle pour a :");
            a = kyb.nextDouble();
        } while (a == 0.0);

        System.out.println("Choissisez la valeur de b :");
        b = kyb.nextDouble();
        System.out.println("Choissisez la valeur de c :");
        c = kyb.nextDouble();

        double delta = (b*b) - (4.0*a*c); // Je peux mettre 4 ??

        if (delta < 0){
            System.out.println("Pas de solutions réelles");
            System.exit(0);
        }
        else if (delta > 0){
            System.out.println("Il y a deux solution : " +  (-b + Math.sqrt(delta))/(2.0*a)
                    + " et " + (-b - Math.sqrt(delta))/(2.0*a));
        }
        else{
            System.out.println("Une solution : " + (-b /(2.0*a)));
        }
    }
}
