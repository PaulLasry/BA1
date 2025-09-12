import java.time.Year;
import java.util.Scanner;

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
    //Calcul de polynômes
    public static void main(String[] args){
        Scanner kyd = new Scanner(System.in);
        System.out.print("Choississez un a :");
        int a = kyd.nextInt();
        System.out.print("Choississez un b :");
        int b = kyd.nextInt();
        System.out.print("Choississez un c :");
        int c = kyd.nextInt();
        System.out.print("Choississez un x :");
        double x = kyd.nextDouble();

        System.out.println("La valeur du poloynôme est : " + (((a+b)/2)*(x*x*x) + ((a+b)*(a+b))*(x*x) + (a + b + c)));
        kyd.close();
    }
}

class Ex4{
    public static void main(String[] args){
        Scanner kyd = new Scanner(System.in);
        System.out.print("Choisissez un x : ");
        int x = kyd.nextInt();
        System.out.print("Choississez un y : ");
        int y = kyd.nextInt();
        System.out.println();
        System.out.println("x avant permutation : " + x);
        System.out.println("y avant permutation : " + y);

        int z = x;
        x = y;
        y = z;
        System.out.println();
        System.out.println("x après permutation : " + x);
        System.out.println("y après permutation : " + y);
    }
}
