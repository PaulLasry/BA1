import java.util.Scanner;

public class Palindromes {
    private static Scanner kyb = new Scanner(System.in);

    private static char toLowerCase(char lettre) {
        if ((int) lettre < 65 || (int) lettre > 122) {
            System.out.println("Le caractère n'est pas valide");
            throw new IllegalArgumentException();
        }

        int nouvelleLettre = lettre;
        if ((int) lettre < 97) {
            nouvelleLettre = (int) lettre + 32;
        }

        return (char)nouvelleLettre;
    }

    public static void main(String[] args) {
        System.out.print("Entrez votre chaine de caractères :");
        String phrase = kyb.nextLine();
        String phraseEpuree = "";
        String phraseRenversee = "";

        for(int i = 0; i<phrase.length(); i++){
            if(Character.isLetter(phrase.charAt(i))){
                phraseEpuree += toLowerCase(phrase.charAt(i));
            }
        }
        for(int i = 0; i<phraseEpuree.length(); i++){
            phraseRenversee += phraseEpuree.charAt((phraseEpuree.length() - 1) - i);
        }
        if (phraseRenversee.equals(phraseEpuree)){
            System.out.println("C'est un palindrôme ");
        }
        else System.out.println("Ce n'est pas un palindrôme");
    }
}
