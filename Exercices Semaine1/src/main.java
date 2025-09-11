import java.time.Year;
import java.util.Scanner;
import java.util.Date;

//Ceci est un exemple
class IMC{
    public static void main(String[] args){
        Scanner kyd = new Scanner(System.in);
        double poids;
        double taille;

        System.out.println("Entrez votre poids (en kg) :");
        poids = kyd.nextDouble();
        System.out.println("Entrez votre taill (en m) :");
        taille = kyd.nextDouble();

        double imc = poids / (taille * taille);

        System.out.println("Pour " + poids + " kilos et " + taille + " m, l'IMC est de " + imc);

        kyd.close();
    }
}

class Ex1{
    //Le but de ce programme est d'estimer l'âge de l'utilisateur
    public static void main(String[] args){
        Scanner kyd = new Scanner(System.in);

        int age;
        int anneActuelle = Year.now().getValue();

        System.out.println("Donnez votre âge : ");
        age = kyd.nextInt();
        System.out.println("Vous êtes né en : " + (anneActuelle - age));
    }
}

class Ex2{
    //Le but de ce programme est d'estimer les quantité de fromages nécessaires en fonction du nombre de convive
    public static void main(String[] args){
        final int BASE = 4;
        Scanner kyd = new Scanner(System.in);
        double fromage = 800.0, eau = 2.0, ail = 2.0, pain = 400.0;

        System.out.println("Entrez le nombre de convive : ");
        int nombreConvive = kyd.nextInt();

        System.out.println("Vous aurez besoin de : ");
        System.out.println("   - " + (fromage/BASE) * nombreConvive + " grammes de fromage");
        System.out.println("   - " + (eau/BASE) * nombreConvive + " décilitres d'eau");
        System.out.println("   - " + (ail/BASE) * nombreConvive + " de gousses d'ail");
        System.out.println("   - " + (pain/BASE) * nombreConvive + " grammes de pain");
        kyd.close();
    }
}

class Ex3{

}