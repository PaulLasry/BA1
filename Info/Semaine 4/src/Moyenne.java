import java.util.Scanner;

public class Moyenne {
    private static Scanner kyb = new Scanner(System.in);

    public static void main(String[] args) {

        int nombreEtudiants;
        System.out.print("Donnez le nombre d'etudiants : ");
        nombreEtudiants = kyb.nextInt();

        double moyenne = 0.0;
        // Initialise un tableau pouvant contenir autant
        // de notes que d'étudiants

        double [] notes = new double[nombreEtudiants];
        double sum = 0;

        for (int i = 0; i < nombreEtudiants; i++){
            System.out.print("Introduisez de l'étudiant " + (i+1) + " : ");
            notes[i] = kyb.nextDouble();
            sum += notes[i];
        }
        moyenne = sum/nombreEtudiants;
        System.out.println("La moyenne de classe est " + moyenne);

        for(int i = 0; i < nombreEtudiants; i++){
            System.out.println("\t" +
                    i + " est " + notes[i] + " (" + (notes[i] - moyenne) + ")");
        }
    }
}
