import java.util.Scanner;

public class Scalaire {
    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args) {
        final int nMax = 10;
        int n;
        do {
            System.out.print("Quelle est la dimension de vos vecteurs (entre 0 et " + nMax +") ? ");
            n = kyb.nextInt();
        } while(n > nMax && n<0);

        int[] v1 = new int[nMax];
        int[] v2 = new int[nMax];
        int produitScallaire = 0;

        for(int composante = 0; composante<n; composante++){
            System.out.print("Quelle est la composante v1_"+ composante + " ? ");
            v1[composante] = kyb.nextInt();
            System.out.print("Quelle est la composante v2_"+ composante+ " ? ");
            v2[composante] = kyb.nextInt();
        }

        for(int composante = 0; composante < n; composante++){
            produitScallaire += v1[composante]*v2[composante];
        }
        System.out.print(produitScallaire);
    }
}
