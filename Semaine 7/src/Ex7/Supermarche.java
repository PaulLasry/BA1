package Ex7;

import java.time.LocalDate;
import java.util.ArrayList;

public class Supermarche {

	public static void main(String[] args) {
		// Les articles vendus dans le supermarché
		Article choufleur = new Article("Chou-fleur extra", 3.50, false);
		Article roman = new Article("Les malheurs de Sophie", 16.50, true);
		Article camembert = new Article("Cremeux 100%MG", 5.80, false);
		Article cdrom = new Article("C++ en trois jours", 48.50, false);
		Article boisson = new Article("Petit-lait", 2.50, true);
		Article petitspois = new Article("Pois surgeles", 4.35, false);
		Article poisson = new Article("Sardines", 6.50, false);
		Article biscuits = new Article("Cookies de grand-mere", 3.20, false);
		Article poires = new Article("Poires Williams", 4.80, false);
		Article cafe = new Article("100% Arabica", 6.90, true);
		Article pain = new Article("Pain d'epautre", 6.90, false);

		// Les caddies du supermarché
		Caddie caddie1 = new Caddie();
		Caddie caddie2 = new Caddie();
		Caddie caddie3 = new Caddie();

		// Les caisses du supermarché
		// le premier argument est le numero de la caisse
		// le second argument est le montant initial de la caisse.
		Caisse caisse1 = new Caisse(1, 0.0);
		Caisse caisse2 = new Caisse(2, 0.0);

		// les clients font leurs achats
		// le second argument de la méthode remplir
		// correspond à une quantite

		// remplissage du 1er caddie
		caddie1.remplir(choufleur, 2);
		caddie1.remplir(cdrom, 1);
		caddie1.remplir(biscuits, 4);
		caddie1.remplir(boisson, 6);
		caddie1.remplir(poisson, 2);

		// remplissage du 2eme caddie
		caddie2.remplir(roman, 1);
		caddie2.remplir(camembert, 1);
		caddie2.remplir(petitspois, 2);
		caddie2.remplir(poires, 2);

		// remplissage du 3eme caddie
		caddie3.remplir(cafe, 2);
		caddie3.remplir(pain, 1);
		caddie3.remplir(camembert, 2);

		// Les clients passent à la caisse
		caisse1.scanner(caddie1);
		caisse1.scanner(caddie2);
		caisse2.scanner(caddie3);
		
		caisse1.totalCaisse();
		caisse2.totalCaisse();
	}
}

class Article{
    private final String nom;
    private final double prix;
    private final boolean enSolde;

    public Article(String nom, double prix, boolean enSolde){
        this.nom = nom;
        if(prix < 0){
            prix *= -1;
        }
        this.prix = prix;
        this.enSolde = enSolde;
    }

    public double getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }

    public boolean isEnSolde() {
        return enSolde;
    }
}

class Achat{
    private final Article article;
    private final int quantite;

    public Achat(Article article, int quantite){
        this.article = article;
        if(quantite < 0){
            quantite *= -1;
        }
        this.quantite = quantite;
    }

    public void afficher(){
        String nom = article.getNom();
        double prix = article.getPrix();
        boolean isEnSolde = article.isEnSolde();

        if(isEnSolde){
            prix /= 2;
        }

        System.out.println(nom + " : " + prix + "x" + quantite + " = " + prix*quantite
                + (isEnSolde ? " \t(1/2 prix)" : ""));
    }

    public double getPrix(){
        if(article.isEnSolde()){
            return (article.getPrix()/2.0) * quantite;
        }
        return article.getPrix() * quantite;
    }
}

class Caddie{
    private final ArrayList<Achat> achats;

    public Caddie(){
        this.achats = new ArrayList<>();
    }


    public void remplir(Article article, int nombre){
        achats.add(new Achat(article, nombre));
    }

    public double prixTotal(){
        double prixTotal = 0;
        for(Achat achat : achats){
            prixTotal += achat.getPrix();
        }
        return prixTotal;
    }

    public void afficher(){
        for(Achat achat : achats){
            achat.afficher();
        }
        System.out.println();
    }
}

class Caisse{
    private final int numeroCaisse;
    private double montantTotal;

    public Caisse(int numeroCaisse, double montantInitial){
        this.numeroCaisse = numeroCaisse;
        this.montantTotal = montantInitial;
    }

    public void totalCaisse(){
        System.out.println("La caisse " + numeroCaisse + " a encaisse " + montantTotal + " Frs. aujourd'hui.");
    }

    public void scanner(Caddie caddie){
        System.out.println("====================");
        System.out.println(LocalDate.now());
        System.out.println("Caisse numéro "+numeroCaisse + "\n");
        caddie.afficher();

        montantTotal += caddie.prixTotal();
        System.out.println("Montant à payer : " + caddie.prixTotal());
        System.out.println("====================");
    }
}