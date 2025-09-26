import java.util.Scanner;

public class Bilan {
    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args){
        int n = 0;
        int monant = 0;
        int montnantTotal = 0;
        int montantMin = 0;
        int montantMax = 0;

        do{
            System.out.print("Donnez n positif: ");
            n = kyb.nextInt();
        }while (n < 0);

        for (int i = 1; i<=n; ++i){
            do{
                System.out.print("Donnez le montant positif : ");
                monant = kyb.nextInt();
                montnantTotal += monant;

                if (i == 1){
                    montantMin = monant;
                }

                if (montantMax < monant){
                    montantMax=monant;
                }

                if (montantMin>monant ){
                    montantMin=monant;
                }
            } while (monant < 0);
        }

        System.out.println("Le montant moyen mensuel : " + montnantTotal/n);
        System.out.println("Le montant minimum : " + montantMin);
        System.out.println("Le montant maximum : " + montantMax);
    }
}
