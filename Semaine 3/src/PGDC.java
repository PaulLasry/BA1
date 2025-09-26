import java.util.Scanner;

public class PGDC {
    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez le premier nombre : ");
        int a = kyb.nextInt();
        System.out.print("Entrez le deuxième nombre : ");
        int b = kyb.nextInt();
        boolean trouve = false;
        /*
        for (int i = Math.max(a, b); i>=1 && !trouve; i--){
            if(a % i == 0 && b % i == 0){
                System.out.println("Le plus grand diviseur commun de "+ a + " et " + b+ " est " + i);
                trouve=true;
            }
        }
        */
        //Le code de la prof
        int c = 0;
        while(a != b){
                if (a > b){
                    a -= b;
                }
                else {
                    b -= a;
                }
        }
        System.out.println("Le plus grand diviseur commun est " + a);
    }
}
