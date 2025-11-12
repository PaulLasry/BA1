import java.util.Scanner;
import java.util.SimpleTimeZone;

/*
 *   Author :    Paul Lasry-Robin
 *   Dare :      $(Date)
 */
class Cesure {

    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args) {
        String[] phrase = lirePhrase();
        for (int i = 0; i < phrase.length; i++) {
            cesure(phrase[i]);
        }
    }

    static String[] lirePhrase() {
        // A compléter:
        // retourne un tableau de chaines de caractères
        // introduits par l'utilisateur

        System.out.print("Donnez le nombre de mots dans votre phrase: ");
        int nombreMots = kyb.nextInt();
        String[] listeMots = new String[nombreMots];

        for(int i = 0; i < nombreMots; i++){
            System.out.print("Donnez le mot "+ (i+1) +" : ");
            String tmp = kyb.next();
            tmp = tmp.toLowerCase();
            for(int k = 0; k < tmp.length(); k++){
                if(!((int) tmp.charAt(k) >= 97 && (int) tmp.charAt(k) <= 122 )){
                    throw new IllegalArgumentException(
                            "La chaîne contient un caractère non permis : " + tmp.charAt(k)
                    );
                }
            }
            listeMots[i] = tmp;
        }
        return listeMots;
    }

    static boolean voyelle(char c) {
        // A compléter:
        // teste si un caractère est une voyelle
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u', 'y' -> true;
            default -> false;
        };
    }

    static boolean queVoyelles(String s) {
        // A compléter:
        // teste si une chaîne ne contient que des voyelles
        // utilise la méthode voyelle
        for(int i = 0; i < s.length(); i++){
            if (!voyelle(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static void cesure(String mot) {
        // A compléter:
        // détermine la césure d'un mot donné et effectue les affichages
        // correspondants (voir exemple de déroulement
        if(queVoyelles(mot)){
            System.out.println(mot);
        }else {
            for (int i = 1; i < mot.length(); i++){

                if( (!voyelle(mot.charAt(i)) && voyelle(mot.charAt(i-1))) &&
                        (mot.substring(i).length() !=1) )
                {
                    System.out.print(mot.substring(0, i) + "-" + "\n");
                    cesure(mot.substring(i));
                    break;
                } else if ((mot.substring(i).length() == 1)) {
                    System.out.println(mot);
                }
            }
        }
    }
}
