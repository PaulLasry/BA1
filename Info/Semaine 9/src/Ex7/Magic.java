package Ex7;

import java.util.ArrayList;

class Magic {
	public static void main(String[] args) {
		Jeu maMain = new Jeu();

		maMain.piocher(new Terrain('b'));
		maMain.piocher(new Creature(6, "Golem", 4, 6));
		maMain.piocher(new Sortilege(1, "Croissance Gigantesque", 
				"La créature ciblée gagne +3/+3 jusqu'à la fin du tour"));

		System.out.println("Là, j'ai en stock :");
		maMain.afficher();
		maMain.joue();
	}
}

class Jeu{
    ArrayList<Carte> deckCartes;

    public Jeu(){
        this.deckCartes = new ArrayList<>();
    }

    public void piocher(Carte carte){
        deckCartes.add(carte);
    }

    public void joue(){
        deckCartes.set(0, null);
    }

    public void afficher(){
        for(Carte carte : deckCartes){
            if(carte == null) System.out.print("");
            else carte.afficher();
        }
    }
}

abstract class Carte {
    private double cost;
    public Carte(double cost){
        this.cost = cost;
    }

    public void afficher(){
        System.out.println("\tCout : " + cost);
    }
}

abstract class CarteNominatives extends Carte {
    private String nom;
    public CarteNominatives(double cost, String nom) {
        super(cost);
        this.nom = nom;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("\tNom : " + nom);
    }
}

class Terrain extends Carte {
    private char color;

    public Terrain(char color){
        super(0);
        this.color = color;
    }

    @Override
    public void afficher() {
        System.out.println("Terrain : ");
        super.afficher();
        String couleur = switch (color) {
            case 'B' -> "Blanc";
            case 'b' -> "Bleu";
            case 'n' -> "Noir";
            case 'r' -> "Rouge";
            case 'v' -> "Vert";
            default -> "";
        };
        System.out.println("\tCouleur : " + couleur);
    }
}

class Sortilege extends CarteNominatives {
    private String description;
    public Sortilege(double cost, String nom, String description) {
        super(cost, nom);
        this.description = description;
    }

    @Override
    public void afficher() {
        System.out.println("Sortilège :");
        super.afficher();
        System.out.println("\tDescription : " + description);
    }
}

class Creature extends CarteNominatives {
    private double dmg;
    private double hp;
    public Creature(double cost, String nom, double damage, double healPoint) {
        super(cost, nom);
        this.dmg = damage;
        this.hp = healPoint;
    }

    @Override
    public void afficher() {
        System.out.println("Créature :");
        super.afficher();
        System.out.println("\tDégats : " + dmg);
        System.out.println("\tDégats : " + hp);
    }
}