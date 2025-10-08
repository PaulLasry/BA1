import java.util.ArrayList;

/*
 *   Author :    Paul Lasry-Robin
 *   Dare :      $(Date)
 */
public class NomreAmicaux {

    static int sommeDiviseur(int number){
        int sommeDiviseur = 0;

        for(int i = 1; i<=number; i++){
            if(number % i == 0){
                sommeDiviseur += i;
            }
        }

        return sommeDiviseur;
    }

    static boolean isAmicaux(int a, int b){
        int sommeDiviseurA = sommeDiviseur(a);
        int sommeDiviseurB = sommeDiviseur(b);
        if ( (sommeDiviseurA == sommeDiviseurB) || ( (sommeDiviseurA + sommeDiviseurB) == (a + b) )){
            return true;
        }
        return false;
    }

    static void afficherTableau(int[] numbers){
        for(int i = 0; i<numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
    }

    static void afficherAmicaux(int[] numbers){
        ArrayList<int[]> listeCouple = new ArrayList<>();

        for(int i = 0; i<numbers.length; i++){
            for(int k = i+1; k < numbers.length; k++){
                if (isAmicaux(numbers[i], numbers[k])) {
                    int[] couple = new int[]{numbers[i], numbers[k]};
                    listeCouple.add(couple);
                }
            }
        }

        System.out.println("Les paires de nombres amicaus sont : ");
        for(int[] couple : listeCouple){
            afficherTableau(couple);
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        int[] nombres = {1210, 45, 27, 220, 54, 284, 9890, 120, 1184};
        System.out.println("Les paires de nombres amicaux sont : ");
        afficherAmicaux(nombres);
    }
}
