import java.util.Scanner;

public class Intervalle {
    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Choissisez un nombre entier : ");
        int number = kyb.nextInt();

        boolean inI = false;

        if ((number >= 2 && number < 3) || (number > 0 && number <= 1) || (number >= -10 && number <= -2)){
            System.out.println("x appartient à I ");
        }
        else {
            System.out.println("x n'appartient pas à I ");
        }
    }
}
