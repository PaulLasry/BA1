package Ex5;

public class Banque2 {
    public static void main(String[] args) {
        Client client1 = new Client("Pedro", "Genève", true,1000.0, 2000.0);
        Client client2 = new Client("Alexandra", "Lausanne", false, 3000.0, 4000.0);

        System.out.println(client1);
        System.out.println(client2);

        client1.bouclerCompte();
        client2.bouclerCompte();

        System.out.println(client1);
        System.out.println(client2);
    }
}

class Client{
    private final double TAUX_PRIVE = 0.01;
    private final double TAUX_EPARGNE = 0.02;
    private final String nom;
    private final String ville;
    private final boolean masculin;
    private double soldePrive;
    private double soldeEpargne;

    public Client(String nom, String ville, boolean masculin,double soldePrive, double soldeEpargne){
        assert nom != null || ville != null;

        this.nom = nom;
        this.ville = ville;
        this.masculin = masculin;
        this.soldePrive = soldePrive;
        this.soldeEpargne = soldeEpargne;
    }

    public String toString() {
        // Cette méthode affiche les données du client
        if(masculin){
            return "Client " + nom + " de " + ville + "\n" + "   Compte prive:     " + soldePrive + " francs" + "\n"
                    + "   Compte d'epargne: " + soldeEpargne + " francs";
        } else {
            return "Cliente " + nom + " de " + ville + "\n" + "   Compte prive:     " + soldePrive + " francs" + "\n"
                    + "   Compte d'epargne: " + soldeEpargne + " francs";
        }
    }

    public void bouclerCompte() {
        // Cette méthode ajoute les intérêts au solde
        this.soldePrive += TAUX_PRIVE * soldePrive;
        this.soldeEpargne += TAUX_EPARGNE * soldeEpargne;
    }
}
