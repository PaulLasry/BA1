import java.util.Scanner;

public class Convertion {
    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduisez un caractère de l'alphabet : ");
        char caractere = kyb.next().charAt(0);

        if ((int)caractere <65 || (int)caractere>122){
            System.out.println("Le caractère n'est pas valide");
        }
        else {
            int nouvelleLettre = 0;
            if ((int)caractere<97){
                nouvelleLettre = (int)caractere + 32;
                System.out.println("\tVersion minuscule : " + (char)nouvelleLettre);
            }
            else {
                nouvelleLettre = (int)caractere - 26;
                System.out.println("\tVersion majuscule : " + (char)nouvelleLettre);
            }
        }
    }
}
