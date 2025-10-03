import java.util.ArrayList;
import java.util.Scanner;

public class Premiers {
    private static Scanner kyb = new Scanner(System.in);

    private static boolean isPrime(int n){
        boolean premier = true;
        if(n%2 == 0 && n!=2){
            premier = false;
        }
        else if(n!=1){
            for(int i = 2; i <= Math.sqrt(n); i++){
                if (n % i == 0) premier = false;
            }
        }
        return premier;
    }

    public static void main(String[] args) {
        System.out.print("Quel est le nombre que vous voulez tester ? ");
        int n = kyb.nextInt();
        ArrayList<Integer> primeTable = new ArrayList<>();


        for(int i = 0; i <= n; i++){
            if(isPrime(i)) primeTable.add(i);
        }
        for(int number : primeTable){
            System.out.println(number);
        }
    }
}
