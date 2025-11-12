import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 *   Author :    Paul Lasry-Robin
 *   Dare :      $(Date)
 */
public class MasterMind {

    public static Scanner kyb = new Scanner(System.in);

    public static final int TAILLE_COMBINAISONS = 4;
    public static final int NOMBRE_ESSAIS = 10;

    public static void main(String[] args) {
        int[] laCombinaison = new int[4];
        int[] combinaison = new int[4];
        int count = 0;

        //tirerCombinaison(laCombinaison);
        laCombinaison = new int[]{1, 2, 3, 4};
        for(int n : laCombinaison) System.out.print(n + " ");

        while (!Arrays.equals(laCombinaison, combinaison)){
            int[] reponse = new int[2];
            count++;
            demanderCoup(combinaison);
            compare(laCombinaison, combinaison, reponse);
            afficheReponse(reponse);
        }

        System.out.println("Vous avez trouvé la bonne combinaison en " + count + " essais." );
    }

    static void tirerCombinaison(int[] uneCombinaison){
        for(int i = 0; i<uneCombinaison.length; i++){
            uneCombinaison[i] = hasard(6);
        }
    }

    static int hasard(int max) {
        return (1 + (int)(Math.random() * max));
    }

    static void demanderCoup(int[] uneCombinaison){
        System.out.println("Choisissez votre combinaison : ");
        for(int i = 0; i<uneCombinaison.length; i++){
            System.out.print("\t Nombre " + (i+1) + " ");
            uneCombinaison[i] = kyb.nextInt();
        }
    }

    private static void afficheReponse(int[] reponse) {
        StringBuilder strReponse = new StringBuilder();
        strReponse.append("#".repeat(reponse[0]));
        strReponse.append("0".repeat(reponse[1]));
        System.out.println(strReponse);
    }

    private static void compare(int[] laCombinaison, int[] combinaison, int[] reponse){
        int[] indexToExclude = new int[4];
        int[] tmpCombinaison = Arrays.copyOf(laCombinaison, TAILLE_COMBINAISONS);
        int[] tmpCombinaisonUtilisateur = Arrays.copyOf(combinaison, TAILLE_COMBINAISONS);

        //Verification 1
        for(int i = 0; i < TAILLE_COMBINAISONS; i++){
            int nombreADeviner = tmpCombinaison[i];
            int nombreDevine = tmpCombinaisonUtilisateur[i];

            if(nombreADeviner == nombreDevine){
                reponse[0] ++;
                tmpCombinaison[i] = -1;
                tmpCombinaisonUtilisateur[i] = -2;
            }
        }

        //Verification 2
        for(int i = 0; i < TAILLE_COMBINAISONS; i++){
            if(tmpCombinaisonUtilisateur[i] < 0) continue;

            for(int k = 0; k < TAILLE_COMBINAISONS; k++){
                if(tmpCombinaison[k] == tmpCombinaisonUtilisateur[i]){
                    reponse[1]++;
                    tmpCombinaison[k] = -1;
                    break;
                }
            }
        }
    }
}
